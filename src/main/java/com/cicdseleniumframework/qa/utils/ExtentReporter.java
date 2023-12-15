package com.cicdseleniumframework.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("cicdSeleniumFramework");
		sparkReporter.config().setDocumentTitle("Test Automation Report");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\cicdseleniumframework\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browserName"));
		
		return extentReport;
	}

	
}
