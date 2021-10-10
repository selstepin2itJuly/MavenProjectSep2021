package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import listeners.WebEventListener;

public class TestBase {

	public static String browser;
	public static WebDriver dr;
	public static Properties prop;
	private static EventFiringWebDriver e_driver;
	private static WebEventListener eventListener;
	public static WebDriver getInstance() throws IOException
	{
		File f=new File("./src/main/resources/config/config.properties");
		FileInputStream file=new FileInputStream(f);
		prop=new Properties();
		prop.load(file);
		browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
			dr=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxagent"));
			dr=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("ieagent"));
			dr=new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
			dr=new EdgeDriver();
		}else
		{
			Throwable thr=new Throwable();
			thr.initCause(null);
		}
		
		e_driver=new EventFiringWebDriver(dr);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		e_driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		e_driver.manage().window().maximize();
		//dr.manage().window().fullscreen();
		e_driver.get(prop.getProperty("url"));
		return e_driver;
	}
}
