package com.automation.Testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.Frameworks;
import com.automation.helper.ExcelHelper;

public class TC_06_CreateEmployee extends Frameworks {
	
	

	@Test(dataProvider = "getTestData")
	public void createEmployee( String userName,String password,String firstName,String lastName) throws Exception {
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.id("welcome")).click();
		
		driver.findElement(By.linkText("Logout")).click();
		
	}
	
	@DataProvider(name = "getTestData")
	public String[][] getTestData() throws Exception{
		
		String[][] data = ExcelHelper.getTestData();
		
		return data;
		
	}

}

	
	
