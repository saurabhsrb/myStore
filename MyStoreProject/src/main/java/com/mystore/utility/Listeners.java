package com.mystore.utility;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

public class Listeners extends TestListenerAdapter {

	
	public void onTestStart(ITestResult tr) {
		System.out.println("test started");
	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("test passed");
	}
	
	public void onTestFailure(ITestResult tr) {
		System.out.println("test failed");
	}
	
	public void onTestSkipped(ITestResult tr) {
		System.out.println("test skipped");
		}
}
