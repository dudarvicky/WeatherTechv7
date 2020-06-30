package com.weathertech.datadriven;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LogExelPositiveTests {


	public static void main(String[] args) throws IOException {
		
		
		
		
		// Create drive
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Maximize browser window
		driver.manage().window().maximize();

		// Open test page
		String url = "https://www.weathertech.com/";   
		driver.get(url);
				
                               

	    // Getting Data from EXCEL Sheet
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/weathertech/datadriven/WeatherTechData.xlsx");
		                                                                         
		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		// Get first sheet from workbook
		XSSFSheet sheet = workbook.getSheet("Registration");
//		XSSFSheet sheet = workbook.getSheetAt(0);  by index
		
	

		
		// Get first row from the sheet
		int rowcount = sheet.getLastRowNum();   // returns the row count
		
		System.out.println("No. of Records in the Excel sheet:" + rowcount);
		
		for (int row=1; row<=rowcount; row++) {
			
			XSSFRow current_row = sheet.getRow(row);
			
		
	     	String Email = current_row.getCell(0).getStringCellValue(); 	
	     	String Password = current_row.getCell(1).getStringCellValue();
			
			
			
		    // Click on My Account
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(".icon-my_account")).click();
			
			

			// Entering account details block
			driver.findElement(By.id("CT_Main_0_txtUsername")).sendKeys(Email);
			driver.findElement(By.id("CT_Main_0_txtPassword")).sendKeys(Password);
			
			
			
			
			// Click Login
			WebElement reg = driver.findElement(By.xpath("//input[@id='CT_Main_0_btnLogin']"));
			reg.click();
			
			
			
			
			// Verifications:
			
			if (driver.getTitle().contains("My Account")) {
				System.out.println("Registration completed " + row + " record");
				
				// Click Logout
				driver.findElement(By.xpath("//input[@id='btnLogOut']")).click();
			}
			else
			{
			System.out.println("Registration failed for" + row + "record");	
			driver.close();
			}	

		}
		
		System.out.println("Data driven Test Completed");

		// Close browser
		driver.quit();
		file.close();	
	    
	}
}





