package dataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import utility.Utils;

public class twoWheelerTyreDataProvider {
	@DataProvider(name = "twoWheelerTestData")
	public Object[][] getTwoWheelerData() throws EncryptedDocumentException, IOException {

		return new Object[][] {
				{ Utils.readDataFromExcel("Vehicle", 1, 0), 
				Utils.readDataFromExcel("Vehicle", 1, 1),
				Utils.readDataFromExcel("Vehicle", 1, 2) },

				{ Utils.readDataFromExcel("Vehicle", 2, 0), 
				Utils.readDataFromExcel("Vehicle", 2, 1),
				Utils.readDataFromExcel("Vehicle", 2, 2) } };
	}
}
