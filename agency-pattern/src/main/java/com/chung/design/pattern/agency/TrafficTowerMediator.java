package com.chung.design.pattern.agency;

/**
 * Created by Chung.
 * Usage:具体中介者
 * Description: 是抽象中介者的子类，通过协调各个同事对象来实现协作行为，它维持了对各个同事对象的引用。
 * 1、 结构上起到中转作用。通过中介者对象对关系的封装，使得具体的同事类不再需要显示的引用其他对象，它只需要通过中介者就可以完成与其他同事类之间的通信。
 * <p>
 * 2、 行为上起到协作作用。中介者对同事类之间的关系进行封装，同事类在不需要知道其他对象的情况下通过中介者与其他对象完成通信。在这个过程中同事类是不需要指明中介者该如何做，中介者可以根据自身的逻辑来进行协调，对同事的请求进一步处理，将同事成员之间的关系行为进行分离和封装。
 * Create dateTime: 2018/10/30
 */
public class TrafficTowerMediator extends Mediator {

	private AirPlane747Colleague airPlane747Colleague;
	private AirPlaneA380Colleague airPlaneA380Colleague;

	public AirPlane747Colleague getAirPlane747Colleague() {
		return airPlane747Colleague;
	}

	public void setAirPlane747Colleague( AirPlane747Colleague airPlane747Colleague ) {
		this.airPlane747Colleague = airPlane747Colleague;
	}

	public AirPlaneA380Colleague getAirPlaneA380Colleague() {
		return airPlaneA380Colleague;
	}

	public void setAirPlaneA380Colleague( AirPlaneA380Colleague airPlaneA380Colleague ) {
		this.airPlaneA380Colleague = airPlaneA380Colleague;
	}

	@Override
	public void sendMsg( String msg, Colleague colleague ) {
		if ( colleague instanceof AirPlane747Colleague ) {
			System.out.println( "TrafficTowerMediator forward to " + airPlaneA380Colleague + ",msg is:" + msg );
			airPlaneA380Colleague.dealMsg( msg );
			return;
		}
		if ( colleague instanceof AirPlaneA380Colleague ) {
			System.out.println( "TrafficTowerMediator forward to " + airPlane747Colleague + ",msg is:" + msg );
			airPlane747Colleague.dealMsg( msg );
		}
	}
}
