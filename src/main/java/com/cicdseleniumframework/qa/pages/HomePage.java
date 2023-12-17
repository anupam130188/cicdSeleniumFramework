package com.cicdseleniumframework.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	 WebDriver driver;
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement myAccountLogin;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void clickOnMyAccount ()
	{
		try {
			Thread.sleep(10);
			myAccountDropMenu.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public LoginPage selectLoginOption()
	{
		myAccountLogin.click();
		return new LoginPage(driver);
	}
	
	public LoginPage ClickonAccountSelectLoginOption ()
	{
		clickOnMyAccount();
		return selectLoginOption();
	}
}
