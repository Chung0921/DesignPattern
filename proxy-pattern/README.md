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
因静态代理模式得为每一个服务都得创建代理类,不易管理,接口一旦发生改变,代理类也得相应修改.而且占用资源较多,因此引出了动态代理模式.
#### 5.1.动态代理模式使用的必要条件:
###### 被代理的类(如:AlbumDaoImpl)必须要实现与静态代理模式中所提及的接口
###### 代理对象不需要实现接口(如:一会提到的动态代理),且动态的在内存中进行构建;
#### 5.2.程序结构
#### 共同接口(com.chung.design.pattern.proxy.AlbumDao)
#### 代理实现类(com.chung.design.pattern.proxy.dynamic.DynamicProxyHandler):持有目标对象,需要时将参数转发给目标对象;与静态代理类的区别是:在运行时动态进行生成及实例化
#### 真实的实现类也称目标对象也可以理解为被代理控制的类(com.chung.design.pattern.proxy.AlbumDaoImpl):实现原有的业务逻辑;
#### Main.class #dynamicProxy 该方法内为测试动态代理模式的代码
#### 5.3.运行结果
    生成代理类的处理类
    开始调用daoProxy...
    enter DynamicProxyHandler...
    showAllis invocation
    reflect to invoke method,target is:com.chung.design.pattern.proxy.AlbumDaoImpl@9e89d68,args is:null
    Album{id=1, name='No.1'}
    Album{id=2, name='No.2'}
    result is:null
    exit DynamicProxyHandler...
    退出调用daoProxy...
#### 5.4.动态代理模式-程序uml类图
    @startuml
    title 动态代理模式类图
    interface AlbumDao {
        void showAll();
    }
    
    class  AlbumDaoImpl implements AlbumDao{
        showAll();
    }
    class DynamicProxyHandler implements InvocationHandler{
        - final AlbumDao albumDao;
        invoke();
    }
    
    class Album {
    - Long id;
    - String name;
    }
    
    class Main {
        staticProxy();
    }
    
    @enduml
#### 5.5.附录
个人理解: 动态代理这种实现方式,与静态代理的区别在于动态代理通过java的反射获取被代理对象的接口方法,而后继承这个接口将在invoke方法中完成被代理对象的方法调用,在调用前和调用后可以添加一些原有被代理方法没有实现的功能或逻辑,spring中的aop也可通过这种方法实现;
但是有个缺点:虽然代理对象不需要实现接口,但是被代理的类必须实现某个接口,而且如果需要拦截方法实现代理则这个方法必须在接口中声明;