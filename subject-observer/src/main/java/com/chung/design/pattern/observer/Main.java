package com.chung.design.pattern.observer;

/**
 * Created by Chung.
 * Usage:
 * Description:
 * Create dateTime: 18/9/27
 */
public class Main {

	public static void main( String[] args ) {
		//模拟微信的订阅
		WeChatServerSubject weChatServerSubject = new WeChatServerSubject();
		//声明两个观察者用于接收消息
		ChungObserver chungObserver = new ChungObserver();
		IrisObserver irisObserver = new IrisObserver();
		//将chung这个观察者加入到订阅列表中
		weChatServerSubject.follow( chungObserver );
		EventMessage eventMessage = new EventMessage();
		eventMessage.setId( 1L );
		eventMessage.setMessage( "SendToChung" );
		System.out.println( "声明了一个被观察主题weChatServerSubject,并将chung加入到了这个主题的订阅者列表中." );
		System.out.println( "通知消息为:" + eventMessage );
		System.out.println( "被观察主题weChatServerSubject将调用notifyAllObserver方法,用以通知所有的订阅者" );
		weChatServerSubject.notifyAllObserver( eventMessage );
		System.out.println( "被观察主题weChatServerSubject调用了notifyAllObserver方法,通知了所有的订阅者" );
		System.out.println();
		//将Iris这个观察者加入到订阅列表中
		weChatServerSubject.follow( irisObserver );
		System.out.println( "被观察主题weChatServerSubject,将Iris加入到了这个主题的订阅者列表中." );
		EventMessage msg = new EventMessage();
		msg.setId( 2L );
		msg.setMessage( "SendToChung&Iris" );
		System.out.println( "通知消息为:" + msg );
		System.out.println( "被观察主题weChatServerSubject将调用notifyAllObserver方法,用以通知所有的订阅者" );
		weChatServerSubject.notifyAllObserver( msg );
		System.out.println( "被观察主题weChatServerSubject调用了notifyAllObserver方法,通知了所有的订阅者" );
	}
}
