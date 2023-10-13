package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class signUpPage {
	// 1. Create object of webdriver
	WebDriver ldriver;

	// constructor
	public signUpPage(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	// identify webelements
	// Gender - male
	@FindBy(id = "id_gender1")
	WebElement titleMr;

	// Gender - female
	@FindBy(id = "id_gender2")
	WebElement titleMrs;

	// Password
	@FindBy(xpath = "//input[@id='password']")
	WebElement userPass;

	// First Name
	@FindBy(id = "first_name")
	WebElement userFName;

	// Last Name
	@FindBy(id = "last_name")
	WebElement userLName;

	// Address
	@FindBy(id = "address1")
	WebElement userAdd;

	// Country
	@FindBy(id = "country")
	WebElement userCountry;

	// State
	@FindBy(id="state")
	WebElement userState;

	// City
	@FindBy(id="city")
	WebElement userCity;

	// Zip Code
	@FindBy(id = "zipcode")
	WebElement userZipCode;

	// Number
	@FindBy(id = "mobile_number")
	WebElement userNum;

	// Create account btn
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/form/button")
	WebElement createAcc;

	// continue button
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	WebElement cont;

	// username element
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")
	WebElement userIs;

	// Identify actions on webelements
	// Select title Male
	public void selectTitleM() {
		titleMr.click();
	}

	// Select title Female
	public void selectTitleMs() {
		titleMrs.click();
	}

	// Enter Password
	public void userPassword(String pass) {
		userPass.sendKeys(pass);
	}

	// Enter First Name
	public void userFisrtName(String fname) {
		userFName.sendKeys(fname);
	}

	// Enter Last Name
	public void userLastName(String lname) {
		userLName.sendKeys(lname);
	}

	// Enter Address
	public void userAddress(String addr) {
		userAdd.sendKeys(addr);
	}

	// Select Country
	public void userCountry(String country) {
		Select obj = new Select(userCountry);
		obj.selectByVisibleText(country);
	}

	// Enter State
	public void userState(String state) {
		userState.sendKeys(state);
	}

	// Enter City
	public void userCity(String city) {
		userCity.sendKeys(city);
	}

	// Enter ZipCode
	public void userZipCode(String zip) {
		userZipCode.sendKeys(zip);
	}

	// Enter Contact
	public void userNumber(String num) {
		userNum.sendKeys(num);
	}

	// Click Create Account Button
	public void clickCreateAccount() {
		createAcc.click();
	}

	// Click Continue Button
	public void clickContinue() {
		cont.click();
	}

	// get username
	public String getUserName() {
		return userIs.getText();
	}

}
