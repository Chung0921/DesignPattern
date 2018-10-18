# DesignPattern
## 模板方法设计模式
### 1.HeadFirst中的定义:
#### 观察者模式定义了一个一对多的依赖关系，让一个或多个观察者对象监听一个主题对象。这样一来，当被观察者状态发生改变时，需要通知相应的观察者，使这些观察者对象能够自动更新。

### 2.特点
#### (1).提升了代码的复用性,相同的代码在父类中.
#### (2).提高了拓展性,将不同代码放到子类中实现,可通过子类添加自定义行为;

### 3.大白话-自己的理解
#### 模板方法模式在一个方法中定义一个算法的骨架,而将一些步骤的实现延迟到子类中.模板方法使得子类可以在不改变算法结构的情况下,重新定义算法中某些步骤的具体实现.即一次性实现多个相似流程中的相同部分(避免代码复用),将可变部分留到子类中实现;钩子方法的实现是可选的;
#### Spring中的JdbcTemplate就是这种设计模式实现的,比如将获取连接和释放连接的操作,这部分在父类中,子类只关心具体拿到prepareStatement以后需要做的操作即可;


### 4.程序结构
#### 抽象模板类(com.chung.design.pattern.template.AbstractCoffeeMakerTemplate)中包含了一个不可变方法#make,这个方法实现了主要的流程控制即包含各方法的调用;包含了一个私有方法#foundCup,这个方法是所有子类中公有的,默认的;两个抽象方法#addWater和#addMaterial,这两个方法是留给子类用来扩展的;一个钩子方法#hookIsAddSugar及钩子方法的实现#addSugar,子类中通过重写这个方法,来完成子类中独有的功能;
#### com.chung.design.pattern.template.AmericaCoffee.class为美式咖啡的具体实现
#### com.chung.design.pattern.template.NormalCoffee.class为普通咖啡的具体实现
#### Main.class为程序入口,仅完成了调用过程;详见代码;

### 5.程序命令行输出如下
    美式一杯,开始制作...
    Template#make#call foundCup...
    获取一个杯子
    Template#make#call addMaterial...
    加入现磨咖啡粉
    Template#make#call addWater...
    加水125ml
    Template#make#call hookIsAddSugar...
    Template#make#all done!
    美式一杯,制作完成...
    ===========================================
    普通咖啡一杯,开始制作...
    Template#make#call foundCup...
    获取一个杯子
    Template#make#call addMaterial...
    加咖啡粉
    Template#make#call addWater...
    加水250ml
    Template#make#call hookIsAddSugar...
    Template#make#hookIsAddSugar result = true
    Template#make#call addSugar...
    加糖10g
    Template#make#all done!
    普通咖啡一杯,制作完成...

### 6.程序uml类图
        @startuml
        title 模板方法类图
        abstract class  AbstractCoffeeMakerTemplate {
            + final void make();
            - void foundCup();
            abstract void addWater();
            abstract void addMaterial();
            + void addSugar();
            + boolean hookIsAddSugar();
        }
        
        class AmericaCoffee extends AbstractCoffeeMakerTemplate {
            void addWater();
            void addMaterial();
        }
        class NormalCoffee extends AbstractCoffeeMakerTemplate {
            void addWater();
            void addMaterial();
        }
        
        class Main {
        }
        
        @enduml