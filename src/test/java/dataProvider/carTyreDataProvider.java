package dataProvider;

import org.testng.annotations.DataProvider;

public class carTyreDataProvider {
	@DataProvider(name = "carTestData")
	public Object[][] getCarData() {

		return new Object[][] { 
			{ "MARUTI", "GRAND VITARA", "MARUTI GRAND VITARA" },
				{ "HYUNDAI", "CRETA", "HYUNDAI CRETA" }, 
				{ "TOYOTA", "CAMRY", "TOYOTA CAMRY" } };
	}
}