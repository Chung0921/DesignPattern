# DesignPattern
## 责任链设计模式
### 1.定义:为请求创建了一个接收者对象的链。这种模式给予请求的类型，对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。在这种模式中，通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。

    责任链分为两种:
    纯的与不纯的责任链模式
    一个纯的责任链模式要求一个具体的处理者对象只能在两个行为中选择一个：一是承担责任，而是把责任推给下家。不允许出现某一个具体处理者对象在承担了一部分责任后又 把责任向下传的情况。
    在一个纯的责任链模式里面，一个请求必须被某一个处理者对象所接收；在一个不纯的责任链模式里面，一个请求可以最终不被任何接收端对象所接收。
    纯的责任链模式的实际例子很难找到，一般看到的例子均是不纯的责任链模式的实现。有些人认为不纯的责任链根本不是责任链模式，这也许是有道理的。但是在实际的系统里，纯的责任链很难找到。如果坚持责任链不纯便不是责任链模式，那么责任链模式便不会有太大意义了。
    ref: https://blog.csdn.net/liaodehong/article/details/51408076 
    ref:https://blog.csdn.net/justloveyou_/article/details/68489505
    ref:https://blog.csdn.net/justloveyou_/article/details/68491121

### 2.特点
#### (1).降低了耦合性,调用者不需要知道具体处理器直接的关系以及如何组合的.
#### (2).增加灵活性,如果需要增加处理器,只需要新建一个实现类完成逻辑后,放入到链路里即可.

### 3.大白话-自己的理解
#### 责任链模式事实上就是创建多个对象,是这些功能对象形成一条链,通过这条链上的每个处理器,完成对源数据的最终处理.
#### web容器中的FilterChain就是使用了这种设计模式;类似的还有Spring中的拦截器;

### 4.程序结构
#### com.chung.design.pattern.chain.of.responsibility.AbstractFilterHandler.class为责任链中的抽象父类,子类通过继承并实现#doFilter方法完成具体的业务逻辑实现;其中类变量abstractFilterHandler为下一个处理器的对象引用;#setNext方法为指定下一个业务处理器的方法;#callNextFilter方法为供子类调用实现责任链的方法;
#### ChineseFilter,SpaceFilter,SpecialSignFilter为具体的实现类,通过实现doFilter方法来完成业务逻辑,在该方法中除了完成当前类的基本业务逻辑外,还需要显式调用#callNextFilter方法,来完成下一个业务处理器的调用从而实现责任链模式;
#### Main.class为程序入口,仅完成了调用过程;详见代码;(主要决定了责任链链路节点的构成及执行顺序)

### 5.程序命令行输出如下
    
    declare filter...
    set next filter...
    filter chain init done!
    filter call doFilter
    过滤了中文字符
    过滤了空格字符
    过滤了特殊字符
    tail!!! next handler not found!
    exit 0
    
### 6.程序uml类图
        @startuml
        title 责任链模式类图
        abstract class AbstractFilterHandler {
            -AbstractFilterHandler abstractFilterHandler = null;
            + abstract void doFilter();
            +AbstractFilterHandler setNext( AbstractFilterHandler nextHandler );
            final void callNextFilter();
        }
        class ChineseFilter extends AbstractFilterHandler{
        }
        class SpaceFilter extends AbstractFilterHandler{
        }
        class SpecialSignFilter extends AbstractFilterHandler{
        }
        
        class Main {
        }
        @enduml
