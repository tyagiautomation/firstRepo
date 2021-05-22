package com.orangeHrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHrm.base.baseClass;
import com.orangeHrm.pages.HomePage;
import com.orangeHrm.pages.LoginPage;

public class HomePageTest extends baseClass {

	LoginPage loginPage;
	HomePage homePage; 
	public HomePageTest(){
		super();
	}
	
	//test cases should be independent or separated
	@BeforeMethod
	public void setUp() {
		//initialization();
		loginPage = new LoginPage();
		
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void verifyUserNameTest(){
		boolean flag = homePage.validatefullName();
		Assert.assertFalse(flag);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
