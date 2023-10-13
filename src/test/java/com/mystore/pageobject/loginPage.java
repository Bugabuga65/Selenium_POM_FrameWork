package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	//1. Create object of webdriver
		WebDriver ldriver;
		
		//constructor
		public loginPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelements
		@FindBy(xpath = "//input[@type= 'text']")
		WebElement createName;
		
		@FindBy(xpath = "//input[@data-qa= 'signup-email']")
		WebElement createEmail;
		
		@FindBy(xpath = "//button[@data-qa='signup-button']")
		WebElement signUp;
		
		@FindBy(xpath = "//input[@data-qa= 'login-email']")
		WebElement loginEmail; 
		
		@FindBy(xpath = "//input[@type= 'password']")
		WebElement loginPassword;
		
		@FindBy(xpath = "//button[@data-qa='login-button']")
		WebElement signIn;
		
		@FindBy(xpath = "//ul[@class='nav navbar-nav']//li[4]")
		WebElement signOut;
		
		@FindBy(xpath = "//ul[@class='nav navbar-nav']//li[2]")
		WebElement productTab;
		
		//identify action on webelements
		public void enterName(String userName) {
			createName.sendKeys(userName);
		}
		
		public void enterEmail(String userEmail) {
			createEmail.sendKeys(userEmail);
		}
		
		public void loginEmail(String userEmail) {
			loginEmail.sendKeys(userEmail);
		}
		
		public void enterPassword(String userPassword) {
			loginPassword.sendKeys(userPassword);
		}
		
		public void clicksignUp()
		{
			signUp.click();
		}
		
		public void clickSignIn()
		{
			signIn.click();
		}
		
		public void clickSignOut()
		{
			signOut.click();
		}
		
		public void clickProductTab()
		{
			productTab.click();
		}
}
