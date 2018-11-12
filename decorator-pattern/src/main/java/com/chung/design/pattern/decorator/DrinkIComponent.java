package com.chung.design.pattern.decorator;

/**
 * Created by Chung.
 * Usage: 需要装饰的抽象对象
 * Description: 抽象组件
 * Create dateTime: 2018/11/12
 */
public interface DrinkIComponent {

	/**
	 * 详情
	 */
	void description();

	/**
	 * 花费
	 */
	Double cost();

}
