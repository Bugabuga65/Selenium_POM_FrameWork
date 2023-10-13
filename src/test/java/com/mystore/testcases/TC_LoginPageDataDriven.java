package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.loginPage;
import com.mystore.pageobject.signUpPage;
import com.mystore.utilities.ReadExcelFile;

public class TC_LoginPageDataDriven extends baseClass {

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
		spg.userPassword("123");
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

	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail, String userPass, String expectedUserName) throws IOException {
		// click sign in
		indexPage ipg = new indexPage(driver);
		ipg.clickSignIn();
		logger.info("signin button clicked");

		// enter signin details
		loginPage lpg = new loginPage(driver);
		lpg.loginEmail(userEmail);
		lpg.enterPassword(userPass);
		lpg.clickSignIn();
		logger.info("signin button clicked");

		signUpPage spg = new signUpPage(driver);
		String userNameIs = spg.getUserName();
		if (userNameIs.equals(expectedUserName)) {
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			lpg.clickSignOut();
			logger.info("signout button clicked");
		} else {

			logger.info("VerfiLogin - Failed");
			captureScreenshot(driver, "verifyLogin");
			Assert.assertTrue(false);
			;
		}

	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() {
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";
		System.out.println("fileName = " +fileName);
		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");


		String data[][] = new String[ttlRows - 1][ttlColumns];

		for (int i = 1; i < ttlRows; i++)// rows =1,2
		{
			for (int j = 0; j < ttlColumns; j++)// col=0, 1,2
			{

				data[i - 1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}

		}
		return data;
	}
}
