package com.chung.design.pattern.builder;

/**
 * Created by Chung.
 * Usage: 汉堡 实体类
 * Description:
 * Create dateTime: 18/10/17
 */
public class Burger {

	/**
	 * 汉堡面包
	 */
	private String bread;

	/**
	 * 汉堡肉
	 */
	private String meat;

	/**
	 * 汉堡酱
	 */
	private String sauce;

	public Burger() {
	}

	public String getBread() {
		return bread;
	}

	public void setBread( String bread ) {
		this.bread = bread;
	}

	public String getMeat() {
		return meat;
	}

	public void setMeat( String meat ) {
		this.meat = meat;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce( String sauce ) {
		this.sauce = sauce;
	}

	@Override
	public boolean equals( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass() != o.getClass() ) return false;

		Burger burger = (Burger) o;

		if ( bread != null ? !bread.equals( burger.bread ) : burger.bread != null ) return false;
		if ( meat != null ? !meat.equals( burger.meat ) : burger.meat != null ) return false;
		return sauce != null ? sauce.equals( burger.sauce ) : burger.sauce == null;
	}

	@Override
	public int hashCode() {
		int result = bread != null ? bread.hashCode() : 0;
		result = 31 * result + (meat != null ? meat.hashCode() : 0);
		result = 31 * result + (sauce != null ? sauce.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Burger{" +
				"bread='" + bread + '\'' +
				", meat='" + meat + '\'' +
				", sauce='" + sauce + '\'' +
				'}';
	}
}
