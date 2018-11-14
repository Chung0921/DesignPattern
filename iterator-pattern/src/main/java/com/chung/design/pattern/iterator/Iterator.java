package com.chung.design.pattern.iterator;

/**
 * Created by Chung.
 * Usage: 迭代器接口
 * Description: 负责定义访问和遍历元素的接口
 * Create dateTime: 2018/11/13
 */
public interface Iterator<E> {

	//判断是否有还有下一个元素
	boolean hasNext();

	//取出下一个对象
	E next();

	//获取上一个对象
	E previous();
}
