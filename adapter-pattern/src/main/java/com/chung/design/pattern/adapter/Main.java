package com.chung.design.pattern.adapter;

import com.chung.design.pattern.adapter.clazz.ClassAdapterEntrance;
import com.chung.design.pattern.adapter.connector.ConnectorAppleUsbEntrance;
import com.chung.design.pattern.adapter.object.ObjectAdapterEntrance;

/**
 * Created by Chung.
 * Usage: 适配器设计模式
 * Description:
 * Create dateTime: 2018/11/06
 */
public class Main {

	public static void main( String[] args ) {
		System.out.println("=================ClassAdapterEntrance=================");
		ClassAdapterEntrance.main( args );
		System.out.println("\n\n");
		System.out.println("=================ObjectAdapterEntrance=================");
		ObjectAdapterEntrance.main( args );
		System.out.println("\n\n");
		System.out.println("=================ConnectorAppleUsbEntrance=================");
		ConnectorAppleUsbEntrance.main( args );
	}
}
