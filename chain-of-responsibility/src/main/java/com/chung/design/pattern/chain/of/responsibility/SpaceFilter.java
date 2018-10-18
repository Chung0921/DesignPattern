package com.chung.design.pattern.chain.of.responsibility;

/**
 * Created by Chung.
 * Usage:模拟过滤器,过滤空格字符
 * Description:继承父类,完成具体逻辑处理
 * Create dateTime: 18/10/18
 */
public class SpaceFilter extends AbstractFilterHandler {

	@Override
	public void doFilter() {
		System.out.println( "过滤了空格字符" );
		//调用下一个处理器,形成链
		this.callNextFilter();
	}

}
