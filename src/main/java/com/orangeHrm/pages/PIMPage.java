package com.orangeHrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.base.baseClass;

public class PIMPage extends baseClass {
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PimMenu_Btn;
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement AddEmpMenu_Btn;
	
	
	@FindBy(id="firstName")
	WebElement EmpFirstName;
	
	@FindBy(id="lastName")
	WebElement EmpLastName;
	
	@FindBy(xpath="//input[@type='button']")
	WebElement Emp_Save_Btn;
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
			public void clickonPimMenu(){
			PimMenu_Btn.click();	
			}
			
			public void AddEmpInPIM(String empFName, String empLName) {
				AddEmpMenu_Btn.click();
				EmpFirstName.sendKeys(empFName);
				EmpLastName.sendKeys(empLName);
				Emp_Save_Btn.click();
				
			}
			
	
}
