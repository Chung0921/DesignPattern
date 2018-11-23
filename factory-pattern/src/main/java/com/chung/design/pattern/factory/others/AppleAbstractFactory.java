package com.chung.design.pattern.factory.others;

import com.chung.design.pattern.factory.domain.Apple;
import com.chung.design.pattern.factory.domain.Fruit;

/**
 * Created by Chung.
 * Usage: 继承至抽象工厂接口,用于返回苹果实例
 * Description: 苹果的生产工厂 只生产苹果
 * Create dateTime: 2018/11/23
 */
public class AppleAbstractFactory implements FruitAbstractFactory {

	@Override
	public Fruit produce() {
		return new Apple();
	}

}
