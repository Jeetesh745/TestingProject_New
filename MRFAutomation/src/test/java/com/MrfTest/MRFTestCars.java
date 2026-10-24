package com.MrfTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mrf.pages.MRFPassengerCarsPage;
import com.mrfTyres.Base.BaseClass;

import dataProvider.carTyreDataProvider;
import utility.AppConstants;

public class MRFTestCars extends BaseClass {

    @Test (priority=1)
    public void verifyCarWebPageText() throws InterruptedException {

        homePage.clickOnPassengerCars();

        String actualText = carPage.webPageText();

        String expText = AppConstants.Manufacturer_Recommended_Tyre_Text;
        		//"dddd";
        Assert.assertEquals(actualText, expText);
    }
    
    @Test(priority = 2)
    public void verifyCarPageTitle() {
        String actualTitle = driver.getTitle();
        String expTitle = "Mercedes-Benz";
        Assert.assertEquals(actualTitle, expTitle);
    }
    
//    @Test (priority=2,  dataProvider = "carTestData", dataProviderClass = carTyreDataProvider.class)
//    public void selectCarTyre(String make, String model, String expectedName) throws InterruptedException {
//    	 homePage.clickOnPassengerCars();
//    	 carPage.selectCarTyre(make,model);
//    	 Assert.assertEquals(carPage.carMakeAndModelName(), expectedName,"TC failed failed to verify car name on booking page");
//    	 
//    }
    

    
    
    
    
    
}