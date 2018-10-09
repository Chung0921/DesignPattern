package com.chung.design.pattern.proxy;

import com.chung.design.pattern.proxy.cglib.CglibEntrance;
import com.chung.design.pattern.proxy.dynamic.DynamicProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/9/28
 */
public class Main {

	public static void main( String[] args ) {
		//静态代理模式
		staticProxy();
		System.out.println( "========================================" );
		//动态代理模式
		dynamicProxy();
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		//CGLIB代理模式 调用invoke实现
		CglibEntrance.testInvoke();
		System.out.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
		//CGLIB代理模式 调用invokeSuper实现
		CglibEntrance.testInvokeSuper();
	}

	public static void staticProxy() {
		System.out.println( "开始调用dao..." );
		AlbumDao albumDao = new AlbumDaoImpl();
		albumDao.showAll();
		System.out.println( "退出调用dao..." );

		System.out.println( "----------------" );
		AlbumDao albumDaoProxy = new AlbumDaoProxy( albumDao );
		System.out.println( "开始调用daoProxy..." );
		albumDaoProxy.showAll();
		System.out.println( "退出调用daoProxy..." );
	}

	public static void dynamicProxy() {
		AlbumDao albumDao = new AlbumDaoImpl();
		//获取被代理对象即目标对象的类加载器
		ClassLoader classLoader = albumDao.getClass().getClassLoader();
		//获取被代理对象的所有接口
		Class[] interfaces = albumDao.getClass().getInterfaces();
		//获取一个动态代理对象
		InvocationHandler invocationHandler =
				new DynamicProxyHandler( albumDao );
		System.out.println( "生成代理类的处理类" );
		AlbumDao albumDaoProxy = (AlbumDao) Proxy.newProxyInstance( classLoader, interfaces, invocationHandler );
		System.out.println( "开始调用daoProxy..." );
		albumDaoProxy.showAll();
		System.out.println( "退出调用daoProxy..." );
	}
}
