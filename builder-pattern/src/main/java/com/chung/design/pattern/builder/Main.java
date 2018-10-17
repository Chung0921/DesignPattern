package com.chung.design.pattern.builder;

/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/10/17
 */
public class Main {

	public static void main( String[] args ) {
		System.out.println( "init BurgerDirector..." );
		BurgerDirector burgerDirector = new BurgerDirector();
		System.out.println( "init BurgerDirector done." );
		DoubleChickenBurgerBuilder doubleChickenBurgerBuilder = new DoubleChickenBurgerBuilder();
		System.out.println( "start to make doubleChickenBurgerBuilder..." );
		Burger doubleChickenBurger = burgerDirector.makeBurger( doubleChickenBurgerBuilder );
		System.out.println( "make doubleChickenBurgerBuilder done..." );
		System.out.println( doubleChickenBurger );
		System.out.println( "=============================================================" );
		SpicyChickenBurgerBuilder spicyChickenBurgerBuilder = new SpicyChickenBurgerBuilder();
		System.out.println( "start to make spicyChickenBurgerBuilder..." );
		Burger spicyChickenBurger = burgerDirector.makeBurger( spicyChickenBurgerBuilder );
		System.out.println( "make spicyChickenBurgerBuilder done..." );
		System.out.println( spicyChickenBurger );
	}

}
