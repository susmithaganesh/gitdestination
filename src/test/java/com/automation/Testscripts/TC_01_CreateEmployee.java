package com.automation.Testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_01_CreateEmployee {

	@Test
	
	public void createEmployee() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Eclipse Workspace\\HRM\\src\\test\\resources\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys("susmitha");
		driver.findElement(By.id("lastName")).sendKeys("Gajjarapu");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text() ='Logout']")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
				
		
	}	
	
}
