package com.chung.design.pattern.decorator;

/**
 * Created by Chung.
 * Usage: 调味装饰类
 * Description:
 * Create dateTime: 2018/11/12
 */
public abstract class CondimentDecorator implements DrinkIComponent {

	/**
	 * 被装饰的对象
	 */
	protected DrinkIComponent decoratorDrink;

	public CondimentDecorator( DrinkIComponent decoratorDrink ) {
		this.decoratorDrink = decoratorDrink;
	}

	public Double cost() {
		return decoratorDrink.cost();
	}

	public void description() {
		decoratorDrink.description();
	}
}
