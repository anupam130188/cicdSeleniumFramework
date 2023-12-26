package com.cicdseleniumframework.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	
	public WebDriver driver;
//	@FindBy(xpath = "//input[@id='input-email']")
//	public WebElement LoginEmail;
//	
//	@FindBy(xpath = "//input[@id='input-password']")
//	public WebElement loginPassword;
//	
//	@FindBy(xpath = "//input[@value='Login']")
//	public WebElement loginBtn;
//	
	
	  public LoginPage(WebDriver driver) { 
		  this.driver= driver;
	 // PageFactory.initElements(driver, this);
	  }
	 
	//Actions
	
	public void enterLoginEmail (String email)
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	}
	
	public void enterLoginPassword(String password)
	{
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		//loginPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//loginBtn.click();
	}
	
	public void enterEmailPasswordAndClickLogin (String email,String password)
	{
		enterLoginEmail (email);
		enterLoginPassword(password);
		clickLogin();
	}
}
