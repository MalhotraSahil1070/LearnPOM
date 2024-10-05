package com.LambdaTest.pageMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.LambdaTest.pageObjects.FormPageObjects;


public class FormPageMethods {
	
	FormPageObjects loginpageObjects;
    WebDriver driver;
	
	
	public FormPageMethods(WebDriver driver)
	{
		loginpageObjects = new FormPageObjects(driver);
		this.driver = driver;
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getPageHeading()
	{
		return loginpageObjects.pageHeading.getText();
	}
	
	public String getFormHeading()
	{
		return loginpageObjects.formHeading.getText();
	}
	
	
	
public void submitForm(String Name,String Email,String Password,String Company,String WebSite,String City,String Address1,String Address2,String State,String ZipCode) throws InterruptedException
	
	{
	    loginpageObjects.name.clear();
		loginpageObjects.name.sendKeys(Name);
		
		loginpageObjects.companyname.clear();
		loginpageObjects.companyname.sendKeys(Company);
		
		loginpageObjects.websitename.clear();
		loginpageObjects.websitename.sendKeys(WebSite);	
		
		loginpageObjects.city.clear();
		loginpageObjects.city.sendKeys(City);
	        
        loginpageObjects.password.clear();
		loginpageObjects.password.sendKeys(Password);
		
		
		loginpageObjects.address1.clear();
		loginpageObjects.address1.sendKeys(Address1);
		
		loginpageObjects.address2.clear();
		loginpageObjects.address2.sendKeys(Address2);
		
		loginpageObjects.state.clear();
		loginpageObjects.state.sendKeys(State);
		
		loginpageObjects.zipcode.clear();
		loginpageObjects.zipcode.sendKeys(ZipCode);
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='testuser@example.com';", loginpageObjects.email);
	}
	
	
	
	

}
