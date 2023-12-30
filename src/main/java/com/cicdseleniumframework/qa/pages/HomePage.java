package com.cicdseleniumframework.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	
	 public WebDriver driver;
	 /*
	 * @FindBy(xpath = "//span[text()='My Account']") public WebElement
	 * myAccountDropMenu;
	 */
		/*
		 * @FindBy(linkText = "Login") public WebElement myAccountLogin;
		 */
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
//		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void clickOnMyAccount ()
	{
		try {
			Thread.sleep(10);
//			myAccountDropMenu.click();
			System.out.println("Clicking on clickOnMyAccount option");

			WebElement element = driver.findElement(By.xpath("//span[text()='My Account']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(2);
			//
		System.out.println("Clicked on clickOnMyAccount option");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public LoginPage selectLoginOption()
	{
		driver.findElement(By.linkText("Login")).click();
		//myAccountLogin.click();
		return new LoginPage(driver);
	}
	
	public LoginPage ClickonAccountSelectLoginOption ()
	{
		clickOnMyAccount();
		selectLoginOption();
		return new LoginPage(driver);
	}
}
