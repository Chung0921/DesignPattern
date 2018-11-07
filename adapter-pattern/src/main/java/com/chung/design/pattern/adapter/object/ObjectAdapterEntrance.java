package com.chung.design.pattern.adapter.object;

/**
 * Created by Chung.
 * Usage: 对象适配器设计模式
 * Description:
 * Create dateTime: 2018/11/7
 */
public class ObjectAdapterEntrance {

	public static void main( String[] args ) {
		MicroUsbObjectAdaptee microUsbObjectAdaptee = new MicroUsbObjectAdaptee();
		System.out.println( "对象适配器模式开始----->" );
		AppleUsbObjectTarget appleUsbObjectTarget = new AppleUsbObjectAdapter( microUsbObjectAdaptee );
		appleUsbObjectTarget.doCharge();
		System.out.println( "----->对象适配器模式结束" );
	}

}
