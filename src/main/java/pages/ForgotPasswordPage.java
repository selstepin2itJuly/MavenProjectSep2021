package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class ForgotPasswordPage {

	private WebDriver dr;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="[id='btnSearchValues']")
	private WebElement resetButton;
	
	@FindBy(className="cancel")
	private WebElement cancelButton;
	
	public boolean isResetButtonDisplayed()
	{
			boolean b=false;
			TestUtility.waitForElement(resetButton);
			try {
				b=resetButton.isDisplayed();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return b;	
	}
	
	public void clickOnCancelButtonFYP()
	{
		cancelButton.click();
	}
}
