package com.chung.design.pattern.adapter.connector;

/**
 * Created by Chung.
 * Usage: 仅实现苹果usb接口即可
 * Description:
 * Create dateTime: 2018/11/7
 */
public class AppleUsbConnectorAdaptee extends AppleUsbConnectorAdapter {

	@Override
	public void doChargeWithAppleUsb() {
		System.out.println( "使用apple的lighting接口进行充电..." );
	}

}
