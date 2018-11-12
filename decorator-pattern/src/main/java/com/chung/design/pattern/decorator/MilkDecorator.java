package com.chung.design.pattern.decorator;

/**
 * Created by Chung.
 * Usage: 装饰器=饮品对象+奶
 * Description:
 * Create dateTime: 2018/11/12
 */
public class MilkDecorator extends CondimentDecorator {

	public MilkDecorator( DrinkIComponent decoratorDrink ) {
		super( decoratorDrink );
	}

	public Double cost() {
		return decoratorDrink.cost() + 1;
	}

	public void description() {
		decoratorDrink.description();
		System.out.print( "加了一份奶" );
	}
}
