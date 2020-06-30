package com.weathertech.datadriven;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class RegExelPositiveTests {


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
			String Confirm_Password = current_row.getCell(2).getStringCellValue();
			String First_Name = current_row.getCell(3).getStringCellValue();
			String Last_Name = current_row.getCell(4).getStringCellValue();
			String Address_1 = current_row.getCell(5).getStringCellValue();
			String City = current_row.getCell(6).getStringCellValue();
			String State = current_row.getCell(7).getStringCellValue();
			int ZIP = (int)current_row.getCell(8).getNumericCellValue();
			int Phone = (int)current_row.getCell(9).getNumericCellValue();
			
			
		    // Click on My Account
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(".icon-my_account")).click();
			
			
			
			
			   // Click on Register Button
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			WebElement registerbutton = driver.findElement(By.xpath("//input[@id='CT_Main_0_btnRegister']"));
			registerbutton.click();      
			
			
			

			// Entering account details block
			driver.findElement(By.id("CT_Main_0_txtBillingEmail")).sendKeys(Email);
			driver.findElement(By.id("CT_Main_0_txtPassword")).sendKeys(Password);
			driver.findElement(By.id("CT_Main_0_txtConfirmPassword")).sendKeys(Confirm_Password);
			
			
			// Entering billing address block
			driver.findElement(By.xpath("//input[@name='CT_Main_0$txtBillingFirstName']")).sendKeys(First_Name);
			driver.findElement(By.xpath("//input[@name='CT_Main_0$txtBillingLastName']")).sendKeys(Last_Name);
			driver.findElement(By.xpath("//input[@id='CT_Main_0_txtBillingAddress1']")).sendKeys(Address_1);
			driver.findElement(By.xpath("//input[@id='CT_Main_0_txtBillingCity']")).sendKeys(City);
			// State selection
			Select dropstate = new Select(driver.findElement(By.xpath("//select[@id='CT_Main_0_drpBillingState']")));
			dropstate.selectByVisibleText(State);
			driver.findElement(By.xpath("//input[@id='CT_Main_0_txtBillingZip']")).sendKeys(String.valueOf(ZIP));
			driver.findElement(By.xpath("//input[@id='CT_Main_0_txtBillingPhone']")).sendKeys(String.valueOf(Phone));
			
			
			
			
			// Click Register
			WebElement reg = driver.findElement(By.xpath("//input[@id='CT_Main_0_btnSubmit']"));
			reg.click();
			
			
			
			
			// Verifications:
			
			if (driver.getTitle().contains("My Account")) {
				System.out.println("Registration completed " + row + " record");
				
				// Click Logout
				driver.findElement(By.xpath("//input[@id='btnLogOut']")).click();
				// Click MyAccount
//				driver.findElement(By.cssSelector(".icon-my_account")).click();
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





