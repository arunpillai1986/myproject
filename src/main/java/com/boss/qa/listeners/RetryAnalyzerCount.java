package com.boss.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerCount implements IRetryAnalyzer {
	
	int counter = 0;
	int retryLimit = 1;
	
	public boolean retry(ITestResult result) {
		
		if( counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
		
	}

}