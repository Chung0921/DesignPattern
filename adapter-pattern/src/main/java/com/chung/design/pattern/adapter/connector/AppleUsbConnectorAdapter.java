package com.chung.design.pattern.adapter.connector;

/**
 * Created by Chung.
 * Usage: 将所有子类不需要进行重写的方法在此处进行置空,避免子类重复置空无用方法.
 * Description:
 * Create dateTime: 2018/11/7
 */
public abstract class AppleUsbConnectorAdapter implements UsbConnectorTarget {

	public void doChargeWithMicroUsb() {
	}

}
