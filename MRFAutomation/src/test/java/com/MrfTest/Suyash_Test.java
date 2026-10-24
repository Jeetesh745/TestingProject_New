package com.MrfTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mrfTyres.Base.BaseClass;

import utility.AppConstants;

public class Suyash_Test {
	
	public class MRFTestCars extends BaseClass {

	    @Test (priority=1)
	    public void verifyCarWebPageText() throws InterruptedException {

	        homePage.clickOnPassengerCars();

	        String actualText = carPage.webPageText();

	        String expText = AppConstants.Manufacturer_Recommended_Tyre_Text;
	        		//"dddd";
	        Assert.assertEquals(actualText, expText);
	    }

}
}