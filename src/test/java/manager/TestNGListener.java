package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    Logger logger = LoggerFactory.getLogger(TestNGListener.class);


    @Override
    public void onTestStart(ITestResult result) {
        logger.info("TestNG event onTestStart getName: " + result.getName());
        logger.info("TestNG event onTestStart getHost: " + result.getHost());
        logger.info("TestNG event onTestStart getTestContext: " + result.getTestContext());
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info("TestNG event onTestSuccess getTestContext: " + result.getTestContext());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.warn("TestNG event onTestFailure getName: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.warn("TestNG event onTestSkipped getName: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        logger.info("TestNG event onTestFailedButWithinSuccessPercentage getName: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        logger.error("TestNG event onTestFailedWithTimeout getName: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("TestNG event onStart getStartDate: " + context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("TestNG event onFinish getPassedTests: " + context.getPassedTests());
        logger.info("TestNG event onFinish getFailedTests: " + context.getFailedTests());
        logger.info("TestNG event onFinish getSkippedTests: " + context.getSkippedTests());
    }
}
