package com.orangeHrm.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.base.baseClass;

public class HomePage extends baseClass {
	
	
	@FindBy(id = "welcome")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@id='menu_pim_viewMyDetails']")
	WebElement myInfo;
	
	@FindBy(id = "personal_txtEmpFirstName")
	WebElement FullName;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyInfo() {
		myInfo.click();
	
	}
	
	public boolean validatefullName(){
		myInfo.click();
		return FullName.isEnabled();
	}
	
	public PIMPage returntoPimPage() {
		
		return new PIMPage();
	}

}
