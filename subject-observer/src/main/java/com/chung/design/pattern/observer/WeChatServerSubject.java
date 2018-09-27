package com.chung.design.pattern.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chung.
 * Usage: 被观察主题的具体实现类
 * Description: 在本类中实现了所有观察者对于当前主题的注册或取消注册操作;实现了将当前主题通知给所有观察者的操作;
 * Create dateTime: 18/9/27
 */
public class WeChatServerSubject implements Subject {

	/**
	 * 当前被观察主题对象的所有观察者
	 */
	private Set<Observer> observers;

	public WeChatServerSubject() {
		this.observers = new HashSet<Observer>();
	}

	public void follow( Observer observer ) {
		this.observers.add( observer );
	}

	public void unfollow( Observer observer ) {
		this.observers.remove( observer );
	}

	public void notifyAllObserver( EventMessage eventMessage ) {
		if ( null == observers ) {
			System.out.println( "WeChatServerSubject found observers is null!eventMessage=" + eventMessage );
			return;
		}
		//遍历订阅了当前主题的所有观察者 并告知消息
		for ( Observer observer : observers ) {
			observer.notifyEventMessage( eventMessage );
		}
	}
}
