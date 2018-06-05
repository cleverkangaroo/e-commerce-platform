package com.kangaroo.microservices.provider.core.mybatis.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiTransactional {

	public String[] values() default { TransactionConstant.MASTER, TransactionConstant.BUSINESS };

}
