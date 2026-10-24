package listeners;
import org.testng.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenersClass2 implements ITestListener {
	private static ExtentReports extent = new ExtentReports();

	private static ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public void onStart(ITestContext context) {

		extent.attachReporter(spark);

		System.out.println("Extent Report Started");
	}

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		extentTest.get().log(Status.INFO, "Test Started");
	}

	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		extentTest.get().log(Status.WARNING, "Test failed but is within success percentage");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("Extent Report Generated");
	}
}
