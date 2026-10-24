package com.mrf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import com.mrftyres.base.BaseClass.*;
import driverFactory.DriverFactory;

public class MRFHomePageCopy  {
	WebDriver driver = DriverFactory.getDriver();


@FindBy(xpath="//p[text()='passenger cars']") WebElement PassengerCarsButton; 
@FindBy(xpath="(//p[text()='Two Wheelers'])[1]") WebElement TwoWheelersButton;


public MRFHomePage(WebDriver driver){
	this.driver=driver;
	//This initElements method will create  all WebElements
	PageFactory.initElements(driver, this);
}

public void clickOnPassengerCars() {
	 PassengerCarsButton.click();
}

public void clickOnTwoWheelers() {
	TwoWheelersButton.click();
}

}
