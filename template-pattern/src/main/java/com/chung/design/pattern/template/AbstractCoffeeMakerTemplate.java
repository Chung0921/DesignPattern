package com.chung.design.pattern.template;

/**
 * Created by Chung.
 * Usage: 模板方法的模板 抽象类 对外方法为不可变方法 包含抽象方法及钩子方法
 * Description:
 * Create dateTime: 18/10/18
 */
public abstract class AbstractCoffeeMakerTemplate {

	/**
	 * 制作咖啡的方法 供外部调用
	 * 制作流程都是 找到一个杯子 加咖啡粉 加水 可选是否加糖
	 * 声明为final的 防止子类修改此流程
	 */
	public final void make() {
		System.out.println( "Template#make#call foundCup..." );
		this.foundCup();
		System.out.println( "Template#make#call addMaterial..." );
		this.addMaterial();
		System.out.println( "Template#make#call addWater..." );
		this.addWater();
		System.out.println( "Template#make#call hookIsAddSugar..." );
		if ( this.hookIsAddSugar() ) {
			System.out.println( "Template#make#hookIsAddSugar result = " + this.hookIsAddSugar() );
			System.out.println( "Template#make#call addSugar..." );
			this.addSugar();
		}
		System.out.println( "Template#make#all done!" );
	}

	private void foundCup() {
		System.out.println( "获取一个杯子" );
	}

	/**
	 * 加水 水可能不一样 因此由子类实现
	 */
	protected abstract void addWater();

	/**
	 * 加原料 咖啡粉可能不一样 因此由子类实现
	 */
	protected abstract void addMaterial();

	/**
	 * 加糖 糖可能不一样 因此由子类实现
	 */
	protected void addSugar() {
		System.out.println( "不加糖" );
	}

	/**
	 * 钩子方法 是否加糖 子类看情况决定
	 */
	protected boolean hookIsAddSugar() {
		return false;
	}

}
