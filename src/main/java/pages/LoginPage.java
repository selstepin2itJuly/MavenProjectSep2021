package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver dr;
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(name="txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//*[@value='LOGIN']")
	private WebElement loginButton;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement fyp;
	
	@FindBy(css="[id='spanMessage']")
	private WebElement errorMsg;
	
	public void loginToApplication(String user, String pass)
	{
		
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public void clickOnForgotYourPassword()
	{
		fyp.click();
	}
	
	public boolean isErrorDisplayed()
	{
		boolean b=false;
		try {
			b=errorMsg.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;	
	}
	
	public String getErrorMsg()
	{
		boolean b=false;
		String s=null;
		try {
			b=errorMsg.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(b==true)
		{
			s=errorMsg.getText();
		}
		return s;
	}
	
	public boolean isLoginButtonDisplayed()
	{
		boolean b=false;
		try {
			b=loginButton.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;	
	}
}
