package com.chung.design.pattern.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chung.
 * Usage: 过滤器/标准模式
 * Description:
 * 过滤器模式（Filter Pattern）或标准模式（Criteria Pattern）是一种设计模式，这种模式允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。这种类型的设计模式属于结构型模式，它结合多个标准来获得单一标准。
 * Create dateTime: 2018/11/12
 */
public class Main {

	public static void main( String[] args ) {
		List<Person> persons = new ArrayList<>();

		persons.add( new Person( "Robert", "Male", "Single" ) );
		persons.add( new Person( "John", "Male", "Married" ) );
		persons.add( new Person( "Laura", "Female", "Married" ) );
		persons.add( new Person( "Diana", "Female", "Single" ) );
		persons.add( new Person( "Mike", "Male", "Single" ) );
		persons.add( new Person( "Bobby", "Male", "Single" ) );

		Criteria male = new CriteriaMale();
		Criteria female = new CriteriaFemale();
		Criteria single = new CriteriaSingle();
		//过滤出单身且男性的人员
		Criteria singleMale = new AndCriteria( single, male );
		//过滤出单身或已婚的女性的人员
		Criteria singleOrFemale = new OrCriteria( single, female );

		System.out.println( "Males: " );
		printPersons( male.meetCriteria( persons ) );

		System.out.println( "\nFemales: " );
		printPersons( female.meetCriteria( persons ) );

		System.out.println( "\nSingle Males: " );
		printPersons( singleMale.meetCriteria( persons ) );

		System.out.println( "\nSingle Or Females: " );
		printPersons( singleOrFemale.meetCriteria( persons ) );
	}

	/**
	 * 输出人员清单结果集
	 *
	 * @param persons 人员列表
	 */
	public static void printPersons( List<Person> persons ) {
		persons.forEach( person -> System.out.println( "Person : [ Name : " + person.getName()
				+ ", Gender : " + person.getGender()
				+ ", Marital Status : " + person.getMaritalStatus()
				+ " ]" ) );
	}
}
