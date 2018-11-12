# DesignPattern
## 装饰器模式
### 1.HeadFirst中的定义:
###### 允许向一个现有的对象添加新的功能,同时又不改变其结构.装饰者可以在所委托被装饰者的行为之前或之后加上自己的行为,以达到特定的目的.

### 2.大白话-自己的理解
###### 引入一个中介类,这个类实现了被装饰者相同的接口,对外假装成被装饰者,并通过引用被装饰者,在调用被装饰者前后做一些附加功能（如：缓存，参数预处理）.动态增加功能;把需要新增加的功能预先制作成零件,在需要时“动态“的添加到对象上

### 3.程序结构
#### 共同接口(com.chung.design.pattern.decorator.DrinkIComponent),需要装饰的抽象对象(IComponent接口),定义了description方法,用以输出饮品的描述信息,cost方法用以返回饮品的花费信息;
#### com.chung.design.pattern.decorator.CoffeeComponent,需要装饰的抽象对象(ConcreteComponent),定义一个要被装饰器装饰的对象,即 Component 的具体实现;即实现了一个饮品对象,但仅是一杯普通的咖啡,啥都没加.
#### com.chung.design.pattern.decorator.CondimentDecorator,抽象装饰器(Decorator),用以维护对组件对象和其子类组件的引用,内含指向抽象组件的引用及装饰者共有的方法;即维护了一个饮品对象,封装了方法,供底层调用后进行佐料的添加.
#### com.chung.design.pattern.decorator.MilkDecorator,具体的装饰器(ConcreteDecorator),向组件添加新的职责.即对一个饮品对象添加牛奶;
#### com.chung.design.pattern.decorator.SugarDecorator,具体的装饰器(ConcreteDecorator),向组件添加新的职责.即对一个饮品对象添加糖;

#### Main.class程序入口

#### 4.程序命令行输出如下
    要一杯咖啡
    加了咖啡,花费=5.0
    要一杯咖啡加糖
    加了咖啡加了一份糖,花费=5.5
    要一杯咖啡加奶
    加了咖啡加了一份奶,花费=6.0
    要一杯咖啡加糖加奶
    加了咖啡加了一份糖加了一份奶,花费=6.5
#### 5.程序uml类图
    @startuml
    title 装饰者模式类图
    interface DrinkIComponent {
        void description();
        Double cost();
    }
    class CoffeeComponent implements DrinkIComponent {
        void description();
        Double cost();
    }
    abstract class CondimentDecorator implements DrinkIComponent {
    protected DrinkIComponent decoratorDrink;
    public CondimentDecorator( DrinkIComponent decoratorDrink );
     }
     class MilkDecorator extends CondimentDecorator {
        void description();
        Double cost();
    }
     class SugarDecorator extends CondimentDecorator {
        void description();
        Double cost();
    }
    class Main{
    
    }
    @enduml
##### 备注:
    在JDK中的inputStream也是用了此设计模式.