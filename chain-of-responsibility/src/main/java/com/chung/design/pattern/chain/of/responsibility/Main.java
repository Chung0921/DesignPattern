package com.chung.design.pattern.chain.of.responsibility;

/**
 * Created by Chung.
 * Usage: 责任链模式
 * Description:
 * Create dateTime: 18/10/18
 */
public class Main {

	public static void main( String[] args ) {
		System.out.println( "declare filter..." );
		//创建头过滤器
		AbstractFilterHandler filter = new ChineseFilter();
		System.out.println( "set next filter..." );
		//设置后续过滤器
		filter.setNext( new SpaceFilter() )
				.setNext( new SpecialSignFilter() );
		System.out.println( "filter chain init done!" );
		System.out.println( "filter call doFilter" );
		filter.doFilter();
		System.out.println( "exit 0" );
	}

}
