package com.chung.design.pattern.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chung.
 * Usage: 构造器中传入两个标准过滤器,将对两个过滤器的结果取逻辑与
 * Description:
 * Create dateTime: 2018/11/12
 */
public class AndCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;

	public AndCriteria( Criteria criteria, Criteria otherCriteria ) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria( List<Person> persons ) {
		List<Person> firstCriteriaPersons = criteria.meetCriteria( persons );
		List<Person> secondCriteriaPersons = otherCriteria.meetCriteria( persons );
		if ( firstCriteriaPersons == null || firstCriteriaPersons.isEmpty() ) {
			return new ArrayList<>( 0 );
		}
		if ( secondCriteriaPersons == null || secondCriteriaPersons.isEmpty() ) {
			return new ArrayList<>( 0 );
		}
		firstCriteriaPersons.retainAll( secondCriteriaPersons );
		return firstCriteriaPersons;
	}
}
