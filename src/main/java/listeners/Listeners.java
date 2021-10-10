package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.TestUtility;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result)
	{
		System.out.println("onTestStart: Instance Name - " + result.getInstanceName());
		System.out.println("onTestStart: Instance Name - " + result.getTestName());
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("onTestSuccess: Instance Name - " + result.getInstanceName());
		System.out.println("onTestSuccess: Instance Name - " + result.getStatus());
		TestUtility.attachScreenshotToReport();
	}
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("onTestFailure: Instance Name - " + result.getInstanceName());
		System.out.println("onTestFailure: Instance Name - " + result.getTestName());
		TestUtility.attachScreenshotToReport();
	}
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("On start: Instance Name - " + result.getInstanceName());
		System.out.println("On start: Instance Name - " + result.getTestName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("On Failue percent: Instance Name - " + result.getInstanceName());
		System.out.println("On Failur percent:TestCase - " + result.getTestName());
	}
	public void onStart(ITestContext context) 
	{
		System.out.println("On start: Suite - " + context.getSuite());
		System.out.println("On start: all method - " + context.getAllTestMethods());
		System.out.println("On start: Instance Name - " + context.getOutputDirectory());
		System.out.println("On start: Instance Name - " + context.getAttributeNames());
		//TestUtility.attachScreenshotToReport();
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("On Finish: Suite - " + context.getFailedConfigurations());
		System.out.println("On Finish: Suite - " + context.getPassedConfigurations());
		System.out.println("On Finish: Suite - " + context.getPassedTests());
		System.out.println("On Finish: Suite - " + context.getFailedTests());
		//TestUtility.attachScreenshotToReport();
	}
}
