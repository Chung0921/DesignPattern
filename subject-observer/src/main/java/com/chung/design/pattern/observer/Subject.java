package com.chung.design.pattern.observer;

/**
 * Created by Chung.
 * Usage: 被观察的主题
 * Description: 子类实现当前接口,从而完成对具体子类主题的订阅功能,取消订阅功能,通知消息功能
 * Create dateTime: 18/9/27
 */
public interface Subject {

	/**
	 * 订阅
	 *
	 * @param observer 需要订阅 主题的观察者
	 */
	void follow( Observer observer );

	/**
	 * 取消订阅
	 *
	 * @param observer 需要取消订阅 主题的观察者
	 */
	void unfollow( Observer observer );

	/**
	 * 将eventMessage通知给所有的观察者
	 *
	 * @param eventMessage 事件消息
	 */
	void notifyAllObserver( EventMessage eventMessage );
}
