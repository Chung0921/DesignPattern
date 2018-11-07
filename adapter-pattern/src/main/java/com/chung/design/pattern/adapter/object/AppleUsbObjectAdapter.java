package com.chung.design.pattern.adapter.object;

/**
 * Created by Chung.
 * Usage:适配器具体实现类,通过继承用户调用的接口,及将被适配的类进行委派实现.
 * Description: 委派了源类Adaptee,实现了Target接口
 * Create dateTime: 2018/11/7
 */
public class AppleUsbObjectAdapter implements AppleUsbObjectTarget {

	// 直接关联被适配类
	private MicroUsbObjectAdaptee microUsbObjectAdaptee;

	// 可以通过构造函数传入具体需要适配的被适配类对象
	public AppleUsbObjectAdapter( MicroUsbObjectAdaptee microUsbObjectAdaptee ) {
		this.microUsbObjectAdaptee = microUsbObjectAdaptee;
	}

	/**
	 * 目标接口要求调用doCharge()这个方法名,但源类Adaptee没有此方法
	 * 因此适配器补充上这个方法名
	 * 但实际上doCharge()只是调用源类Adaptee的chargeWithMicroUsb()方法的内容
	 * 所以适配器只是将chargeWithMicroUsb()方法作了一层封装，封装成Target可以调用的doCharge()而已
	 */
	@Override
	public void doCharge() {
		if ( microUsbObjectAdaptee == null ) {
			System.out.println( "请先进行microUsb的初始化工作!" );
			return;
		}
		System.out.println( "添加了苹果转接头..." );
		// 这里是使用委托的方式完成特殊功能
		this.microUsbObjectAdaptee.chargeWithMicroUsb();
		System.out.println( "充电完成!" );
	}


}
