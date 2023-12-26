package com.cicdseleniumframework.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cicdseleniumframework.qa.utils.ExtentReporter;
import com.cicdseleniumframework.qa.utils.Utilities;

public class MyListener implements ITestListener  {

	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName; //testname is declared global so value from onTestStart will be passed to
	//all other methods
	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport();
		
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("Tests Started");
		testName=result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName + " test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	//	System.out.println(result.getName() + " Tests Success");
	//	String testName=result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.PASS,testName + " test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println(result.getName() + " Test Failed");
		
		WebDriver driver=null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	String testName=result.getName();
//		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destinationScreenshotPath = System.getProperty("user.dir")
//				+ "\\src\\main\\java\\com\\cicdseleniumframework\\Screenshots\\"+testName+".png";
//		try {
//			org.openqa.selenium.io.FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String destinationScreenshotPath= Utilities.captureScreenshot(driver, result.getName());
		//extentTest = extentReport.createTest(testName);
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName() + " test Failed");
		//extentReport.flush();
		
		
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test finished");
		
		extentReport.flush();
		String extentPath = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html"; 
		File file = new File(extentPath);
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


}
