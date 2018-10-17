# DesignPattern
# 设计模式
## 设计模式的六大原则
##### 开闭原则：模块应尽量在不修改原代码(闭)的情况下进行扩展(开)。即在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。
##### 里氏代换原则：如果调用的是父类的话，那么换成子类也完全可以运行。 派生类能够在基类的基础上增加新的行为。只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。
##### 依赖倒置原则：1、高层次的模块不应该依赖于低层次的模块，他们都应该依赖于抽象。2、抽象不应该依赖于具体实现，具体实现应该依赖于抽象。要求对抽象/接口进行编程，不要对实现进行编程，这样就降低了客户与实现模块间的耦合。
##### 接口隔离原则：每一个接口应该是一种角色，不干不该干的事，该干的事都要干。降低类之间的耦合度。
##### 合成复用原则：要尽量使用组合/ 聚合，尽量不要使用继承。只有“Is - A” 关系才符合继承关系，“Has- A” 关系应当使用聚合来描述。
##### 最少知识原则：一个对象应对其它对象有尽可能少的了解。即一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。

## 创建型模式
##### 这些设计模式提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用新的运算符直接实例化对象。这使得程序在判断针对某个给定实例需要创建哪些对象时更加灵活。

##### 工厂模式与抽象工厂模式 （Factory Pattern）（Abstract Factory Pattern）：不同条件下创建不同实例
##### 单例模式 （Singleton Pattern）：保证一个类仅有一个实例
##### 建造者模式 （Builder Pattern）：将一个复杂的构建过程与其具表示细节相分离，使得同样的构建过程可以创建不同的表示
##### 原型模式 （Prototype Pattern）：通过拷贝原型创建新的对象

## 结构型模式
##### 这些设计模式关注类和对象的组合。

##### 适配器模式 （Adapter Pattern）：使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
##### 装饰器模式 （Decorator Pattern）：保持接口，增强性能：修饰类继承被修饰对象的抽象父类，依赖被修饰对象的实例（被修饰对象依赖注入），以实现接口扩展
##### 桥接模式 （Bridge Pattern）：两个维度独立变化，依赖方式实现抽象与实现分离：需要一个作为桥接的接口/抽象类，多个角度的实现类依赖注入到抽象类，使它们在抽象层建立一个关联关系
##### 外观模式 （Facade Pattern）：在客户端和复杂系统之间再加一层，这一次将调用顺序、依赖关系等处理好。即封装底层实现，隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的高层接口
##### 代理模式 （Proxy Pattern）：为其他对象提供一种代理以控制对这个对象的访问：增加中间层（代理层），代理类与底层实现类实现共同接口，并创建底层实现类对象（底层实现类对象依赖注入代理类），以便向外界提供功能接口
##### 过滤器模式 （Filter、Criteria Pattern）：使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来
##### 组合模式 （Composite Pattern）：用户对单个对象和组合对象的使用具有一致性的统一接口
##### 享元模式 （Flyweight Pattern）：享元工厂类控制；HashMap实现缓冲池重用现有的同类对象，如果未找到匹配的对象，则创建新对象

## 行为型模式
##### 这些设计模式特别关注对象之间的通信。

##### 责任链模式（Chain of Responsibility Pattern）：拦截的类都实现统一接口，每个接收者都包含对下一个接收者的引用。将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
##### 观察者模式（Observer Pattern）：一对多的依赖关系，在观察目标类里有一个 ArrayList 存放观察者们。当观察目标对象的状态发生改变，所有依赖于它的观察者都将得到通知，使这些观察者能够自动更新（即使用推送方式）
##### 模板模式（Template Pattern）：将这些通用算法抽象出来，在一个抽象类中公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行
##### 命令模式（Command Pattern）：将"行为请求者"与"行为实现者"解耦：调用者依赖命令，命令依赖接收者，调用者Invoker→命令Command→接收者Receiver
##### 解释器模式（Interpreter Pattern）：给定一个语言，定义它的文法表示，并定义一个解释器，这个解释器使用该标识来解释语言中的句子
##### 迭代器模式（Iterator Pattern）：集合中含有迭代器：分离了集合对象的遍历行为，抽象出一个迭代器类来负责，无须暴露该对象的内部表示
##### 中介者模式（Mediator Pattern）：对象与对象之间存在大量的关联关系，将对象之间的通信关联关系封装到一个中介类中单独处理，从而使其耦合松散，可以独立地改变它们之间的交互
##### 策略模式（Strategy Pattern）：策略对象依赖注入到context对象，context对象根据它的策略改变而改变它的相关行为(可通过调用内部的策略对象实现相应的具体策略行为)
##### 状态模式（State Pattern）：状态对象依赖注入到context对象，context对象根据它的状态改变而改变它的相关行为(可通过调用内部的状态对象实现相应的具体行为)
##### 备忘录模式（Memento Pattern）：通过一个备忘录类专门存储对象状态。客户通过备忘录管理类管理备忘录类。
##### 空对象模式（Null Object Pattern）：创建一个未对该类做任何实现的空对象类，该空对象类将无缝地使用在需要检查空值的地方。不要为了屏蔽null而使用空对象，应保持用null，远比用非null的值来替代“无值”要好。（慎用）

以上引用自:https://zhuanlan.zhihu.com/p/28737945