package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class MyInfopage {

	private WebDriver dr;
	public MyInfopage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="menu_pim_viewMyDetails")
	private WebElement myInfoTab;
	
	@FindBy(css="ul[id='sidenav'] a")
	private List<WebElement> sideMenu;
	
	public void clickOnMyInfoTab()
	{
		myInfoTab.click();
	}
	
	public List<String> getMyInfoSideMenuItems()
	{
		List<String> temp=new ArrayList<String>();
		TestUtility.waitForElement(sideMenu.get(0));
		for(WebElement e: sideMenu)
		{
			temp.add(e.getText());
		}
		return temp;
	}
	
	public int getMyInfoSideMenuItemsCount()
	{
		return sideMenu.size();
	}
}
