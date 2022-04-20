package com.automation.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Frameworks {
	
	 protected  WebDriver driver =null;
	
	Properties prop = null;
	@BeforeTest
	public void beforeTest() throws Exception{
		prop = new Properties();
		
		prop.load(new FileInputStream(new File ("Environment.Properties")));	
		
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("MaxTimeOut")),TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("MaxTimeOut")),TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("Url"));
		
		
	}
	
	
	@AfterMethod
	public void closeBrowser() throws Exception
	{
		Thread.sleep(3000);
	driver.quit();
	}
	
	
	@AfterTest
	public void afterTest()
	{
		prop.clear();
	}
	

}
