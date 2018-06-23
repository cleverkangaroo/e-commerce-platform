package com.kangaroo.utils.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.github.pagehelper.Page;
/**
 * Bean的转换类，提供了两个bean或者两个list之间属性的拷贝
 *
 */
public class BeanCastUtil {
	
	private BeanCastUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 单个bean的属性拷贝
	 * @param originBean 原来的bean
	 * @param nowBeanClazz 需要转换成的bean的class
	 * @return
	 */
	public static <O extends Object, N extends Object> N castBean(O originBean, Class<N> nowBeanClazz) {
		if (originBean == null) {
			return null;
		}
		N nowBean = null;
			try {
				nowBean = nowBeanClazz.newInstance();
				BeanUtils.copyProperties(nowBean, originBean);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		return nowBean;
	}
	
	/**
	 * 单个bean的属性拷贝,自定义转换过程。
	 * @param originBean 原来的bean
	 * @param nowBeanClazz 需要转换成的bean的class
	 * @param operate 具体的自定义转换过程实现
	 * @return
	 */
	public static <O extends Object, N extends Object> N castBean(O originBean, Class<N> nowBeanClazz, BeanCastOperate<O, N> operate) {
		N nowBean = operate.doCast(originBean);
		return nowBean;
	}
	
	/**
	 * list的属性拷贝
	 * @param originList 原来的bean的list
	 * @param nowBeanClazz list中节点bean的class
	 * @return
	 */
	public static <O extends Object, N extends Object> List<N> castList(List<O> originList, Class<N> nowBeanClazz) {
		if (originList == null) {
			return null;
		}
		List<N> nowList = new ArrayList<N>();
		for (O originBean : originList) {
			nowList.add(castBean(originBean, nowBeanClazz));
		}
		return nowList;
	}
	
	/**
	 * list的属性拷贝，自定义转换过程，
	 * @param originList 原来的bean的list
	 * @param nowBeanClazz list中节点bean的class
	 * @param operate 具体的自定义转换过程实现
	 * @return
	 */
	public static <O extends Object, N extends Object> List<N> castList(List<O> originList, Class<N> nowBeanClazz, BeanCastOperate<O, N> operate) {
		if (originList == null) {
			return null;
		}
		List<N> nowList = new ArrayList<N>();
		for (O originBean : originList) {
			nowList.add(castBean(originBean, nowBeanClazz, operate));
		}
		return nowList;
	}
	
	/**
	 * page的属性拷贝
	 * @title: castPage  
	 * @description: page的属性拷贝
	 * @param originPage 原来的分页
	 * @param nowBeanClazz 需要转换的对象类型
	 * @return
	 */
	public static <O extends Object, N extends Object> PageBean<N> castPage(Page<O> originPage, Class<N> nowBeanClazz) {
		PageBean<N> pageBean = new PageBean<N>();
		pageBean.setTotal(originPage.getTotal());
		pageBean.setDataList(castList(originPage, nowBeanClazz));
		return pageBean;
	}
	
	/**
	 * page的属性拷贝，自定义转换过程，
	 * @title: castPage  
	 * @description: page的属性拷贝，自定义转换过程，
	 * @param originPage 原来的分页
	 * @param nowBeanClazz 需要转换的对象类型
	 * @param operate 具体的自定义转换过程实现
	 * @return
	 */
	public static <O extends Object, N extends Object> PageBean<N> castPage(Page<O> originPage, Class<N> nowBeanClazz, BeanCastOperate<O, N> operate) {
		PageBean<N> pageBean = new PageBean<N>();
		pageBean.setTotal(originPage.getTotal());
		pageBean.setDataList(castList(originPage, nowBeanClazz, operate));
		return pageBean;
	}
	
}
