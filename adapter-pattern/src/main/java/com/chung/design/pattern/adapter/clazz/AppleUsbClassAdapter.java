package com.chung.design.pattern.adapter.clazz;

/**
 * Created by Chung.
 * Usage: 适配器具体实现类,通过继承用户调用的接口和原有的类做出适配.
 * Description: 继承了源类Adaptee同时又实现了Target接口
 * Create dateTime: 2018/11/6
 */
public class AppleUsbClassAdapter extends MicroUsbClassAdaptee implements AppleUsbClassTarget {

	/**
	 * 目标接口要求调用doCharge()这个方法名,但源类Adaptee没有此方法
	 * 因此适配器补充上这个方法名
	 * 但实际上doCharge()只是调用源类Adaptee的chargeWithMicroUsb()方法的内容
	 * 所以适配器只是将chargeWithMicroUsb()方法作了一层封装，封装成Target可以调用的doCharge()而已
	 */
	@Override
	public void doCharge() {
		System.out.println( "添加了苹果转接头..." );
		super.chargeWithMicroUsb();
		System.out.println( "充电完成!" );
	}

}
