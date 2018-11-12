# DesignPattern
## 过滤器/标准模式
### 1.HeadFirst中的定义:
###### 过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。

### 2.大白话-自己的理解
###### 定义了一个接口,包含标准/过滤方法,实现类通过继承该接口,从而进行过滤或标准化操作.目的是筛选出一些满足单一条件的对象,当然也可以筛选出一些满足多个条件的对象.

### 3.程序结构
#### 标准化接口(com.chung.design.pattern.criteria.Criteria),定义了一个方法meetCriteria名字含义为遇见标准化.
#### com.chung.design.pattern.criteria.CriteriaMale为实现接口的具体过滤类,对传入的人员进行过滤,过滤出性别为男的人员名单.
#### com.chung.design.pattern.criteria.CriteriaFemale为实现接口的具体过滤类,对传入的人员进行过滤,过滤出性别为女的人员名单.
#### com.chung.design.pattern.criteria.CriteriaSingle为实现接口的具体过滤类,对传入的人员进行过滤,过滤出婚姻状况为单身的人员名单.
#### com.chung.design.pattern.criteria.AndCriteria为实现接口的具体过滤类,该类为组合过滤器,在构造器中可以传入两种不同的过滤器,比如说main中传入的就是过滤出婚姻状况为单身的过滤器和性别为男的过滤器,共两个,将对两个过滤器的结果取逻辑与.从而过滤出男性单身的人员名单.
#### com.chung.design.pattern.criteria.OrCriteria为实现接口的具体过滤类,该类为组合过滤器,在构造器中可以传入两种不同的过滤器,比如说main中传入的就是过滤出婚姻状况为单身的过滤器和性别为女的过滤器,共两个,将对两个过滤器的结果取逻辑或.从而过滤出女性或单身的人员名单.
#### Main.class程序入口

#### 4.程序命令行输出如下
    Males: 
    Person : [ Name : Robert, Gender : Male, Marital Status : Single ]
    Person : [ Name : John, Gender : Male, Marital Status : Married ]
    Person : [ Name : Mike, Gender : Male, Marital Status : Single ]
    Person : [ Name : Bobby, Gender : Male, Marital Status : Single ]
    
    Females: 
    Person : [ Name : Laura, Gender : Female, Marital Status : Married ]
    Person : [ Name : Diana, Gender : Female, Marital Status : Single ]
    
    Single Males: 
    Person : [ Name : Robert, Gender : Male, Marital Status : Single ]
    Person : [ Name : Mike, Gender : Male, Marital Status : Single ]
    Person : [ Name : Bobby, Gender : Male, Marital Status : Single ]
    
    Single Or Females: 
    Person : [ Name : Robert, Gender : Male, Marital Status : Single ]
    Person : [ Name : Mike, Gender : Male, Marital Status : Single ]
    Person : [ Name : Laura, Gender : Female, Marital Status : Married ]
    Person : [ Name : Bobby, Gender : Male, Marital Status : Single ]
    Person : [ Name : Diana, Gender : Female, Marital Status : Single ]
#### 5.程序uml类图
    @startuml
    title 过滤/标准模式类图
    interface Criteria {
        List<Person> meetCriteria( List<Person> persons );
    }
    class Person{
        -String name;
        -String gender;
        -String maritalStatus;
        public Person( String name, String gender, String maritalStatus );
    }
    class CriteriaFemale implements Criteria{
        +List<Person> meetCriteria( List<Person> persons );
    }
    class CriteriaMale implements Criteria{
        +List<Person> meetCriteria( List<Person> persons );
    }
    class CriteriaSingle implements Criteria{
        +List<Person> meetCriteria( List<Person> persons );
    }
    class AndCriteria implements Criteria{
        -Criteria criteria;
        -Criteria otherCriteria;
        +AndCriteria( Criteria criteria, Criteria otherCriteria );
        +List<Person> meetCriteria( List<Person> persons );
    }
    class OrCriteria implements Criteria{
        -Criteria criteria;
        -Criteria otherCriteria;
        +OrCriteria( Criteria criteria, Criteria otherCriteria );
        +List<Person> meetCriteria( List<Person> persons );
    }
    class Main{
    
    }
    @enduml
    
#### ref:http://www.runoob.com/design-pattern/filter-pattern.html