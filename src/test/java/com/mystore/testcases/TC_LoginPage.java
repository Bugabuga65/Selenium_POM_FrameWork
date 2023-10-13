package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.cartPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.loginPage;
import com.mystore.pageobject.productPage;
import com.mystore.pageobject.signUpPage;

public class TC_LoginPage extends baseClass {

	@Test(enabled = false)
	public void verifyUserLoginAndRegis() {

		// click sign in
		indexPage ipg = new indexPage(driver);
		ipg.clickSignIn();
		logger.info("signin button clicked");

		// enter signup details
		loginPage lpg = new loginPage(driver);
		lpg.enterName("John");
		logger.info("entered name");
		lpg.enterEmail("john@lol.com");
		logger.info("entered email");
		lpg.clicksignUp();
		logger.info("signup button clicked");

		// Entering signup page and filling details
		signUpPage spg = new signUpPage(driver);
		spg.userPassword("john123");
		spg.userFisrtName("John");
		spg.userLastName("Doe");
		spg.userAddress("House No.:21, Geeta Colony");
		spg.userCountry("Canada");
		spg.userState("Punjab");
		spg.userCity("Faridabad");
		spg.userZipCode("111");
		spg.userNumber("12345367890");
		spg.clickCreateAccount();
		logger.info("create account btn clicked");

		// Click Continue btn
		spg.clickContinue();

		// Validate username
		String userNameIs = spg.getUserName();

		Assert.assertEquals("John", userNameIs);

	}

	@Test(enabled = false)
	public void verifyLogin() throws IOException {
		// click sign in
		indexPage ipg = new indexPage(driver);
		ipg.clickSignIn();
		logger.info("signin button clicked");

		// enter signin details
		loginPage lpg = new loginPage(driver);
		lpg.loginEmail("john@lol.com");
		lpg.enterPassword("john123");
		lpg.clickSignIn();
		logger.info("signin button clicked");

		signUpPage spg = new signUpPage(driver);
		String userNameIs = spg.getUserName();
		if (userNameIs.equals("John")) {
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
		} else {

			logger.info("VerfiLogin - Failed");
			captureScreenshot(driver, "verifyLogin");
			Assert.assertTrue(false);
			;
		}
	}

	@Test(enabled = false)
	public void searchProduct() throws IOException, InterruptedException {
		// click sign in
		indexPage ipg = new indexPage(driver);
		ipg.clickSignIn();
		logger.info("signin button clicked");

		// enter signin details
		loginPage lpg = new loginPage(driver);
		lpg.loginEmail("john@lol.com");
		lpg.enterPassword("john123");

		// click sign in
		lpg.clickSignIn();
		logger.info("signin button clicked");

		// Click Product Tab
		lpg.clickProductTab();

		productPage ppg = new productPage(driver);

		// Click and enter in searchbox
		ppg.clickSearchBox();
		ppg.enterSearchBox("T-Shirts");
		ppg.clickSearchBtn();

		String SearchBoxItem = ppg.getSearchBoxItems();
		System.out.println("search box = " + SearchBoxItem);
		if (SearchBoxItem.contains("T-Shirts")) {
			logger.info("searchProduct - Passed");
			Assert.assertTrue(true);
			lpg.clickSignOut();
		} else {

			logger.info("searchProduct - Failed");
			captureScreenshot(driver, "verifyLogin");
			Assert.assertTrue(false);
			;
		}
	}

	@Test
	public void buyProduct() throws IOException {
		// click sign in
		indexPage ipg = new indexPage(driver);
		ipg.clickSignIn();
		logger.info("signin button clicked");

		// enter signin details
		loginPage lpg = new loginPage(driver);
		lpg.loginEmail("john@lol.com");
		lpg.enterPassword("john123");

		// click sign in
		lpg.clickSignIn();
		logger.info("signin button clicked");

		// Click Product Tab
		lpg.clickProductTab();

		productPage ppg = new productPage(driver);

		// Click and enter in searchbox
		ppg.clickSearchBox();
		ppg.enterSearchBox("T-Shirts");
		ppg.clickSearchBtn();

		// click view product
		ppg.clickViewProduct();

		// click product quantity
		ppg.clickProductQuantity();

		// clear product quantity
		ppg.clearProductQuantity();

		// add product quantity
		ppg.addProductQuantity("2");

		// add to cart
		ppg.clickAddToCart();

		// click view cart
		ppg.clickViewCart();

		cartPage cpg = new cartPage(driver);
		String cartQuantity = cpg.getCartQuantity();
		if (cartQuantity.equals("2")) {
			logger.info("Cart Quantity - Passed");
			Assert.assertTrue(true);
		} else {

			logger.info("Cart Quantity - Failed");
			captureScreenshot(driver, "buyProduct");
			Assert.assertTrue(false);
			;
		}

		// proceed to checkout
		cpg.clickCheckout();

		// click place order button
		cpg.clickPlaceOrder();
		
		//click sign out
		lpg.clickSignOut();
	}

}
