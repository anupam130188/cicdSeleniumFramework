package com.cicdseleniumframework.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement LoginEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement loginPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void enterLoginEmail (String email)
	{
		LoginEmail.sendKeys(email);
	}
	
	public void enterLoginPassword(String password)
	{
		loginPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void enterEmailPasswordAndClickLogin (String email,String password)
	{
		enterLoginEmail (email);
		enterLoginPassword(password);
		clickLogin();
	}
}
