package com.kangaroo.utils.bean;
/**
 * bean拷贝时自定义转换方法定义
 * 
 * @param <O> 原先的bean
 * @param <N> 新的bean
 */

@FunctionalInterface
public interface BeanCastOperate<O extends Object, N extends Object> {
	N doCast(O originBean);
}
