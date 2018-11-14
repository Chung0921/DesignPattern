package com.chung.design.pattern.iterator;

/**
 * Created by Chung.
 * Usage: 任务对象仅用于pojo
 * Description:
 * Create dateTime: 2018/11/13
 */
public class Mission {

	/**
	 * 任务名称
	 */
	private String name;

	/**
	 * 任务描述
	 */
	private String desc;

	public Mission() {
	}

	public Mission( String name, String desc ) {
		this.name = name;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Mission{" +
				"name='" + name + '\'' +
				", desc='" + desc + '\'' +
				'}';
	}

}
