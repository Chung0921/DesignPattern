package com.chung.design.pattern.decorator;

/**
 * Created by Chung.
 * Usage:我们需要装饰的对象
 * Description: 具体组件
 * Create dateTime: 2018/11/12
 */
public class CoffeeComponent implements DrinkIComponent {

	@Override
	public void description() {
		System.out.print( "加了咖啡" );
	}

	@Override
	public Double cost() {
		return 5.0d;
	}

}
