package com.kangaroo.microservices.provider.core.mybatis.transaction;

import java.util.Stack;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
public class MultiTransactionalAspect implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Around("@annotation(multiTransactional)")
	public Object around(ProceedingJoinPoint pjp, MultiTransactional multiTransactional) throws Throwable {
		Stack<MultiTransactionInfo> transactionInfos = new Stack<MultiTransactionInfo>();

		// push transactionInfos to current thread
		//MultiTransactionAspectSupport.setCurrentTransationInfos(transactionInfos);

		try {
			if (!openTransaction(transactionInfos, multiTransactional)) {
				return null;
			}

			Object ret = pjp.proceed();

			commit(transactionInfos);

			return ret;
		} catch (Throwable e) {
			rollback(transactionInfos);
			throw e;
		}
	}

	private boolean openTransaction(Stack<MultiTransactionInfo> multiTransactionInfos,
			MultiTransactional multiTransactional) {

		String[] transactionMangerNames = multiTransactional.values();
		if (ArrayUtils.isEmpty(multiTransactional.values())) {
			return false;
		}

		for (String beanName : transactionMangerNames) {
			DataSourceTransactionManager dataSourceTransactionManager = (DataSourceTransactionManager) applicationContext
					.getBean(beanName);

			MultiTransactionInfo info = new MultiTransactionInfo(beanName, dataSourceTransactionManager);
			multiTransactionInfos.push(info);
		}
		return true;
	}

	private void commit(Stack<MultiTransactionInfo> multiTransactionInfos) {
		while (!multiTransactionInfos.isEmpty()) {
			MultiTransactionInfo info = multiTransactionInfos.pop();
			info.commit();
		}
	}

	private void rollback(Stack<MultiTransactionInfo> multiTransactionInfos) {
		while (!multiTransactionInfos.isEmpty()) {
			MultiTransactionInfo info = multiTransactionInfos.pop();
			info.rollback();
		}
	}

	class MultiTransactionInfo {

		private String dataSourceTransactionManagerName;
		private DataSourceTransactionManager dataSourceTransactionManager;
		private TransactionStatus status;

		public MultiTransactionInfo(String dataSourceTransactionManagerName,
				DataSourceTransactionManager dataSourceTransactionManager) {
			this.dataSourceTransactionManagerName = dataSourceTransactionManagerName;
			this.dataSourceTransactionManager = dataSourceTransactionManager;
			this.status = this.dataSourceTransactionManager.getTransaction(new DefaultTransactionDefinition());
		}

		public String getDataSourceTransactionManagerName() {
			return this.dataSourceTransactionManagerName;
		}

		public void commit() {
			this.dataSourceTransactionManager.commit(this.status);
		}

		public void rollback() {
			this.dataSourceTransactionManager.rollback(this.status);
		}

		public void setRollbackOnly() {
			this.status.setRollbackOnly();
		}
		
		
	}

}