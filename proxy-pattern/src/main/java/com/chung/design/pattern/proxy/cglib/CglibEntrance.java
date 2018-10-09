package com.chung.design.pattern.proxy.cglib;

import com.chung.design.pattern.proxy.AlbumDaoImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/10/9
 */
public class CglibEntrance {

	public static void testInvokeSuper() {
		System.out.println( "init CglibProxy..." );
		CglibProxy cglibProxy = new CglibProxy();
		System.out.println( "init done cglibProxy is:" + cglibProxy );
		//在增强类中设定要被代理的父类 即为目标对象生成代理对象
		System.out.println( "Enhancer init..." );
		Enhancer enhancer = new Enhancer();
		//指定父类
		enhancer.setSuperclass( AlbumDaoImpl.class );
		//设置回调函数
		enhancer.setCallback( cglibProxy );
		System.out.println( "Enhancer init done enhancer is:" + enhancer );
		//设置一个被代理类的子类并初始化 作为代理
		AlbumDaoImpl o = (AlbumDaoImpl) enhancer.create();
		System.out.println( "create proxy done..." );
		//调用代理方法查看效果
		o.showAll();
		System.out.println( "exit CglibEntrance" );
	}

	public static void testInvoke() {
		System.out.println( "InvokeSuper init CglibProxy ..." );
		CglibTargetProxy cglibProxy = new CglibTargetProxy( new AlbumDaoImpl() );
		AlbumDaoImpl o = (AlbumDaoImpl) cglibProxy.getInstance();
		//调用代理方法查看效果
		o.showAll();
		System.out.println( "InvokeSuper exit CglibEntrance" );
	}
}
