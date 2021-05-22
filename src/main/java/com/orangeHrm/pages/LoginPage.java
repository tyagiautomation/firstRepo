package com.orangeHrm.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.orangeHrm.base.baseClass;

@Listeners(com.orangeHrm.base.Listners.class)
public class LoginPage extends baseClass{
	
	//Logger log = Logger.getLogger(com.freecrm.pages.LoginPage.class);
	//PageFactory or ObjectReposiotry(OR:)
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement loginBtn;
	
	@FindBy(id="forgotPasswordLink")
	WebElement forgotPasswordBtn;

	@FindBy(xpath="//img[contains(@src,'images/login/logo.png')]")
	WebElement orangeHrmLogo;
	
	//Initializing the Page Objects:
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
	
	//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return orangeHrmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			//loginBtn.submit();
			    //	JavascriptExecutor js = (JavascriptExecutor)driver;
			    //	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}
		
		public void fwPwd(){
			forgotPasswordBtn.click();
		
			
		}

}
