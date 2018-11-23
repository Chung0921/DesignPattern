# DesignPattern
## 工厂设计模式
### 1.HeadFirst中的定义:
###### 简单/静态工厂模式: 定义一个创建对象的接口,让其子类自己决定实例化哪一个工厂类,工厂模式使其创建过程延迟到子类进行.
###### 抽象工厂模式: 提供一个创建一系列相关或相互依赖对象的接口,而无需指定它们具体的类.

### 2.大白话-自己的理解
###### 简单/静态工厂模式: 定义一个工厂类提供一个生产方法,该方法通过字符串参数判断调用者需要创建那个类的实例,而后返回该实例.
###### 抽象工厂模式: 将每一个可以被生产的类都分别定义一个工厂,并继承一个生产接口,调用者通过接口新建不同的实例工厂从而拿到想要的实例.

### 3.程序结构
#### com.chung.design.pattern.factory.domain.* 此包中为实体类
#### com.chung.design.pattern.factory.simple.FruitSimpleStaticFactory 为水果的静态工厂
#### com.chung.design.pattern.factory.others.FruitAbstractFactory 为水果的抽象工厂接口
#### com.chung.design.pattern.factory.others.AppleAbstractFactory 为苹果的工厂
#### com.chung.design.pattern.factory.others.OrangeAbstractFactory 为橘子的工厂

#### Main.class程序入口

#### 4.程序命令行输出如下
    SIMPLE------->APPLE------
    苹果的颜色是红的.
    苹果的味道有点酸
    SIMPLE------->ORANGE------
    橘子皮是橘黄色的
    橘子的味道很甜
    ABSTRACT------->APPLE------
    苹果的颜色是红的.
    苹果的味道有点酸
    ABSTRACT------->ORANGE------
    橘子皮是橘黄色的
    橘子的味道很甜
#### 5.程序uml类图
    @startuml
    title 简单/静态工厂类图
    abstract class Fruit {
        public abstract void showColor();
        public abstract String getFlavor();
    }

    class Apple extends Fruit{
    }
    class Orange extends Fruit{
    }
    enum FruitType{
    }
    class FruitSimpleStaticFactory {
        public static Fruit getFruitByFruitType( FruitType fruitType );
    }
    class Main{
    }
    FruitSimpleStaticFactory o-- FruitType
    @enduml
    
    @startuml
    title 抽象工厂类图
    abstract class Fruit {
        public abstract void showColor();
        public abstract String getFlavor();
    }

    class Apple extends Fruit{
    }
    class Orange extends Fruit{
    }
    class AppleAbstractFactory implements FruitAbstractFactory{
    }
    class OrangeAbstractFactory implements FruitAbstractFactory{
    }
    interface FruitAbstractFactory {
        Fruit produce();
    }
    class Main{
    }
    Apple --o AppleAbstractFactory
    Orange --o OrangeAbstractFactory
    @enduml
    
    
#####区别:
    简单工厂模式如果需要添加新的水果的话,需要添加一个新的FruitType并且修改简单工厂内的逻辑,用于新水果类型的判断及返回.
    抽象工厂模式如果需要添加新的水果的话,只需要继承抽象工厂接口,并在其实现类中返回新的水果实例即可.耦合性更低,符合开闭原则.