package com.chung.design.pattern.template;

/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/10/18
 */
public class Main {

	public static void main( String[] args ) {
		System.out.println( "美式一杯,开始制作..." );
		AbstractCoffeeMakerTemplate americaCoffee = new AmericaCoffee();
		americaCoffee.make();
		System.out.println( "美式一杯,制作完成..." );
		System.out.println( "===========================================" );
		System.out.println( "普通咖啡一杯,开始制作..." );
		AbstractCoffeeMakerTemplate normalCoffee = new NormalCoffee();
		normalCoffee.make();
		System.out.println( "普通咖啡一杯,制作完成..." );
	}

}
