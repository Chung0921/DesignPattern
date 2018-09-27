# DesignPattern
## 观察者设计模式
### 1.HeadFirst中的定义:
#### 观察者模式定义了一个一对多的依赖关系，让一个或多个观察者对象监听一个主题对象。这样一来，当被观察者状态发生改变时，需要通知相应的观察者，使这些观察者对象能够自动更新。

### 2.特点
#### (1).被观察者需要持有一个或者多个观察者对象。
#### (2).系统中一个模块的变化，某些模块也会跟随着变化。

### 3.大白话-自己的理解
#### 观察者模式实际上就是完成了发布订阅模式,在当前主题发布了新的消息时,所有订阅了当前主题的订阅者,就会接收到通知,未订阅的那些订阅者不会收到通知;


### 4.程序结构
#### 共定义了两个接口,一个是被观察的主题接口,一个是可以观察主题的观察者接口;
#### 被观察的主题接口(com.chung.design.pattern.observer.Subject)中包含订阅方法,取消订阅方法及通知所有观察者方法;
#### 观察者接口(com.chung.design.pattern.observer.Observer)中仅包含一个钩子方法,用于完成被观察主题在接收到消息后的通知操作;
#### 被观察的具体实现类(com.chung.design.pattern.observer.WeChatServerSubject)继承了被观察的主题接口(com.chung.design.pattern.observer.Subject),并实现了所有观察者对于当前主题的注册或取消注册操作(通过维护类内部的记录订阅当前主题的观察者列表实现);实现了将当前主题通知给所有观察者的操作(类中的notifyAllObserver方法,在该方法中遍历订阅了当前主题的观察者列表,并对于每一个观察者调用其本身的钩子方法notifyEventMessage完成消息的通知操作);
#### 观察者的具体实现类(com.chung.design.pattern.observer.ChungObserver)继承了观察者接口(com.chung.design.pattern.observer.Observer),并完成了钩子方法(notifyEventMessage),在该方法中定义了具体接收到事件通知对象后具体执行的逻辑;
#### EventMessage.class为具体需要通知的消息;
#### Main.class为程序入口,仅完成了调用过程;详见代码;

### 5.程序命令行输出如下
    声明了一个被观察主题weChatServerSubject,并将chung加入到了这个主题的订阅者列表中.
    通知消息为:EventMessage{id=1, message='SendToChung', timeStamp=1538044029681}
    被观察主题weChatServerSubject将调用notifyAllObserver方法,用以通知所有的订阅者
    Chung received msg is:EventMessage{id=1, message='SendToChung', timeStamp=1538044029681}
    被观察主题weChatServerSubject调用了notifyAllObserver方法,通知了所有的订阅者
    被观察主题weChatServerSubject,将Iris加入到了这个主题的订阅者列表中.
    通知消息为:EventMessage{id=2, message='SendToChung&Iris', timeStamp=1538044029685}
    被观察主题weChatServerSubject将调用notifyAllObserver方法,用以通知所有的订阅者
    Chung received msg is:EventMessage{id=2, message='SendToChung&Iris', timeStamp=1538044029685}
    Iris received msg is:EventMessage{id=2, message='SendToChung&Iris', timeStamp=1538044029685}
    被观察主题weChatServerSubject调用了notifyAllObserver方法,通知了所有的订阅者

### 6.程序uml类图

        @startuml
        title 观察者模式类图
        interface Observer {
        	void notifyEventMessage( EventMessage eventMessage );
        }
        
        class IrisObserver implements Observer{
        }
        class ChungObserver implements Observer{
        }
        
        class EventMessage {
            - Long id;
            - String message;
            - Long currentStamp;
        }
        
        interface Subject {
            void follow( Observer observer );
            void unfollow( Observer observer );
            void notifyAllObserver( EventMessage eventMessage );
        }
        
        class WeChatServerSubject implements Subject {
            - Set<Observer> observers;
        }
        
        class Main {
        }
        
        @enduml
