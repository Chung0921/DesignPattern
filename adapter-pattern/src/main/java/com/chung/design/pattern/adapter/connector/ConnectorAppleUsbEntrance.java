package com.chung.design.pattern.adapter.connector;

/**
 * Created by Chung.
 * Usage: 接口适配器设计模式
 * Description:
 * Create dateTime: 2018/11/7
 */
public class ConnectorAppleUsbEntrance {

	public static void main( String[] args ) {
		System.out.println( "尝试充电..." );
		UsbConnectorTarget usbConnectorTarget = new AppleUsbConnectorAdaptee();
		usbConnectorTarget.doChargeWithAppleUsb();
		System.out.println( "充电完成..." );
	}

}
