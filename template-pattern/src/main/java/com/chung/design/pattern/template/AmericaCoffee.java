package com.chung.design.pattern.template;

/**
 * Created by Chung.
 * Usage: 美式咖啡
 * Description:
 * Create dateTime: 18/10/18
 */
public class AmericaCoffee extends AbstractCoffeeMakerTemplate {
	@Override
	protected void addWater() {
		System.out.println( "加水125ml" );
	}

	@Override
	protected void addMaterial() {
		System.out.println( "加入现磨咖啡粉" );
	}

	@Override
	protected void addSugar() {
		System.out.println( "美式不加糖" );
	}

	@Override
	protected boolean hookIsAddSugar() {
		return false;
	}
}
