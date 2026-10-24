package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
 public static ExtentReports getReport() {
	String path = System.getProperty("User.dir")+"/test-output/ExtentReport.html";
	ExtentSparkReporter extentsSparkReporter= new ExtentSparkReporter(path);
	extentsSparkReporter.config().setReportName(" QA Automation Report");
	extentsSparkReporter.config().setDocumentTitle("Selenium Test Execution Repor");
	
	ExtentReports extentReports= new ExtentReports();
	extentReports.attachReporter(extentsSparkReporter);
	
	extentReports.setSystemInfo("OS", "WIN_11");
	extentReports.setSystemInfo("ENV", "QA");
	extentReports.setSystemInfo("empID", "1");
	
	return extentReports;
 }
}
