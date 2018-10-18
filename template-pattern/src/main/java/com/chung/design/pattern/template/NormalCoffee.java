package com.chung.design.pattern.template;

/**
 * Created by Chung.
 * Usage: 普通咖啡
 * Description:
 * Create dateTime: 18/10/18
 */
public class NormalCoffee extends AbstractCoffeeMakerTemplate {
	@Override
	protected void addWater() {
		System.out.println( "加水250ml" );
	}

	@Override
	protected void addMaterial() {
		System.out.println( "加咖啡粉" );
	}

	@Override
	protected void addSugar() {
		System.out.println( "加糖10g" );
	}

	@Override
	protected boolean hookIsAddSugar() {
		return true;
	}
}
