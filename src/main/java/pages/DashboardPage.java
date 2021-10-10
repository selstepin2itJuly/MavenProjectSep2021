package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class DashboardPage {

	private WebDriver dr;
	public DashboardPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="welcome")
	private WebElement welcomMsg;
	
	@FindBy(id="menu_dashboard_index")
	private WebElement dashboard;
	
	@FindBy(className="quickLinkText")
	private List<WebElement> quicklink;
	
	public boolean isWelcomeMsgDisplayed()
	{
		boolean b=false;
		try {
			TestUtility.waitForElement(welcomMsg);
			b=welcomMsg.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;	
	}
	
	public void clickOnDashboardTab()
	{
		dashboard.click();
	}
	
	public List<String> getQuickLaunchItems()
	{
		List<String> temp=new ArrayList<String>();
		TestUtility.waitForElement(quicklink.get(0));
		for(WebElement e:quicklink)
		{
			temp.add(e.getText());
		}
		return temp;
	}
	
	public int getQuickLaunchItemCount()
	{
		return quicklink.size();
	}
}

