package com.chung.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chung.
 * Usage: 实现了在抽象聚合类中声明的createIterator(),该方法返回一个与该具体聚合类对应的具体迭代器ConcreteIterator实例
 * Description:
 * 就是实现抽象容器的具体实现类,比如List接口的有序列表实现ArrayList,List接口的链表实现LinkedList,Set接口的哈希列表的实现HashSet等.
 * Create dateTime: 2018/11/13
 */
public class ConcreteMissionAggregate implements Aggregate<Mission> {

	/**
	 * 缓存的任务列表
	 */
	private List<Mission> missions = new ArrayList<>();


	@Override
	public Iterator<Mission> createIterator() {
		//返回内部迭代器类的一个实现
		return new ConcreteMissionIterator();
	}

	@Override
	public void save( Mission mission ) {
		missions.add( mission );
	}

	@Override
	public void delete( Mission mission ) {
		missions.remove( mission );
	}

	@Override
	public boolean isExist( Mission mission ) {
		return missions.contains( mission );
	}

	/**
	 * 当前聚合类特定的迭代器
	 */
	private class ConcreteMissionIterator implements Iterator<Mission> {

		/**
		 * 游标
		 */
		int cursor;

		@Override
		public boolean hasNext() {
			return cursor < missions.size();
		}

		@Override
		public Mission next() {
			boolean validIndex = isValidCursor( cursor );
			if ( !validIndex ) {
				return null;
			}
			return missions.get( cursor++ );
		}

		@Override
		public Mission previous() {
			int lastCursor = cursor - 1;
			boolean validIndex = isValidCursor( lastCursor );
			if ( !validIndex ) {
				return null;
			}
			return missions.get( lastCursor );
		}

		/**
		 * 查询index是否合法
		 *
		 * @return 合法返回true
		 */
		private boolean isValidCursor( int index ) {
			return index >= 0 && index <= missions.size();
		}
	}


}
