package com.chung.design.pattern.observer;

/**
 * Created by Chung.
 * Usage: 具体的观察者实现
 * Description:
 * Create dateTime: 18/9/27
 */
public class ChungObserver implements Observer {

	public void notifyEventMessage( EventMessage eventMessage ) {
		System.out.println( "Chung received msg is:" + eventMessage );
	}


}
