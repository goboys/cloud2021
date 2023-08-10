package com.boys.test.lambda;

@FunctionalInterface
public interface MyPredicate<T> {

	boolean test(T t);
	
}
