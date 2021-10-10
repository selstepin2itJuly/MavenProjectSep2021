package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfopage;
import testbase.TestBase;
import testdata.TestData;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class MyInfoFeature {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfopage ip;
  @Test(priority=2, description="Verify side menu item count",groups={"sanity"})//,dependsOnMethods="getMyInfoSideMenuItems_005" )
  public void getMyInfoSideMenuCount_007() {
	  Assert.assertTrue(dp.isWelcomeMsgDisplayed());
	  ip.clickOnMyInfoTab();
	  Reporter.log("Actual:"+ip.getMyInfoSideMenuItemsCount());
	  Reporter.log("Actual:"+11);
	  Assert.assertEquals(ip.getMyInfoSideMenuItemsCount(), 11);
  }
  
  @Test(priority=1,description="Verify Myinfo Side Menu items", timeOut=5000,enabled=true
		  ,groups={"sanity", "Regression"})
  public void getMyInfoSideMenuItems_005() 
  {
	  ip.clickOnMyInfoTab();
	  List<String> actual = ip.getMyInfoSideMenuItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("Immigration");
	  exp.add("Job");
	  exp.add("Salary");
	  exp.add("Tax exemptions");
	  exp.add("Report-to");
	  exp.add("Qualifications");
	  exp.add("Memberships");
	  Reporter.log("Actual:"+actual);
	  Reporter.log("Actual:"+exp);
	  Assert.assertEquals(actual, exp);
  }
  
  @BeforeClass(alwaysRun=true)
  public void beforeClass() throws IOException {
	  dr=TestBase.getInstance();
	  lp= new LoginPage(dr);// object --> local
	  dp= new DashboardPage(dr);
	  ip=new MyInfopage(dr);
	  lp.loginToApplication(TestData.username, TestData.password);
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  dr.quit();
  }

}
