package com.mrfTyres.Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.mrf.pages.MRFHomePage;
import com.mrf.pages.MRFPassengerCarsPage;
import com.mrf.pages.MRFTwoWheelersPage;

import driverFactory.DriverFactory;
import utility.Utils;

public class BaseClass {
	protected MRFHomePage homePage;
	protected MRFPassengerCarsPage carPage;
	protected MRFTwoWheelersPage twoWheelers;
	DriverFactory driverFactory;
	WebDriver driver;
	SoftAssert softAssert;

//	@Parameters("env")
//	@BeforeSuite
//	public void beforeSuite(String env) {
//
//	    System.out.println("Running in Environment: " + env);
//
//	}

	@BeforeMethod
	public void Setup() throws IOException {
		DriverFactory.initBrowser();

		driver = DriverFactory.getDriver();

		homePage = new MRFHomePage(driver);
		carPage = new MRFPassengerCarsPage(driver);
		twoWheelers = new MRFTwoWheelersPage(driver);
		int timeout = Integer.parseInt(Utils.ReadDataFromPropertiesFile("timeout"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void TearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String fileName = result.getName();
			Utils.TakeScreenshot(driver, fileName);

		}

		if (driver != null) {
	        driver.quit();
	    }

	}

}
