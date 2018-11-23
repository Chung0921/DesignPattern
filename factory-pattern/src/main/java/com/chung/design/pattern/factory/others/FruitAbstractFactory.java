package com.chung.design.pattern.factory.others;

import com.chung.design.pattern.factory.domain.Fruit;

/**
 * Created by Chung.
 * Usage: 抽象工厂接口
 * Description: 底层工厂都应继承该接口
 * Create dateTime: 2018/11/23
 */
public interface FruitAbstractFactory {

	/**
	 * 抽象工厂接口
	 * 底层继承该接口后,调用者将调用此方法返回生产出的水果实例
	 *
	 * @return 水果对象
	 */
	Fruit produce();

}
