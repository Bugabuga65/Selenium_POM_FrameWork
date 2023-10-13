package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	//1. Create object of webdriver
	WebDriver ldriver;
	
	//constructor
	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelements
	@FindBy(linkText = "Signup / Login")
	WebElement signIn;
	
	//identify action on webelement
	public void clickSignIn() {
		signIn.click();
	}
	
	
	
	

}
