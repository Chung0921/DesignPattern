package com.chung.design.pattern.agency;

/**
 * Created by Chung.
 * Usage:抽象同事角色
 * Description:
 * Create dateTime: 2018/10/30
 */
public abstract class Colleague {

	/**
	 * 持有中介者对象，每一个同事类都知道它的中介者对象
	 */
	protected final Mediator mediator;

	/**
	 * 构造方法，传入中介者对象
	 *
	 * @param mediator 中介者对象
	 */
	protected Colleague( Mediator mediator ) {
		this.mediator = mediator;
	}

	/**
	 * 获取当前同事类对应的中介者对象
	 *
	 * @return 对应的中介者对象
	 */
	public Mediator getMediator() {
		return mediator;
	}

	/**
	 * 同事类在接收到消息时的处理方法
	 *
	 * @param msg 消息
	 */
	public abstract void dealMsg( String msg );

	/**
	 * 同事类的发送消息方法,供main调用
	 * 调用后先与中介者进行消息传递
	 *
	 * @param msg 消息
	 */
	public final void sendMsg( String msg ) {
		//调用中间者的方法转发消息给中介者
		mediator.sendMsg( msg, this );
	}


}
