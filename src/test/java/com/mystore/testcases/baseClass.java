package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	readConfig readConfig = new readConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() {

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;
		}

		// implicit wait of 10s
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logging
		logger = LogManager.getLogger("MyStore");

		// open url
		driver.get(url);
		logger.info("url opened");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	// capture screenshot of failed tc
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {

		// convert webdriver object to take screenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// call screenshotas method to create screenshot
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		// copy image file to destination
		FileUtils.copyFile(src, dest);
	}
}
