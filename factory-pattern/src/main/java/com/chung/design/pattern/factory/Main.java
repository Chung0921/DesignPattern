package com.chung.design.pattern.factory;

import com.chung.design.pattern.factory.domain.Fruit;
import com.chung.design.pattern.factory.domain.FruitType;
import com.chung.design.pattern.factory.simple.FruitSimpleStaticFactory;

/**
 * Created by Chung.
 * Usage:  工厂模式
 * Description:
 * Create dateTime: 2018/11/15
 */
public class Main {

	public static void main( String[] args ) {
		SimpleTest();
	}

	public static void SimpleTest() {
		Fruit apple = FruitSimpleStaticFactory.getFruitByFruitType( FruitType.APPLE );
		Fruit orange = FruitSimpleStaticFactory.getFruitByFruitType( FruitType.ORANGE );
		if ( apple == null ) {
			System.out.println( "apple not null" );
			return;
		}
		System.out.println( "SIMPLE------->APPLE------" );
		apple.showColor();
		System.out.println( apple.getFlavor() );
		if ( orange == null ) {
			System.out.println( "apple not null" );
			return;
		}
		System.out.println( "SIMPLE------->ORANGE------" );
		orange.showColor();
		System.out.println( orange.getFlavor() );
	}
}
