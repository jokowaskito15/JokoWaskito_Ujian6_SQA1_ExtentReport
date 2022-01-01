package com.ujian.juaracoding.extentreport.utils;

public enum TestCases {
	
	T1("Testing Register"),
	T2("Testing Login"),
	T3("Testing Add to Cart"),
	T4("Testing Add to Cart by Search"),
	T5("Testing Checkout from Cart");
	
	private String testName;
	
	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}

}
