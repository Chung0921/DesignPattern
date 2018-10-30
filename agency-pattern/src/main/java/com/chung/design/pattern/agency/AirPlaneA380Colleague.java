package com.chung.design.pattern.agency;

/**
 * Created by Chung.
 * Usage:
 * Description:它是抽象同事类的子类
 * 每一个同事对象在需要和其他同事对象通信时,先与中介者通信,通过中介者来间接完成与其他同事类的通信
 * 在具体同事类中实现了在抽象同事类中声明的抽象方法
 * Create dateTime: 2018/10/30
 */
public class AirPlaneA380Colleague extends Colleague {

	/**
	 * 构造方法，传入中介者对象
	 *
	 * @param mediator 中介者对象
	 */
	protected AirPlaneA380Colleague( Mediator mediator ) {
		super( mediator );
	}

	@Override
	public void dealMsg( String msg ) {
		System.out.println( "AirPlaneA380Colleague received msg is:" + msg );
	}


}
