package manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{

    Logger logger = LoggerFactory.getLogger(TestNGListener.class);
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("started test" + result.getName() );
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("test success" + result.getName() );
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("test failure " + result.getName());
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("test skipped " + result.getName() );
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test Failed But Within Success Percentage " + result.getName());
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.error("Test Failed With Timeout " + result.getName());
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("onStart " + context.getName());
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("onFinish Passed tests: " + context.getPassedTests().toString());
        logger.warn("onFinish Failed tests: " + context.getFailedTests().toString());
        ITestListener.super.onFinish(context);
    }
}
