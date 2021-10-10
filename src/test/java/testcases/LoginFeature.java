package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import testdata.TestData;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginFeature {
	private LoginPage lp;
	private ForgotPasswordPage fyp;
	private DashboardPage dp;
	private WebDriver dr;
  @Test(priority=1, description="Verify Login success", groups={"sanity", "Regression"})
  public void LoginSuccess_001() 
  {
	  lp.loginToApplication(TestData.username, TestData.password);
	  Assert.assertTrue(dp.isWelcomeMsgDisplayed());
  }
  
  @Test(priority=2, description="Verify Login unsuccessful",groups={"sanity"})
  public void LoginUnsuccessful_002() 
  {
	  lp.loginToApplication(TestData.invalidUsername, TestData.invalidUsername);
	  Assert.assertTrue(lp.isErrorDisplayed());
  }

  @Test(priority=3, description="Verify forget password link",groups={"sanity", "Regression"})
  public void ForgotPassword_003() 
  {
	  lp.clickOnForgotYourPassword();
	  Assert.assertTrue(fyp.isResetButtonDisplayed());
	  fyp.clickOnCancelButtonFYP();
	  Assert.assertTrue(lp.isLoginButtonDisplayed());
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException 
  {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  fyp=new ForgotPasswordPage(dr);
	  dp=new DashboardPage(dr);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() 
  {
	  dr.quit();
  }

}
