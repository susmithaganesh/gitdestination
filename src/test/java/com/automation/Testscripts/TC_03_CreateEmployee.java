package com.automation.Testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_03_CreateEmployee {

	@Test(dataProvider ="getTestData")
	public void createEmployee(String UserName,String Password,String FirstName,String LastName ) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Eclipse Workspace\\HRM\\src\\test\\resources\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElement(By.id("txtUsername")).sendKeys(UserName);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys(FirstName);
		driver.findElement(By.id("lastName")).sendKeys(LastName);
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text() ='Logout']")).click();
		
		Thread.sleep(2000);
		
		driver.quit();

	
	}	
	@DataProvider(name="getTestData")
	
	 public String[][] getTestData(){
		
	
	String[][] data = new String[2][4];
	
	data[0][0]= "Admin";
	data[0][1]="admin123";
	data[0][2]="susmitha";
	data[0][3]="g";
	
	
	data[1][0]="Admin";
	data[1][1]="admin123";
	data[1][2]="Ganesh";
	data[1][3]="k";

	
	
	
	 return data;
	 
	
	
	}
	
	
	
	
	
	
	
	

}
