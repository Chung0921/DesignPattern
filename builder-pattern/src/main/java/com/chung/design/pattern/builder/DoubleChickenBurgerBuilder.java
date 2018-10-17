package com.chung.design.pattern.builder;

/**
 * Created by Chung.
 * Usage: 双层鸡腿汉堡的制作子流程及实现细节
 * Description:
 * Create dateTime: 18/10/17
 */
public class DoubleChickenBurgerBuilder implements BurgerBuilder {

	private Burger burger = new Burger();

	@Override
	public void buildBread() {
		String bread = "Bread[Regular bun] * 3";
		System.out.println( "build..." + bread );
		burger.setBread( bread );
	}

	@Override
	public void buildMeat() {
		String meat = "Meat[chicken] * 2";
		System.out.println( "build..." + meat );
		burger.setMeat( meat );
	}

	@Override
	public void buildSauce() {
		String sauce = "Sauce[normal] * 1";
		System.out.println( "build..." + sauce );
		burger.setSauce( sauce );
	}

	@Override
	public Burger buildBurger() {
		System.out.println( "call buildBurger,burger return is:" + burger );
		return burger;
	}
}
