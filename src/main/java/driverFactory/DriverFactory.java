package driverFactory;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import utility.Utils;

public class DriverFactory {
	static ThreadLocal<WebDriver>driver=new ThreadLocal<>();
		
	
	public static WebDriver initBrowser() throws IOException {
		String browsername=Utils.ReadDataFromPropertiesFile("browser");
		 boolean incognitomode = Boolean.parseBoolean(Utils.ReadDataFromPropertiesFile("incognito"));
		 boolean headlessmode =Boolean.parseBoolean(Utils.ReadDataFromPropertiesFile("headless"));
		
		if(browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions co=OptionsManager.getChromeOptions(incognitomode, headlessmode);
			driver.set(new ChromeDriver(co));
			
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			OptionsManager.getEdgeOptions(incognitomode, headlessmode);
			driver.set(new EdgeDriver());
			
		}
		driver.get().manage().window().maximize();
		driver.get().get(Utils.ReadDataFromPropertiesFile("url"));
		return driver.get();
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	
}
