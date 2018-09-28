package com.chung.design.pattern.proxy;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/9/28
 */
public class AlbumDaoImpl implements AlbumDao {

	@Override
	public void showAll() {
		//mock data
		List<Album> mockAlbums = this.findAlbumByMock();
		Assert.checkNonNull( mockAlbums );
		mockAlbums.forEach( System.out::println );
	}

	//mock normal albums
	private List<Album> findAlbumByMock() {
		List<Album> albums = new ArrayList<>();
		for ( int i = 1 ; i < 3 ; i++ ) {
			Album album = new Album();
			album.setId( Long.parseLong( Integer.toString( i ) ) )
					.setName( "No." + i );
			albums.add( album );
		}
		return albums;
	}

}
