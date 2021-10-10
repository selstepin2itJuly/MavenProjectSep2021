package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener implements WebDriverEventListener {

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("URL:"+url);
			
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("URL:"+url);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before Find By:"+by.toString());
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("After Find By:"+by.toString());
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before click:"+element.toString());
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After Click:"+element.toString());
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before change Value of:"+element.toString()+"-"+keysToSend);
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("after Change Value of:"+element.toString()+"-"+keysToSend);
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before Switch Window:"+windowName.toString());
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After Switch Window:"+windowName.toString());
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("On exception:"+throwable.toString());
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Before Screenshot:"+target.toString());
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("After Screenshot:"+target.toString()+"--->"+screenshot.toString());
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Before get text:"+element.toString());
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("After get text:"+element.toString());
		
	}

}
