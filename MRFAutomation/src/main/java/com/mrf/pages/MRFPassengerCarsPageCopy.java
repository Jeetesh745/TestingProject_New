package com.mrf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import driverFactory.DriverFactory;
import utility.AppConstants;
import utility.Utils;

public class MRFPassengerCarsPageCopy {
	WebDriver driver = DriverFactory.getDriver();

@FindBy(xpath="//p[contains(text(),'Manufacturer recommended ')]") private WebElement webPageText;
@FindBy(id="make-product")private WebElement selectVehicleManufacturerDropDown;
@FindBy(id="model-product")private WebElement selectModelDropDown;
@FindBy(className = "made-for-car-title")private WebElement CarTitle;
@FindBy(css = "body > main > section.tyres-card-sec > div.inner-section.standard-div > div.card-tyres-main-wrapper > div.card-tyres-wrapper > div:nth-child(1) > a")private WebElement tyreCard;


public String webPageText() throws InterruptedException {
	Thread.sleep(2000);
	return webPageText.getText();
}

public  void selectCarTyre(String make, String model) throws InterruptedException {
	Thread.sleep(500);
	Utils.handleDropDown(driver, selectVehicleManufacturerDropDown, make);
	Thread.sleep(500);
	Utils.handleDropDown(driver, selectModelDropDown, model);
	Thread.sleep(500);
	tyreCard.click();
	}
public String carMakeAndModelName() {
	return CarTitle.getText();
}



// Constructor
public MRFPassengerCarsPage(WebDriver driver) {
    this.driver = driver;

    // Initialize WebElements
    PageFactory.initElements(driver, this);
}



}
