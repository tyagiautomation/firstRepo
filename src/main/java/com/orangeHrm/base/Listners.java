package com.orangeHrm.base;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.orangeHrm.utility.ExtentManager;
import com.orangeHrm.utility.ExtentTestManager;
import com.orangeHrm.utility.getScreenShot;



public class Listners extends baseClass implements ITestListener{


	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started.....");
		Reporter.log("Method name is - " +result.getName());
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed : "+ result.getMethod().getMethodName());
	}
	
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed.....");
		getScreenShot.takeScreenshotAtEndOfTest();
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed : "+result.getMethod().getMethodName());
		
		ExtentTestManager.getTest().addScreenCaptureFromPath(getScreenShot.takeScreenshotAtEndOfTest());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test Result is - " +result.getStatus());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped : " +result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void onStart(ITestContext context) {
		System.out.println("Test Started.....");
		//getScreenShot.takeScreenshotAtEndOfTest();
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	
	

}
