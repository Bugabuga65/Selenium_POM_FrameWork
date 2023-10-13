package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
	// 1. Create object of webdriver
	WebDriver ldriver;

	// constructor
	public productPage(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	// SearchBox
	@FindBy(xpath ="//*[@id=\"search_product\"]")
	WebElement searchBox;

	// search button
	@FindBy(id = "submit_search")
	WebElement searchBtn;

	// click add btn
	@FindBy(xpath = "//button[@type='button']")
	WebElement addToCart;

	// productname
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p")
	WebElement productResult;

	// click view product
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
	WebElement viewProduct;

	// click quantity
	@FindBy(id = "quantity")
	WebElement productQuantity;
	
	//click view cart
	@FindBy(linkText = "View Cart")
	WebElement viewCart;

	// Click SearchBox
	public void clickSearchBox() {
		searchBox.click();
	}

	// Enter in searchBox
	public void enterSearchBox(String searchbox) {
		searchBox.sendKeys(searchbox);
	}

	// click search button
	public void clickSearchBtn() {
		searchBtn.click();
	}

	// click add to cart
	public void clickAddToCart() {
		addToCart.click();
	}

	// get text from searched item
	public String getSearchBoxItems() {
		return productResult.getText();
	}

	// click view product
	public void clickViewProduct() {
		viewProduct.click();
	}

	// click product quantity
	public void clickProductQuantity() {
		productQuantity.click();
	}

	// clear product quantity
	public void clearProductQuantity() {
		productQuantity.clear();
	}

	// add product quantity
	public void addProductQuantity(String quantity) {
		productQuantity.sendKeys(quantity);
	}
	
	// click View cart
		public void clickViewCart() {
			viewCart.click();
		}
}