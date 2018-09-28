package com.chung.design.pattern.proxy;

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
}
