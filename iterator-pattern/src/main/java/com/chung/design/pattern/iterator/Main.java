package com.chung.design.pattern.iterator;


/**
 * Created by Chung.
 * Usage: 迭代器模式
 * Description:
 * Create dateTime: 2018/11/13
 */
public class Main {

	public static void main( String[] args ) {
		//声明一个聚合对象
		Aggregate<Mission> aggregate = new ConcreteMissionAggregate();
		//放入元素到该对象的列表中
		aggregate.save( new Mission( "M1.Name", "M1.desc" ) );
		aggregate.save( new Mission( "M2.Name", "M2.desc" ) );
		aggregate.save( new Mission( "M3.Name", "M3.desc" ) );
		aggregate.save( new Mission( "M4.Name", "M4.desc" ) );
		//获取聚合对象的迭代器
		Iterator<Mission> iterator = aggregate.createIterator();
		//迭代输出元素
		for ( ; iterator.hasNext() ; ) {
			System.out.println( "previous is:"+iterator.previous() + ",next is:" + iterator.next() );
		}
	}
}
