package com.chung.design.pattern.proxy;

/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/9/28
 */
public class Album {

	private Long id;

	private String name;


	public Album() {
	}

	public Long getId() {
		return id;
	}

	public Album setId( Long id ) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Album setName( String name ) {
		this.name = name;
		return this;
	}

	@Override
	public boolean equals( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass() != o.getClass() ) return false;

		Album album = (Album) o;

		if ( id != null ? !id.equals( album.id ) : album.id != null ) return false;
		return name != null ? name.equals( album.name ) : album.name == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Album{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
