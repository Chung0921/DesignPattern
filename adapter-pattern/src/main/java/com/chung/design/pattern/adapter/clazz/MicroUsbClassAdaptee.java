package com.chung.design.pattern.adapter.clazz;

/**
 * Created by Chung.
 * Usage: 被适配的类
 * Description: 用户想用苹果的数据接口,而当前存在的类是microUsb的,需要进行转换
 * Create dateTime: 2018/11/6
 */
public class MicroUsbClassAdaptee {

	/**
	 * 被适配类的用户需要调用的方法,但该方法用户不能直接调用(用户是apple的而充电口是microUsb的)
	 */
	public void chargeWithMicroUsb(){
		System.out.println("正在使用MicroUsb接口进行充电...");
	}

}
