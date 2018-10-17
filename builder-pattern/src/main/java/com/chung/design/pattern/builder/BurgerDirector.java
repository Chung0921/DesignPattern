package com.chung.design.pattern.builder;

/**
 * Created by Chung.
 * Usage: 具体调用建造者每个步骤的指导者,指导者中不包含每一步的具体信息,仅负责某几个部分的调用及按某种顺序创建
 * Description:
 * Create dateTime: 18/10/17
 */
public class BurgerDirector {

	public Burger makeBurger( BurgerBuilder burgerBuilder ) {
		//按照 面包--->肉--->酱 的顺序创建汉堡
		System.out.println("BurgerDirector#call buildBread");
		burgerBuilder.buildBread();
		System.out.println("BurgerDirector#call buildMeat");
		burgerBuilder.buildMeat();
		System.out.println("BurgerDirector#call buildSauce");
		burgerBuilder.buildSauce();
		System.out.println("BurgerDirector#call return");
		return burgerBuilder.buildBurger();
	}

}
