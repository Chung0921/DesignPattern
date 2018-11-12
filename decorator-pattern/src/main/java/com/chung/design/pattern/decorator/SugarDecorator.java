package com.chung.design.pattern.decorator;

/**
 * Created by Chung.
 * Usage: 装饰器=饮品对象+糖
 * Description:
 * Create dateTime: 2018/11/12
 */
public class SugarDecorator extends CondimentDecorator {

	public SugarDecorator( DrinkIComponent decoratorDrink ) {
		super( decoratorDrink );
	}

	public Double cost() {
		return decoratorDrink.cost() + 0.5;
	}

	public void description() {
		decoratorDrink.description();
		System.out.print( "加了一份糖" );
	}

}
