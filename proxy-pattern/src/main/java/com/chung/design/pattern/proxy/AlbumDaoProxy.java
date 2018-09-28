package com.chung.design.pattern.proxy;


/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/9/28
 */
public class AlbumDaoProxy implements AlbumDao {

	private final AlbumDao albumDao;

	public AlbumDaoProxy( AlbumDao albumDao ) {
		this.albumDao = albumDao;
	}

	@Override
	public void showAll() {
		System.out.println( "进入代理..." );
		albumDao.showAll();
		System.out.println( "退出代理..." );
	}


}
