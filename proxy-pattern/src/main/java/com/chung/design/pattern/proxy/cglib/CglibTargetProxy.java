package com.chung.design.pattern.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Chung.
 * Usage: 调用的是net.sf.cglib.proxy.MethodProxy#invoke(java.lang.Object, java.lang.Object[])方法实现
 * Description: 如果是用invoke方法一定要使用被代理的对象也就是上文中的target,否则将死循环最终栈溢出
 * Create dateTime: 18/10/8
 */
public class CglibTargetProxy implements MethodInterceptor {

	private final Object target;

	public CglibTargetProxy( Object target ) {
		this.target = target;
	}

	/**
	 * 创建代理对象
	 *
	 * @return 代理对象
	 */
	public Object getInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass( this.target.getClass() );
		// 回调方法
		enhancer.setCallback( this );
		// 创建代理对象
		return enhancer.create();
	}


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
		System.out.println( "enter CglibTargetProxy..." );
		System.out.println( "param 'method' value is:" + method );
		System.out.println( "param 'objects' value is:" + Arrays.toString( objects ) );
		System.out.println( "param 'methodProxy' value is:" + methodProxy );
		System.out.println( "Before call invoke 'methodProxy#getSuperName' value is:" + methodProxy.getSuperName() );
		System.out.println( "Before call invoke 'methodProxy#getName' value is:" + method.getName() );
		Object results = methodProxy.invoke( this.target, objects );
		System.out.println( "After call invoke 'methodProxy#getSuperName' value is:" + methodProxy.getSuperName() );
		System.out.println( "exit CglibTargetProxy..." );
		return results;
	}

}
