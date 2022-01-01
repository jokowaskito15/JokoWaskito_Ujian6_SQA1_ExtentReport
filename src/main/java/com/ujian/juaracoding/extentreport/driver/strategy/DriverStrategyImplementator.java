package com.ujian.juaracoding.extentreport.driver.strategy;

import com.ujian.juaracoding.extentreport.utils.Constants;

public class DriverStrategyImplementator {

	public static DriverStrategy chooseStrategy(String strategy) {
		switch(strategy) {
		case Constants.CHROME:
			return new Chrome();
		
		case Constants.FIREFOX:
			return new Firefox();
		
		default:
			return null;
		}
	}
}
