package testcases;

import org.testng.annotations.Test;

import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ClassOne {
	private static WebDriver dr;
  @Test
  public void f1() {
	  System.out.println("F1");
  }
  @Test
  public void f2() {
	  System.out.println("F2");
  }
  @Test
  public void f3() {
	  System.out.println("F3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
  }

  @BeforeClass
  public void beforeClass() throws IOException {
	  System.out.println("Before Class");
	  dr=TestBase.getInstance();
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
	  dr.quit();
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
	 
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite1111() {
	  System.out.println("Before Suite");
	  
  }

  @AfterSuite
  public void afterSuite222222() {
	  System.out.println("After Suite");
  }

}
