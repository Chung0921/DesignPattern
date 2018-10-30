package com.chung.design.pattern.agency;

/**
 * Created by Chung.
 * Usage: 抽象中介者。定义了同事对象到中介者对象之间的接口。
 * Description:
 * Create dateTime: 2018/10/30
 */
public abstract class Mediator {

	/**
	 * 发送信息给中介者
	 *
	 * @param msg       发送的消息
	 * @param colleague 来源
	 */
	public abstract void sendMsg( String msg, Colleague colleague );

}
