package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import testdata.TestData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DahboardFeature {
	private LoginPage lp; //object --> instance var --> default value null
	private DashboardPage dp;
	private WebDriver dr;
  @Test(priority=2, description="Verify Quick launch item count", groups={"sanity"})
  public void getDashboardQuickLaunchitemsCount_006() 
  {
	  
	  Assert.assertTrue(dp.isWelcomeMsgDisplayed());
	  dp.clickOnDashboardTab();
	  Assert.assertEquals(dp.getQuickLaunchItemCount(), 6);
  }
  
  @Test(priority=1, description="Verify Quick Launch items", groups={"sanity", "Regression"})
  public void getDashboardQuickLaunchItems_004()
  {
	  List<String> actual = dp.getQuickLaunchItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Assign Leave");
	  exp.add("Leave List");
	  exp.add("Timesheets");
	  exp.add("Apply Leave");
	  exp.add("My Leave");
	  exp.add("My Timesheet");
	  
	  Assert.assertEquals(actual, exp);
  }
  @BeforeClass(alwaysRun=true)
  public void beforeClass() throws IOException {
	  dr=TestBase.getInstance();
	  lp= new LoginPage(dr);// object --> local
	  dp= new DashboardPage(dr);
	  lp.loginToApplication(TestData.username, TestData.password);
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  dr.quit();
  }

}
