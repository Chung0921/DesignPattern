package com.chung.design.pattern.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chung.
 * Usage: 将人员名单中性别为男的人员作为结果集进行返回
 * Description:
 * Create dateTime: 2018/11/12
 */
public class CriteriaMale implements Criteria {

	@Override
	public List<Person> meetCriteria( List<Person> persons ) {
		List<Person> malePersons = new ArrayList<>();
		for ( Person person : persons ) {
			if ( person == null ) {
				continue;
			}
			if ( person.getGender() == null ) {
				continue;
			}
			if ( !person.getGender().equalsIgnoreCase( Person.GENDER_MALE ) ) {
				continue;
			}
			malePersons.add( person );
		}
		return malePersons;
	}
}
