# DesignPattern
## 代理模式
### 1.HeadFirst中的定义:
###### 使用代理模式创建代表，让代表对象控制某对象的访问，被代理的对象可以是远程对象，创建开销大的对象或者需要安全控制的对象。

### 2.大白话-自己的理解
###### 代理模式就是为被代理的对象提供一种代理以控制对这个对象的访问;

### 3.代理模式与装饰者模式的区别
###### 代理模式：包装另一个对象，并控制对它的访问。 
###### 装饰者模式：包装另一个对象，并添加额外的行为。

### 4.静态代理模式

#### 4.1.程序结构
#### 共同接口(com.chung.design.pattern.proxy.AlbumDao)
#### 代理实现类(com.chung.design.pattern.proxy.AlbumDaoProxy):持有目标对象,需要时将参数转发给目标对象;
#### 真实的实现类也称目标对象也可以理解为被代理控制的类(com.chung.design.pattern.proxy.AlbumDaoImpl):实现原有的业务逻辑;
#### Main.class #staticProxy 该方法内为测试静态代理模式的代码

#### 4.2.程序命令行输出如下
    开始调用dao...
    Album{id=1, name='No.1'}
    Album{id=2, name='No.2'}
    退出调用dao...
    ----------------
    开始调用daoProxy...
    进入代理...
    Album{id=1, name='No.1'}
    Album{id=2, name='No.2'}
    退出代理...
    退出调用daoProxy...
#### 4.3.静态代理模式-程序uml类图
    @startuml
    title 静态代理模式类图
    interface AlbumDao {
        void showAll();
    }
    
    class  AlbumDaoImpl implements AlbumDao{
        showAll();
    }
    class AlbumDaoProxy implements AlbumDao{
        - final AlbumDao albumDao;
        showAll();
    }
    
    class Album {
    - Long id;
    - String name;
    }
    
    class Main {
        staticProxy();
    }
    
    @enduml
### 5.动态代理模式
