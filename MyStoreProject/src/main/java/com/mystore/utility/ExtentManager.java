package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public static void generateRep() {
		extent=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"test-output/Extent-Report/report.html");
		extent.attachReporter(spark);
	}

	public static void endRep() {
		extent.flush();
	}


}
