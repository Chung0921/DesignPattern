package com.chung.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Chung.
 * Usage: 动态代理的实现
 * Description: 局限性: 被代理的方法在被代理的类中必须实现接口中的方法
 * Create dateTime: 18/9/29
 */
public class DynamicProxyHandler implements InvocationHandler {

	/**
	 * 目标对象
	 */
	private Object target;

	public DynamicProxyHandler( Object target ) {
		this.target = target;
	}

	/**
	 * 在代理实例上完成处理方法的调用并返回结果。
	 *
	 * @param proxy  产生的代理对象
	 * @param method 调用被代理方法的方法名
	 * @param args   调用被代理方法时传入的参数
	 * @return 处理结果
	 * @throws Throwable 异常
	 */
	@Override
	public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
		System.out.println( "enter DynamicProxyHandler..." );
		// 获得将来所调用方法的名字
		String methodName = method.getName();
		// 用日志记录输出一下
		System.out.println( methodName + "is invocation" );
		// 用反射的方式去调用将来需要真正调用的方法.
		System.out.println( "reflect to invoke method,target is:" + target + ",args is:" + Arrays.toString( args ) );
		Object o = method.invoke( target, args );
		System.out.println( "result is:" + o );
		System.out.println( "exit DynamicProxyHandler..." );
		return o;
	}


}
