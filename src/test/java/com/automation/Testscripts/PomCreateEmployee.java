package com.automation.Testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.helper.ExcelHelper;
import com.automation.screens.EmployeePage;
import com.automation.screens.LoginPage;
import com.automation.screens.LogoutPage;

public class PomCreateEmployee {

	@Test(dataProvider = "getTestData")
	public void createEmployee(String userName,String password,String firstName,String lastName) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		LoginPage lo = new LoginPage(driver);
				lo.login(userName,password);
	
	EmployeePage employee = new EmployeePage(driver);
	
	employee.employee(firstName, lastName);
	
	LogoutPage logouts = new LogoutPage(driver);
			
			logouts.logout();
	
	Thread.sleep(3000);
	
	driver.quit();
	}
	
	@DataProvider (name ="getTestData")
	String[][] getTestData() throws Exception
	{
		String[][] data = ExcelHelper.getTestData();
	
		return data;
		
		
	}
	
	
	
	
	
}
