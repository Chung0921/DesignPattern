package com.chung.design.pattern.decorator;

/**
 * Created by Chung.
 * Usage:装饰器设计模式
 * Description:
 * DrinkIComponent为饮品抽象接口,定义了饮品的所有方法.
 * CoffeeComponent普通咖啡的为饮品抽象接口的一个实现类,实现了饮品的所有方法.
 * CondimentDecorator继承了DrinkIComponent为饮品抽象接口,在内部维护了一个DrinkIComponent对象,为抽象装饰类,子类可以通过实现此抽象类完成装饰功能.
 * MilkDecorator继承了CondimentDecorator抽象类,可以为内部的DrinkIComponent对象,添加牛奶;
 * SugarDecorator继承了CondimentDecorator抽象类,可以为内部的DrinkIComponent对象,添加糖;
 * Create dateTime: 2018/11/12
 */
public class Main {

	public static void main( String[] args ) {
		System.out.println( "要一杯咖啡" );
		DrinkIComponent drinkIComponent = new CoffeeComponent();
		printDetail( drinkIComponent );
		System.out.println( "要一杯咖啡加糖" );
		printDetail( new SugarDecorator( drinkIComponent ) );
		System.out.println( "要一杯咖啡加奶" );
		printDetail( new MilkDecorator( drinkIComponent ) );
		System.out.println( "要一杯咖啡加糖加奶" );
		printDetail( new MilkDecorator( new SugarDecorator( drinkIComponent ) ) );

	}

	/**
	 * 输出饮品信息
	 *
	 * @param drinkIComponent 饮品对象
	 */
	public static void printDetail( DrinkIComponent drinkIComponent ) {
		drinkIComponent.description();
		System.out.print( ",花费=" + drinkIComponent.cost() + "\n" );
	}
}
