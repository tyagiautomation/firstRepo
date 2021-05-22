package com.orangeHrm.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangeHrm.base.baseClass;
import com.orangeHrm.pages.HomePage;
import com.orangeHrm.pages.LoginPage;


@Listeners(com.orangeHrm.base.Listners.class)

public class LoginPageTest extends baseClass {
	
	//Logger log = Logger.getLogger(com.freecrm.testcases.LoginPageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ExtentReports reports;
	ExtentTest logger;
	
	
	//to call the super class constructor
	public LoginPageTest(){
		super();
		
		
	}
	
	@BeforeMethod
	public void setUp(){
		//initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		logger = com.orangeHrm.utility.ExtentTestManager.getTest();
		String title = loginPage.validateLoginPageTitle();
		logger.log(Status.INFO, "clicked on 1st Button");
		logger.log(Status.INFO, "clicked on 2nd Button");
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
