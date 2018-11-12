package com.chung.design.pattern.criteria;

/**
 * Created by Chung.
 * Usage: 人员对象实体类
 * Description:
 * Create dateTime: 2018/11/12
 */
public class Person {

	/**
	 * 性别:男
	 */
	public static final String GENDER_MALE = "MALE";

	/**
	 * 性别:女
	 */
	public static final String GENDER_FEMALE = "FEMALE";

	/**
	 * 婚姻状态: 单身
	 */
	public static final String MARITAL_STATUS_SINGLE = "SINGLE";

	/**
	 * 婚姻状态: 已婚
	 */
	public static final String MARITAL_STATUS_MARRIED = "MARRIED";

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 婚姻状态
	 */
	private String maritalStatus;

	public Person( String name, String gender, String maritalStatus ) {
		this.name = name;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}
}
