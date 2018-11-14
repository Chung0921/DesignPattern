# DesignPattern
## 过滤器/标准模式
### 1.HeadFirst中的定义:
###### 提供一种方法顺序的访问一个聚合对象中各个元素,而又不暴露该对象的内部表示.

### 2.大白话-自己的理解
###### 定义了一个迭代器接口,包含获取元素的方法.定义了一个聚合类接口,包含对集合内元素的增删改查方法,获取迭代器方法.最后定义一个聚合实现类,实现聚合类接口,内部维护一个元素列表,实现方法完成元素的增删改查;在该类中包含一个内部类,实现了迭代器接口,完成对聚合实现类中元素的迭代功能.迭代器的实现类作为聚合类的内部类的原因:方便迭代器类方便聚合实现类中的列表;

### 3.程序结构
#### com.chung.design.pattern.iterator.Aggregate,定义了一个聚合类的接口,包含聚合类内元素的增删改查方法及获取迭代器方法.
#### com.chung.design.pattern.iterator.Iterator,定义了一个迭代器接口,包含迭代器中提供的方法.
#### com.chung.design.pattern.iterator.ConcreteMissionAggregate,实现了聚合类接口,内部维护一个元素集合,通过聚合类接口的方法以维护这个列表.createIterator通过新建返回内部迭代器类的一个实例来实现获取聚合类的迭代器功能.
#### com.chung.design.pattern.iterator.ConcreteMissionAggregate.ConcreteMissionIterator,为聚合实现类的内部子类,继承了Iterator迭代器接口,实现了迭代器的功能.
#### Main.class程序入口

#### 4.程序命令行输出如下
     previous is:null,next is:Mission{name='M1.Name', desc='M1.desc'}
     previous is:Mission{name='M1.Name', desc='M1.desc'},next is:Mission{name='M2.Name', desc='M2.desc'}
     previous is:Mission{name='M2.Name', desc='M2.desc'},next is:Mission{name='M3.Name', desc='M3.desc'}
     previous is:Mission{name='M3.Name', desc='M3.desc'},next is:Mission{name='M4.Name', desc='M4.desc'}
     
#### 5.程序uml类图
    @startuml
    title 迭代器模式类图
    interface Aggregate<E> {
    	+Iterator<E> createIterator();
    	+void save( E e );
    	+void delete( E e );
    	+boolean isExist( E e );
    }
    
    interface Iterator<E> {
    	+boolean hasNext();
    	+E next();
    	+E previous();
    }
    
    class ConcreteMissionAggregate implements Aggregate {
    	-List<Mission> missions = new ArrayList<>();
    	+Iterator<Mission> createIterator();
    	+void save( Mission mission );
    	+void delete( Mission mission );
    	+boolean isExist( Mission mission );
    }
    
    class ConcreteMissionIterator implements Iterator {
    	-int cursor;
    	+boolean hasNext();
    	+Mission next();
    	+Mission previous();
    	-boolean isValidCursor( int index );
    }
    
    ConcreteMissionIterator +-- ConcreteMissionAggregate
    
    class Main{
    
    }
    @enduml
    