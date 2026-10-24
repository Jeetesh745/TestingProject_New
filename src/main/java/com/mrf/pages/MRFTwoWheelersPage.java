package com.mrf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driverFactory.DriverFactory;
import utility.Utils;

public class MRFTwoWheelersPage {
	WebDriver driver = DriverFactory.getDriver();

	@FindBy(id = "front") private WebElement frontTyre;
	@FindBy(css="body > main > section.tyres-card-sec > div.inner-section.standard-div > div.card-tyres-main-wrapper > div.card-tyres-wrapper > div > a")
	private WebElement tyreCard;
	@FindBy(css="#make-product") private WebElement makeDropDown;
	@FindBy(id="model-product") private WebElement modelDropDown;
	@FindBy(className="made-for-car-title") private WebElement vehicleMakeAndModel;
	@FindBy(xpath="//a[@id='product_1'] ") private WebElement backButton;
	
	public MRFTwoWheelersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String frontTyreText() {
		return frontTyre.getText();
	}
	
	public void selectTyre(String make, String model) throws InterruptedException {
		Utils.handleDropDown(driver, makeDropDown, make);
		Thread.sleep(500);
		Utils.handleDropDown(driver, modelDropDown, model);
		Thread.sleep(500);
		tyreCard.click();
	}
	public String VerifyMakeAndModel() {
		return vehicleMakeAndModel.getText();
	}
	public void clickBackButton() {
		backButton.click();
	}
}
