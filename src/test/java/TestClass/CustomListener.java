package TestClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("Test Execution Start :" + context.getName());
    }


    public void onFinish(ITestContext context) {
        System.out.println("Test Execution Finish :" + context.getName());
    }

    public void onTestStart(ITestResult result) {
        System.out.println("Test  Start :" + result.getName());
    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("Test  Success :" + result.getName());
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("Test  Fail :" + result.getName());
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("Test  Skipped :" + result.getName());
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test  Percentage :" + result.getName());
    }


    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
        System.out.println("Test  Fail Timeout :" + result.getName());
    }
}
