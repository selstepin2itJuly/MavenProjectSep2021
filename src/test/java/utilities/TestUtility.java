package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;


public class TestUtility extends TestBase{
	
	public static void waitForElement(WebElement e)
	{
		WebDriverWait wait=new WebDriverWait(dr, 20);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public static void waitForElementClickable(WebElement e)
	{
		WebDriverWait wait=new WebDriverWait(dr, 20);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		
	}
	
	public static void waitForElementFluent(WebElement e)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(dr);
		wait.withTimeout(30, TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}
	
	
	public static void scrollIntoViewElement(WebElement ele)
	{
		JavascriptExecutor je=(JavascriptExecutor) dr;
		je.executeScript("arguments[0].scrollIntoView(false);", ele);
		je.executeScript("window.scrollBy(0,400)", "");
	}
	
	public static void clickOnElementJSE(WebElement ele)
	{
		JavascriptExecutor je=(JavascriptExecutor) dr;
		je.executeScript("arguments[0].click();", ele);
	}
	
	public static void getScreenshot() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) dr;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDate()+"_image.jpg"));
		
	}

	public static void getElementScreenshot(WebElement ele) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) dr;
		File file=ele.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDate()+"_Element.jpg"));
	}
	
	public static String getDate()
	{
		Date dt=new Date();
		//System.out.println(dt);
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
		String s = sdf.format(dt);
		return s;
	}
	
	public static void attachScreenshotToReport()
	{
		TakesScreenshot c=(TakesScreenshot) dr;
		String file = c.getScreenshotAs(OutputType.BASE64);
		String st= "<img src=\"data:image/png;base64, " + file + "\" height=\"600\" width=\"800\" />";
		Reporter.log(st);
	}
}
