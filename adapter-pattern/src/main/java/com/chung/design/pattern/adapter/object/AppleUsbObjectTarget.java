package com.chung.design.pattern.adapter.object;

/**
 * Created by Chung.
 * Usage: 用户想用苹果的数据接口,声明一个接口,给用户直接调用
 * Description:
 * Create dateTime: 2018/11/7
 */
public interface AppleUsbObjectTarget {

	/**
	 * 目标接口的目标方法,用户直接调用此方法,该方法底层将把原有不适配的方法转换为用户适配的方法.
	 */
	void doCharge();

}
