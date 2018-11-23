package com.chung.design.pattern.factory;

import com.chung.design.pattern.factory.domain.Fruit;
import com.chung.design.pattern.factory.domain.FruitType;
import com.chung.design.pattern.factory.others.AppleAbstractFactory;
import com.chung.design.pattern.factory.others.OrangeAbstractFactory;
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
		AbstractTest();
	}

	/**
	 * 简单静态工厂测试方法
	 */
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


	/**
	 * 抽象工厂测试方法
	 */
	public static void AbstractTest() {
		//初始化一个苹果生产工厂 调用生产方法 返回苹果实例
		Fruit apple = new AppleAbstractFactory().produce();
		//初始化一个橘子生产工厂 调用生产方法 返回橘子实例
		Fruit orange = new OrangeAbstractFactory().produce();
		if ( apple == null ) {
			System.out.println( "apple not null" );
			return;
		}
		System.out.println( "ABSTRACT------->APPLE------" );
		apple.showColor();
		System.out.println( apple.getFlavor() );
		if ( orange == null ) {
			System.out.println( "apple not null" );
			return;
		}
		System.out.println( "ABSTRACT------->ORANGE------" );
		orange.showColor();
		System.out.println( orange.getFlavor() );
	}

}
