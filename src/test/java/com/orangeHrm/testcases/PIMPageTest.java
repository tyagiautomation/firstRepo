package com.orangeHrm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHrm.base.baseClass;
import com.orangeHrm.pages.HomePage;
import com.orangeHrm.pages.LoginPage;
import com.orangeHrm.pages.PIMPage;
import com.orangeHrm.utility.Xls_Reader;

public class PIMPageTest extends baseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	PIMPage pimPage;
	Xls_Reader excelReader;
	
	//to call the super class constructor
	public PIMPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		homePage = new HomePage();
		pimPage =new PIMPage();
	}

	@Test(priority=0, enabled= false)
	public void verifyAddEmp() {
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage.returntoPimPage();
		pimPage.clickonPimMenu();
		pimPage.AddEmpInPIM("Aakash", "Kumiri");
	}
	
	@DataProvider
	public Object[][] getAddEmpData() {
		
		//excelReader.path ="./testData/collectionrunner.xls";
		Object data[][] = excelReader.getTestData("sheet1");
		return data;
		
	}
	
	@Test(priority=2, dataProvider = "getAddEmpData")
	public void verifyAddEmp1(String fname, String lname) {
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage.returntoPimPage();
		pimPage.clickonPimMenu();
		pimPage.AddEmpInPIM(fname, lname);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
