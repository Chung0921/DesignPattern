package com.chung.design.pattern.factory.others;

import com.chung.design.pattern.factory.domain.Fruit;
import com.chung.design.pattern.factory.domain.Orange;

/**
 * Created by Chung.
 * Usage: 继承至抽象工厂接口,用于返回苹果实例
 * Description: 橘子的生产工厂 只生产橘子
 * Create dateTime: 2018/11/23
 */
public class OrangeAbstractFactory implements FruitAbstractFactory {

	@Override
	public Fruit produce() {
		return new Orange();
	}

}
