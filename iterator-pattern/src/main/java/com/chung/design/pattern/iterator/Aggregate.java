package com.chung.design.pattern.iterator;

/**
 * Created by Chung.
 * Usage: 聚合类的接口
 * Description: 存储和管理元素对象,声明了createIterator()用于创建一个迭代器对象,充当抽象迭代器工厂角色
 * Create dateTime: 2018/11/13
 */
public interface Aggregate<E> {

	/**
	 * 获取当前元素的迭代器
	 *
	 * @return 迭代器
	 */
	Iterator<E> createIterator();

	void save( E e );

	void delete( E e );

	boolean isExist( E e );
}
