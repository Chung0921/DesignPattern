package com.chung.design.pattern.criteria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Chung.
 * Usage:构造器中传入两个标准过滤器,将对两个过滤器的结果取逻辑或.
 * Description:
 * Create dateTime: 2018/11/12
 */
public class OrCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;

	public OrCriteria( Criteria criteria, Criteria otherCriteria ) {
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	@Override
	public List<Person> meetCriteria( List<Person> persons ) {
		List<Person> firstCriteriaItems = criteria.meetCriteria( persons );
		List<Person> otherCriteriaItems = otherCriteria.meetCriteria( persons );
		if ( firstCriteriaItems == null || firstCriteriaItems.isEmpty() ) {
			return otherCriteriaItems;
		}
		if ( otherCriteriaItems == null || otherCriteriaItems.isEmpty() ) {
			return firstCriteriaItems;
		}
		Set<Person> filterDuplicate = new HashSet<>();
		filterDuplicate.addAll( firstCriteriaItems );
		filterDuplicate.addAll( otherCriteriaItems );
		return new ArrayList<>( filterDuplicate );
	}

}