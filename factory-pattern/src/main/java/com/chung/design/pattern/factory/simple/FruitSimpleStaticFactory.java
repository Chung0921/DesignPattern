package com.chung.design.pattern.factory.simple;

import com.chung.design.pattern.factory.domain.Apple;
import com.chung.design.pattern.factory.domain.Fruit;
import com.chung.design.pattern.factory.domain.FruitType;
import com.chung.design.pattern.factory.domain.Orange;

/**
 * Created by Chung.
 * Usage: 静态工厂
 * Description:
 * Create dateTime: 2018/11/19
 */
public class FruitSimpleStaticFactory {

	/**
	 * 简单静态工厂根据水果类型获取水果
	 *
	 * @param fruitType 水果类型
	 * @return 水果
	 */
	public static Fruit getFruitByFruitType( FruitType fruitType ) {
		if ( fruitType == null ) {
			System.out.println( "水果类型不可为空." );
			return null;
		}
		if ( FruitType.APPLE.equals( fruitType ) ) {
			return new Apple();
		}
		if ( FruitType.ORANGE.equals( fruitType ) ) {
			return new Orange();
		}
		System.out.println( "fruitType illeagl is:" + fruitType );
		return null;
	}

}
