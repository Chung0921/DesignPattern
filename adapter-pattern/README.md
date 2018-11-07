# DesignPattern
## 适配器设计模式
### 1.定义:
#### 作为两个不兼容的接口之间的桥梁.属于结构型模式,它结合了两个独立接口的功能.这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能.

##### 有三种适配器:类适配器、对象适配器、接口适配器
*类适配器: 使用一个适配接口和被适配类的子类完成适配器的作用,子类通过继承原有被适配的类及实现带有适配方法的新接口,从而完成适配工作.

*对象适配器: 使用一个适配接口并将被适配的类委派给接口的实现类共同完成适配器的作用.子类通过实现带有适配方法的新接口及调用被委派的被适配类的方法完成适配的工作.

### 2.特点
#### 优点:可以让任何两个没有关联的类一起运行、提高了类的复用、增加了类的透明度、灵活性好.
#### 缺点:过多地使用适配器,会让系统非常零乱,不易整体进行把握.比如,明明看到调用的是 A 接口,其实内部被适配成了 B 接口的实现,一个系统如果太多出现这种情况,无异于一场灾难.因此如果不是很有必要,可以不使用适配器,而是直接对系统进行重构.此外由于 JAVA 至多继承一个类,所以至多只能适配一个适配者类,而且目标类必须是抽象类.

### 3.大白话
#### 适配器就是一种适配中间件,它存在于不匹配的二者之间,用于连接二者,将不匹配变得匹配,简单点理解就是平常所见的转接头，转换器之类的存在.

### 4.程序结构
##### 4.1.类适配器结构:
##### com.chung.design.pattern.adapter.clazz.AppleUsbClassTarget 类适配器中的接口,封装方法给用户直接调用,#doCharge.
##### com.chung.design.pattern.adapter.clazz.MicroUsbClassAdaptee 类适配器中的被适配的类,即原不适配的类.包含待被适配的方法#chargeWithMicroUsb.
##### com.chung.design.pattern.adapter.clazz.AppleUsbClassAdapter 类适配器中的适配器类,通过继承被适配的类和目标接口,完成适配工作.在最终适配方法#doCharge中,完成原有被适配的类的方法调用,以及其余逻辑的编写.
##### com.chung.design.pattern.adapter.clazz.ClassAdapterEntrance 作为类适配器的程序入口,完成调用过程;详见代码;

##### 4.2.对象适配器结构:
##### com.chung.design.pattern.adapter.object.AppleUsbObjectTarget 对象适配器中的接口,封装方法给用户直接调用,#doCharge.
##### com.chung.design.pattern.adapter.object.MicroUsbObjectAdaptee 对象适配器中的被适配的类,即原不适配的类.包含待被适配的方法#chargeWithMicroUsb.
##### com.chung.design.pattern.adapter.object.AppleUsbObjectAdapter 对象适配器中的适配器类,通过实现目标接口,调用被适配类的方法,完成适配工作.在最终适配方法#doCharge中,完成原有被适配的类的方法调用,以及其余逻辑的编写.
##### com.chung.design.pattern.adapter.object.ObjectAdapterEntrance 作为对象适配器的程序入口,完成调用过程;详见代码;


### 5.程序命令行输出如下

##### 5.1.类适配器输出如下:
        原有充电方式开始----->
        正在使用MicroUsb接口进行充电...
        ----->原有充电方式结束
        类适配器模式开始----->
        添加了苹果转接头...
        正在使用MicroUsb接口进行充电...
        充电完成!
        ----->类适配器模式结束
##### 5.2.对象适配器输出如下:
        对象适配器模式开始----->
        添加了苹果转接头...
        正在使用MicroUsb接口进行充电...
        充电完成!
        ----->对象适配器模式结束


### 6.程序uml类图
    @startuml
    title 类适配器类图
    
    interface AppleUsbClassTarget{
       +void doCharge();
    }
    
    class MicroUsbClassAdaptee {
      +void chargeWithMicroUsb();
    }
    class AppleUsbClassAdapter extends MicroUsbClassAdaptee implements AppleUsbClassTarget{
       +void doCharge();
    }
    class ClassAdapterEntrance {
    
    }
    @enduml
    
    @startuml
    title 对象适配器类图
    
    interface AppleUsbObjectTarget {
       +void doCharge();
    }
    
    class MicroUsbObjectAdaptee {
      +void chargeWithMicroUsb();
    }
    class AppleUsbObjectAdapter implements AppleUsbObjectTarget{
       -MicroUsbObjectAdaptee microUsbObjectAdaptee;
       public AppleUsbObjectAdapter( MicroUsbObjectAdaptee microUsbObjectAdaptee );
       +void doCharge();
    }
    class ObjectAdapterEntrance {
    
    }

    AppleUsbObjectAdapter o-- MicroUsbObjectAdaptee
    @enduml
    