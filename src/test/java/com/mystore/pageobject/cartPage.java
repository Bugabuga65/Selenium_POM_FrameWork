package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
	// 1. Create object of webdriver
	WebDriver ldriver;

	// constructor
	public cartPage(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	// quantity
	@FindBy(xpath = "//tr[@id='product-30']/td[4]/button")
	WebElement cartQuantity;

	// checkout btn
	@FindBy(linkText = "Proceed To Checkout")
	WebElement checkoutBtn; 
	
	//place order btn
	@FindBy(linkText = "Place Order")
	WebElement placeOrderBtn;

	// get quantity
	public String getCartQuantity() {
		return cartQuantity.getText();
	}
	
	//click checkout
	public void clickCheckout() {
		checkoutBtn.click();
	}
	
	//click Place Order
		public void clickPlaceOrder() {
			placeOrderBtn.click();
		}

}