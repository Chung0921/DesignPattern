package com.chung.design.pattern.observer;

/**
 * Created by Chung.
 * Usage: 观察者
 * Description: 观察者在被观察的主题中进行订阅后可接收被观察主题中的消息
 * Create dateTime: 18/9/27
 */
public interface Observer {

	/**
	 * 当被观察主题调用notifyObservers()方法时，观察者的notifyEventMessage()方法会被回调
	 *
	 * @param eventMessage 事件消息
	 */
	void notifyEventMessage( EventMessage eventMessage );

}
