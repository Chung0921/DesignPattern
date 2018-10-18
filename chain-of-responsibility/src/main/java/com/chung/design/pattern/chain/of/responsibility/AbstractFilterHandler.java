package com.chung.design.pattern.chain.of.responsibility;

/**
 * Created by Chung.
 * Usage: 责任链中每一个职责类的父类
 * Description:
 * Create dateTime: 18/10/18
 */
public abstract class AbstractFilterHandler {

	/**
	 * 下一个处理器引用
	 */
	private AbstractFilterHandler abstractFilterHandler = null;

	/**
	 * 抽象方法,完成处理
	 */
	public abstract void doFilter();

	/**
	 * 设置下一个处理器
	 * @param nextHandler 下一个处理器对象,如果有
	 * @return 下一个处理器对象引用
	 */
	public AbstractFilterHandler setNext( AbstractFilterHandler nextHandler ) {
		this.abstractFilterHandler = nextHandler;
		return this.abstractFilterHandler;
	}

	/**
	 * 调用下一个处理器,final子类不可重写此方法
	 */
	protected final void callNextFilter() {
		if ( abstractFilterHandler == null ) {
			System.out.println( "tail!!! next handler not found!" );
			return;
		}
		abstractFilterHandler.doFilter();
	}

}
