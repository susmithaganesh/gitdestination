package com.automation.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {

	@FindBy(id="menu_pim_viewPimModule")
	private WebElement pim;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement Add;
	
	@FindBy(id="firstName")
	private WebElement Fname;
	
	@FindBy(id="lastName")
	private WebElement Lname;
	
	@FindBy(id="btnSave")
	
	private WebElement save;
	
	
	public EmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void employee(String firstName,String lastName)
	{
		pim.click();
		Add.click();
		Fname.sendKeys(firstName);
		Lname.sendKeys(lastName);
		save.click();
		
	}
	
	
	
}
