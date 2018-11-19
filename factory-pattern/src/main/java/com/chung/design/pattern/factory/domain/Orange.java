package com.chung.design.pattern.factory.domain;

/**
 * Created by Chung.
 * Usage: 具体产品类
 * Description:
 * Create dateTime: 2018/11/19
 */
public class Orange extends Fruit {

	@Override
	public void showColor() {
		System.out.println( "橘子皮是橘黄色的" );
	}

	@Override
	public String getFlavor() {
		return "橘子的味道很甜";
	}

}
