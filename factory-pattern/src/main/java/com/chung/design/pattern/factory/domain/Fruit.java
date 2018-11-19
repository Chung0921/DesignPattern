package com.chung.design.pattern.factory.domain;

/**
 * Created by Chung.
 * Usage: 产品抽象类
 * Description:
 * Create dateTime: 2018/11/19
 */
public abstract class Fruit {

	/**
	 * 打印水果的颜色
	 */
	public abstract void showColor();

	/**
	 * 获取口味信息
	 * @return 口味信息
	 */
	public abstract String getFlavor();


}
