package driverFactory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsManager {
	
	public static ChromeOptions getChromeOptions(boolean incognito, boolean headless) {

	 ChromeOptions options= new ChromeOptions();
	if(incognito) {
		
		options.addArguments("--incognito");
	}
	if(headless) {
		options.addArguments("--headless=new");
	}
	return options;
	
	}
	
	public static EdgeOptions getEdgeOptions(boolean incognito, boolean headless) {
		EdgeOptions options=new EdgeOptions();
		if(incognito) {
			options.addArguments("--incognito");
		}
		if(incognito) {
			options.addArguments("--headless=new");
		}
		return options;
	}
	
	
}
