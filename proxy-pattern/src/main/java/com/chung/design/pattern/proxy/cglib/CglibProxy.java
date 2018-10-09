package com.chung.design.pattern.proxy.cglib;


import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Created by Chung.
 * Usage:调用net.sf.cglib.proxy.MethodProxy#invokeSuper(java.lang.Object, java.lang.Object[])实现
 * Description: 如果调用invokeSuper方法，则一定要使用被代理后的o对象
 * Create dateTime: 18/10/8
 */
public class CglibProxy implements MethodInterceptor {


	/**
	 * 在代理实例上完成处理方法的调用并返回结果。
	 *
	 * @param o           由CGLib动态生成的代理类实例
	 * @param method      拦截的方法
	 * @param objects     方法的参数
	 * @param methodProxy MethodProxy为生成的代理类对方法的代理引用
	 * @return 结果
	 * @throws Throwable 异常
	 */
	@Override
	public Object intercept( Object o, Method method, Object[] objects, MethodProxy methodProxy ) throws Throwable {
		System.out.println( "enter CglibProxy..." );
		System.out.println( "param 'method' value is:" + method );
		System.out.println( "param 'objects' value is:" + Arrays.toString( objects ) );
		System.out.println( "param 'methodProxy' value is:" + methodProxy );
		System.out.println( "Before call invoke 'methodProxy#getSuperName' value is:" + methodProxy.getSuperName() );
		System.out.println( "Before call invoke 'methodProxy#getName' value is:" + method.getName() );
		Object results = methodProxy.invokeSuper( o, objects );
		System.out.println( "After call invoke 'methodProxy#getSuperName' value is:" + methodProxy.getSuperName() );
		System.out.println( "exit CglibProxy..." );
		return results;
	}

}
