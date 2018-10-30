# DesignPattern
## 中介者设计模式
### 1.定义:
#### 定义一个中介对象来封装系列对象之间的交互.中介者使各个对象不需要显示地相互引用,从而使其耦合性松散,而且可以独立地改变他们之间的交互.


### 2.特点
#### 简化了对象之间的关系,将系统的各个对象之间的相互关系进行封装,将各个同事类解耦,使系统成为松耦合系统.减少了子类的生成.可以减少各同事类的设计与实现.但如果后期同事类过多,中间类将过于复杂,不好维护.不过降低了类复杂度,n:n变为n:1,并且进行了解耦.

### 3.大白话-自己的理解
#### 多个类之间有相互关系,形成了网状结构时使用.如:班长通知同学们开会,机场调度系统等情景.将网状结构变成星型结构,将各个类之间的通信封装到一个类中(称为中间类即Mediator).不过不能在类的职责不明确的情况下使用.

### 4.程序结构
#### com.chung.design.pattern.agency.Colleague 此类为抽象同事类,在抽象同事类中均保存有一个中介者对象的引用.
#### com.chung.design.pattern.agency.AirPlaneA380Colleague 此类为抽象同事类的子类,每个同事类在于其他同事进行通信时,均经过中介者来间接的完成通信,这也是在抽象同事类保存有一个中介者的对象引用的目的.当前类的具体逻辑在dealMsg方法中进行了实现(该方法完成了当前类特定的行为).
#### com.chung.design.pattern.agency.AirPlane747Colleague 同上
#### com.chung.design.pattern.agency.Mediator 此类为抽象中介者类,sendMsg方法为同事类到中介者的通信方法.
#### com.chung.design.pattern.agency.TrafficTowerMediator 为具体中介者的实现类,在该类中完成了中介者在收到一个同事类发送的消息后具体的后续处理逻辑,当前demo中实现的处理逻辑是打印一行转发log,并直接转发给另一个同事类.
### 中介者在当前的设计模式中处于核心的地位,它定义了整个系统中所有同事类见的关系.中介者类在结构上起到中转作用.通过中介者对象对关系的封装,使得具体的同事类不再需要显示的引用其他对象,它只需要通过中介者就可以完成与其他同事类之间的通信.中介者类在行为上起到协作作用.中介者对同事类之间的关系进行封装,同事类在不需要知道其他对象的情况下通过中介者与其他对象完成通信.在这个过程中同事类是不需要指明中介者该如何做,中介者可以根据自身的逻辑来进行协调,对同事的请求进一步处理,将同事成员之间的关系行为进行分离和封装.
#### Main.class为程序入口,仅完成了调用过程;详见代码;

### 5.程序命令行输出如下
        Connected to the target VM, address: '127.0.0.1:57917', transport: 'socket'
        TrafficTowerMediator forward to com.chung.design.pattern.agency.AirPlaneA380Colleague@5d22bbb7,msg is:747发了一条广播哦!!
        AirPlaneA380Colleague received msg is:747发了一条广播哦!!
        TrafficTowerMediator forward to com.chung.design.pattern.agency.AirPlane747Colleague@41a4555e,msg is:380发了一条广播哦!!
        AirPlane747Colleague received msg is:380发了一条广播哦!!
        Disconnected from the target VM, address: '127.0.0.1:57917', transport: 'socket'
        
        Process finished with exit code 0


### 6.程序uml类图
    @startuml
    title 中介者/调停者类图
    abstract class Colleague{
    	protected final Mediator mediator;
    	Colleague( Mediator mediator );
    	abstract void dealMsg( String msg );
    	final void sendMsg( String msg );
    }
    class AirPlane747Colleague extends Colleague {
    	public void dealMsg( String msg );
    }
    class AirPlaneA380Colleague extends Colleague {
    	public void dealMsg( String msg );
    }
    abstract class Mediator {
    	abstract void sendMsg( String msg, Colleague colleague );
    }
    class TrafficTowerMediator extends Mediator {
    	private AirPlane747Colleague airPlane747Colleague;
    	private AirPlaneA380Colleague airPlaneA380Colleague;
    	public void setAirPlane747Colleague( AirPlane747Colleague airPlane747Colleague );
    	public void setAirPlaneA380Colleague( AirPlaneA380Colleague airPlaneA380Colleague );
    	public void sendMsg( String msg, Colleague colleague );
    }
    class Main {
    	
    }
    Colleague o--> Mediator
    @enduml
    