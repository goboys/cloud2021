package com.boys.test.lambda;


public class MyPredicateAge implements MyPredicate<Employee>{

	@Override
	public boolean test(Employee t) {
		return t.getAge()>35;
	}
}
