package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer_ implements IRetryAnalyzer {

	int count = 0;
    int maxRetry = 2;

    public boolean retry(ITestResult result) {
        if (count < maxRetry) {
            count++;
            return true;
        }
        return false;
    }

}
