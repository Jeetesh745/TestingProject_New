package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Utils {

	public static String ReadDataFromPropertiesFile(String Key) throws IOException {
		Properties properties = new Properties();
		FileInputStream file= new FileInputStream("D:\\newGen\\NewWorkspace\\MRFAutomation\\src\\main\\resources\\config\\config.properties");
		properties.load(file);
		String value=properties.getProperty(Key);
		System.out.println("Reading key is "+Key+" & value is "+value);
		return value;
	}
	
	public static void TakeScreenshot(WebDriver driver, String filename) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String path=System.getProperty("user.dir");
		String Timestamp=new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
		File f= new File("D:\\newGen\\NewWorkspace\\MRFAutomation\\ScreenShot"+filename+" "+Timestamp+".png");
		FileHandler.copy(src, f);
		System.out.println("Screen shot Captured");
	}
	
	public static void handleDropDown(WebDriver driver, WebElement locator, String visibleText ) {
		Select select = new Select(locator); 
		select.selectByVisibleText(visibleText);
	}
	public static String readDataFromExcel(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException  {
		FileInputStream excelfile= new FileInputStream("D:\\newGen\\NewWorkspace\\MRFAutomation\\TwoWheelersData.xlsx");
		String data = WorkbookFactory.create(excelfile).getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
		
	}
	
}
