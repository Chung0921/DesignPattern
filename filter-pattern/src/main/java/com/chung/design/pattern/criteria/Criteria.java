package com.chung.design.pattern.criteria;

import java.util.List;

/**
 * Created by Chung.
 * Usage: 标准过滤器的接口
 * Description:
 * Create dateTime: 2018/11/12
 */
public interface Criteria {

	/**
	 * 标准过滤方法
	 * 子类通过实现此方法完成过滤(可直接完成过滤逻辑,也可调用其他过滤器进行过滤逻辑的组合)
	 *
	 * @param persons 待过滤的人员列表
	 * @return 过滤后的结果集
	 */
	List<Person> meetCriteria( List<Person> persons );

}
