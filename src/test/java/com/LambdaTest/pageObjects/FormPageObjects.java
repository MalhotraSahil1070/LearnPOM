package com.LambdaTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FormPageObjects {
	
	
	public FormPageObjects(WebDriver driver) 
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
				
	}
	
	public @FindBy(xpath = "//*[@id='__next']/div/section[1]/div/div/h1")
	WebElement pageHeading;
	
	public @FindBy(xpath = "//*[@id=\"__next\"]/div/section[2]/div/div/div/h2")
	WebElement formHeading;
	
	public @FindBy(id = "name") 
	WebElement name;
	
	public @FindBy(name = "email") 
	WebElement email;
	
	public @FindBy(name = "password") 
	WebElement password;
	
	public @FindBy(id = "company") 
	WebElement companyname;
	
	public @FindBy(id = "websitename") 
	WebElement websitename;
	
	public @FindBy(id = "inputCity") 
	WebElement city;
	
	public @FindBy(name = "address_line1") 
	WebElement address1;
	
	public @FindBy(name = "address_line2") 
	WebElement address2;
	
	public @FindBy(id = "inputState") 
	WebElement state;
	
	public @FindBy(id = "inputZip") 
	WebElement zipcode;
	
	

}
