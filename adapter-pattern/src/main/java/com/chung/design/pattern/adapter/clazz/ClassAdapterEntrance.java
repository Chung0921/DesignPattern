package com.chung.design.pattern.adapter.clazz;

/**
 * Created by Chung.
 * Usage: 类适配器设计模式
 * Description:
 * Create dateTime: 2018/11/6
 */
public class ClassAdapterEntrance {

	public static void main( String[] args ) {
		System.out.println("原有充电方式开始----->");
		MicroUsbClassAdaptee microUsbClassAdaptee = new MicroUsbClassAdaptee();
		microUsbClassAdaptee.chargeWithMicroUsb();
		System.out.println("----->原有充电方式结束");
		System.out.println("类适配器模式开始----->");
		AppleUsbClassTarget appleUsbClassTarget = new AppleUsbClassAdapter();
		appleUsbClassTarget.doCharge();
		System.out.println("----->类适配器模式结束");
	}
}
