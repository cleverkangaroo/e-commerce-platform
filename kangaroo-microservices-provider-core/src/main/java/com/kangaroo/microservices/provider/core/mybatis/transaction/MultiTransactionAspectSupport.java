package com.kangaroo.microservices.provider.core.mybatis.transaction;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import com.kangaroo.microservices.provider.core.mybatis.transaction.MultiTransactionalAspect.MultiTransactionInfo;

public class MultiTransactionAspectSupport {

	private static final ThreadLocal<Stack<MultiTransactionInfo>> transactionInfos = new ThreadLocal<>();

	/*protected static void setCurrentTransationInfos(Stack<MultiTransactionInfo> multiTransactionInfos) {
		transactionInfos.set(multiTransactionInfos);
	}

	protected static Stack<MultiTransactionInfo> currentTransactionInfos() {
		return transactionInfos.get();
	}

	public static void setRollbackOnly() {
		setRollbackOnly(null);
	}

	public static void setRollbackOnly(String transactionManagerName) {
		Stack<MultiTransactionalAspect.MultiTransactionInfo> multiTransactionInfos = currentTransactionInfos();
		multiTransactionInfos.stream().filter(info -> {
			return StringUtils.isBlank(transactionManagerName)
					|| transactionManagerName.equals(info.getDataSourceTransactionManagerName());
		}).forEach(info -> {
			info.setRollbackOnly();
		});
		
	}
*/
}
