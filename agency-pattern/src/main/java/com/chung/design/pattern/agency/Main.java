package com.chung.design.pattern.agency;

/**
 * Created by Chung.
 * Usage: 中介者/调停者设计模式
 * Description:
 * Create dateTime: 2018/10/30
 */
public class Main {

	public static void main( String[] args ) {
		//定义中介者
		TrafficTowerMediator mediator = new TrafficTowerMediator();
		//定义同事类
		AirPlane747Colleague airPlane747Colleague = new AirPlane747Colleague( mediator );
		AirPlaneA380Colleague airPlaneA380Colleague = new AirPlaneA380Colleague( mediator );
		//告知中介者所有的同事类
		mediator.setAirPlane747Colleague( airPlane747Colleague );
		mediator.setAirPlaneA380Colleague( airPlaneA380Colleague );
		//同事类1发送消息查看结果
		airPlane747Colleague.sendMsg( "747发了一条广播哦!!" );
		//同事类2发送消息查看结果
		airPlaneA380Colleague.sendMsg( "380发了一条广播哦!!" );
	}
}
