package com.cicdseleniumframework.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cicdseleniumframework.qa.utils.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	//2 ways to load proerties. 1. create properties method call it in all other classes or make the
	//load properties inside base class constructor and just call the constructor in each call which internally 
	//will call the parent constructor and load propeties first.
	//OPTION 1 commented
	/*
	 * public void loadPropertiesFile () { prop = new Properties(); File propFile =
	 * new File(System.getProperty("user.dir")+
	 * "src\\main\\java\\cicdSeleniumFrameworkcom\\cicdseleniumframework\\qa\\config\\config.properties"
	 * ); try { FileInputStream fis = new FileInputStream(propFile); prop.load(fis);
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */
	//OPTION 2 create base class constructor
	public Base() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\cicdseleniumframework\\qa\\config\\config.properties");
		System.out.println("System.getProperty(\"user.dir\") "+ System.getProperty("user.dir") );
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public WebDriver openApplicationUrl(String browserName)
	{

	if (browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.setBinary("C:\\Users\\guru\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver();
	}
	else if (browserName.equals("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else if (browserName.equals("edge"))
	{
		driver = new EdgeDriver();
	}
	System.out.println("Browser selected Chrome");		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	driver.get(prop.getProperty("url"));
	System.out.println("Url Launched : "+prop.getProperty("url"));
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return driver;
}
}
