package com.automation.Testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_05_CreateEmployee {
	
	
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
	
	 public String[][] getTestData() throws Exception{
		
	
	String[][] data = null;
	
	File file = new File("G:\\Eclipse Workspace\\HRM\\src\\test\\resources\\TestData\\TestData.xlsx");
	FileInputStream input = new FileInputStream(file);
	Workbook wb = WorkbookFactory.create(input);
	
    Sheet sheet = wb.getSheet("Sheet1");
	
	data = new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
	
	for (int rowindex = 0; rowindex<sheet.getPhysicalNumberOfRows();rowindex++){
		{
			for(int colindex = 0;colindex<sheet.getRow(rowindex).getPhysicalNumberOfCells();colindex++)
				
			{
				data[rowindex][colindex]=sheet.getRow(rowindex).getCell(colindex).toString();
			}
		}
		
		
		wb.close();
	}

	
	
	return data;

}
}

