# DesignPattern
## 建造者设计模式
### 1.HeadFirst中的定义:
#### 是将一个复杂的对象的构建与它的表示分离,使得同样的构建过程可以创建不同的表示.即使用多个简单的对象一步一步构建成一个复杂的对象.

### 2.特点
#### 在用户不知道对象的建造过程和细节的情况下就可以直接创建复杂的对象.
    用户只需要给出指定复杂对象的类型和内容；
    建造者模式负责按顺序创建复杂对象（把内部的建造过程和细节隐藏起来)

### 3.大白话-自己的理解
#### 实际上就是将一个复杂的构建过程拆开来用多个子流程进行表示,某几个流程间是相互依赖且有序的.
#### 比如说这个demo是做汉堡,那么第一步就是做汉堡面包,第二步才是放肉或者刷酱.而且点了双层鸡腿堡或者辣鸡腿堡以后不用关心是如何制作的,只用指明需要的是什么汉堡(指明burgerBuilder)即可.汉堡的制作顺序由BurgerDirector决定.

### 4.程序结构
#### 定义的接口为com.chung.design.pattern.builder.BurgerBuilder 这个接口中将包含汉堡制作的通用步骤;规范化产品的制作,提供标准制作方法,该产品有多少个部分组成就有多少个方法;
#### com.chung.design.pattern.builder.BurgerDirector这个类主要是包含了如何制作一个汉堡(即包含哪些制作的步骤及制作步骤的顺序是什么),作为指导者:只负责调度,真正执行的细节在具体的builder中;
#### com.chung.design.pattern.builder.DoubleChickenBurgerBuilder这个类包含了制作双层鸡腿堡的每个制作细节
#### com.chung.design.pattern.builder.SpicyChickenBurgerBuilder这个类包含了制作辣鸡腿堡的每个制作细节
#### com.chung.design.pattern.builder.Burger为汉堡的实体类
#### Main.class为程序入口,仅完成了调用过程;详见代码;

### 5.程序命令行输出如下
        init BurgerDirector...
        init BurgerDirector done.
        start to make doubleChickenBurgerBuilder...
        BurgerDirector#call buildBread
        build...Bread[Regular bun] * 3
        BurgerDirector#call buildMeat
        build...Meat[chicken] * 2
        BurgerDirector#call buildSauce
        build...Sauce[normal] * 1
        BurgerDirector#call return
        call buildBurger,burger return is:Burger{bread='Bread[Regular bun] * 3', meat='Meat[chicken] * 2', sauce='Sauce[normal] * 1'}
        make doubleChickenBurgerBuilder done...
        Burger{bread='Bread[Regular bun] * 3', meat='Meat[chicken] * 2', sauce='Sauce[normal] * 1'}
        =============================================================
        start to make spicyChickenBurgerBuilder...
        BurgerDirector#call buildBread
        build...Bread[Regular bun] * 2
        BurgerDirector#call buildMeat
        build...Meat[chicken] * 1
        BurgerDirector#call buildSauce
        build...Sauce[spicy] * 1
        BurgerDirector#call return
        call buildBurger,burger return is:Burger{bread='Bread[Regular bun] * 2', meat='Meat[chicken] * 1', sauce='Sauce[spicy] * 1'}
        make spicyChickenBurgerBuilder done...
        Burger{bread='Bread[Regular bun] * 2', meat='Meat[chicken] * 1', sauce='Sauce[spicy] * 1'}
        Disconnected from the target VM, address: '127.0.0.1:64110', transport: 'socket'
        
        Process finished with exit code 0

### 6.程序uml类图
    @startuml
    title 建造者类图
    interface BurgerBuilder {
        void buildBread(  );
        void buildMeat(  );
        void buildSauce(  );
        Burger buildBurger(  );
    }
    
    class DoubleChickenBurgerBuilder implements BurgerBuilder{
    }
    class SpicyChickenBurgerBuilder implements BurgerBuilder{
    }
    
    DoubleChickenBurgerBuilder o-->Burger
    SpicyChickenBurgerBuilder o-->Burger
    
    class BurgerDirector {
        Burger makeBurger(BurgerBuilder builder)
    }
    
    BurgerDirector o--> BurgerBuilder
    
    class Main {
    }
    class Burger {
    }
    
    @enduml
    
7.在《Effective Java》书中第二条，就提到“遇到多个构造器参数时要考虑用构建器”，其实这里的构建器就属于建造者模式，只是里面把四个角色都放到具体产品里面了。而建造者模式主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用一定的算法构成；由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在一起的算法却相对稳定(ref:https://www.cnblogs.com/kangsir/p/6653233.html的总结段落)