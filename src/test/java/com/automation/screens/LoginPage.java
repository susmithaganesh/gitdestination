package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	@FindBy(id="txtUsername")
	
    private WebElement UserName;
	
	
	@FindBy(id="txtPassword")
	
	private WebElement Password;
	
	@FindBy(id="btnLogin")
	
	private WebElement btnlogin;
	
	public LoginPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String userName,String password)
	{
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		btnlogin.click();
		
		
	}
	
}
