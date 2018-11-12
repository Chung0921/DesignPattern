package com.chung.design.pattern.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chung.
 * Usage: 将人员名单中婚姻状态为单身的人员作为结果集进行返回
 * Description:
 * Create dateTime: 2018/11/12
 */
public class CriteriaSingle implements Criteria {

	@Override
	public List<Person> meetCriteria( List<Person> persons ) {
		List<Person> singlePersons = new ArrayList<>();
		for ( Person person : persons ) {
			if ( person == null ) {
				continue;
			}
			if ( person.getMaritalStatus() == null ) {
				continue;
			}
			if ( person.getMaritalStatus().equalsIgnoreCase( Person.MARITAL_STATUS_SINGLE ) ) {
				singlePersons.add( person );
			}
		}
		return singlePersons;
	}
}