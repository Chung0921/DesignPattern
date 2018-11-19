package com.chung.design.pattern.factory.domain;

/**
 * Created by Chung.
 * Usage: 具体产品类
 * Description:
 * Create dateTime: 2018/11/19
 */
public class Apple extends Fruit {

	@Override
	public void showColor() {
		System.out.println("苹果的颜色是红的.");
	}

	@Override
	public String getFlavor() {
		return "苹果的味道有点酸";
	}

}
