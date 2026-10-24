package com.MrfTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mrf.pages.*;
import com.mrfTyres.Base.BaseClass;

import dataProvider.carTyreDataProvider;
import dataProvider.twoWheelerTyreDataProvider;
import driverFactory.DriverFactory;

public class MRFTestTwoWheelers extends BaseClass {
	
	@Test
	public void verifyFrontButton() {
		homePage.clickOnTwoWheelers();
		String text = twoWheelers.frontTyreText();
		boolean result = text.equalsIgnoreCase("Front");
		Assert.assertTrue(result, " Tc failed twoWheeler front web element");
	}
	@Test(priority=2,  dataProvider = "twoWheelerTestData", dataProviderClass = twoWheelerTyreDataProvider.class)
	public void selectTyre2Wheeler(String make, String model, String validationName) throws InterruptedException {
		twoWheelers.selectTyre(make, model);
		Thread.sleep(2000);
		Assert.assertEquals(twoWheelers.VerifyMakeAndModel(), validationName,"TC failed vehicle name did not match");
		twoWheelers.clickBackButton();
	}

	
}
