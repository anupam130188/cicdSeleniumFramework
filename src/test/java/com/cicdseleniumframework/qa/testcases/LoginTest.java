package com.cicdseleniumframework.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cicdseleniumframework.qa.base.Base;
import com.cicdseleniumframework.qa.pages.HomePage;
import com.cicdseleniumframework.qa.pages.LoginPage;
import com.cicdseleniumframework.qa.utils.Utilities;

//11.22
//https://www.youtube.com/watch?v=5OBXZMiuYnY&t=1850s

public class LoginTest extends Base{
	LoginPage loginPage;

	public WebDriver driver;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp ()
	{
		driver = openApplicationUrl(prop.getProperty("browserName"));
		System.out.println("URL launched and user landed tp Logintest Page");
		HomePage homePage = new HomePage(driver);
//		homePage.clickOnMyAccount();
//		loginPage=homePage.selectLoginOption();
		loginPage=homePage.ClickonAccountSelectLoginOption();
		System.out.println("User clicked on ClickonAccountSelectLoginOption");
		
	}
	@AfterMethod
	public void tearDown ()
	{
		System.out.println("Driver quit");
		driver.quit();
	}
	
	@Test
	public void verifyLoginWithValidCredentials()
	{

//		loginPage.enterLoginEmail("anupam.chandan@yahoo.com");
//		loginPage.enterLoginPassword("12345");
//		loginPage.clickLogin();
		loginPage.enterEmailPasswordAndClickLogin("anupam.chandan@yahoo.com", "12345");
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@Test
	public void verifyLoginWithInValidPasswordCredentials()
	{

		
//		  driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(
//		  "anupam.chandan@yahoo.com");
//		  driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345678"); 
//		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  loginPage.enterEmailPasswordAndClickLogin("anupam.chandan@yahoo.com", "1234567");
		  Assert.assertTrue(driver.findElement(By.
		  xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
		 	
		
	}
	
	//@Test(dataProvider ="supplyTestData")
	public void verifyLoginWithInValidPasswordCredentialsandDataProvider(String userName,String password)
	{

		
//		  driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(
//				  userName);
//		  driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password); 
//		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		loginPage.enterEmailPasswordAndClickLogin(userName, password);	
  Assert.assertTrue(driver.findElement(By.
		  xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
		
		  	
	}
	
	@DataProvider
	public Object[][] supplyTestData()
	{
		//Object [][] data = {{"anupam.chandan@yahoo.com","12345"},{"anupam.chandan@yahoo.com","12345678"}};
		Object [][] data = Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
}
