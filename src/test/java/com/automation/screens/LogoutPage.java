package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy(id="welcome")
	private WebElement Welcome;
	
	
	@FindBy(linkText = "Logout")
	
	private WebElement logout;
	
	
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		Welcome.click();
		logout.click();
	}
	
	

}
