package TestsLesson9;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class Retry implements IRetryAnalyzer {
    private int attempt = 1;
    private static final int maxRetry = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (attempt<maxRetry){
                attempt++;
                iTestResult.setStatus(TestResult.FAILURE);
                System.out.println("Retrying one more time");
                return true;
            }
            else {
                iTestResult.setStatus(TestResult.FAILURE);
            }
        }else {
         iTestResult.setStatus(TestResult.SUCCESS);
        }
        return false;
    }
}
