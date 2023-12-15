package com.cicdseleniumframework.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cicdseleniumframework.qa.base.Base;

public class RegisterTest extends Base {

	public WebDriver driver;
	
	public RegisterTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp ()
	{
		driver = openApplicationUrl(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
	}
	
	@AfterMethod
	public void tearDown ()
	{
		driver.quit();
	}
	
	@Test
	public void verifyRegisteringAnAccount()
	{
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Anupam");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Chandan");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("anupam.chandan@yahoo.com");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("human123");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("human123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String warningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(warningMessage.contains("Mail Address is already registered"));
		
	}
	
	@Test
	public void verifyRegisterwithoutFillingDetails()
	{
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String warningMessage = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertTrue(warningMessage.contains("First Name must be between 1 and 32 characters"));
		
	}
}
