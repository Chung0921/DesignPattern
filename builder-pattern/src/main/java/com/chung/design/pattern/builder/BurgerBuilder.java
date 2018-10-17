package com.chung.design.pattern.builder;

/**
 * Created by Chung.
 * Usage: 汉堡标准化制作流程类
 * Description: 每个建造者中都应包含这些子方法
 * Create dateTime: 18/10/17
 */
public interface BurgerBuilder {

	/**
	 * 为汉堡加入面包
	 */
	void buildBread();

	/**
	 * 为汉堡加入肉
	 */
	void buildMeat();

	/**
	 * 为汉堡加入酱汁
	 */
	void buildSauce();

	/**
	 * 返回刚刚制作的汉堡
	 *
	 * @return 汉堡对象
	 */
	Burger buildBurger();

}
