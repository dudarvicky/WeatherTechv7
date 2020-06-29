package com.weathertech.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	protected WebDriver driver;
	protected Logger log;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	
	

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser, ITestContext ctx) {
		
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		
		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createDriver();
		
		// Maximize browser window
		driver.manage().window().maximize();
}
	
	
	
	@BeforeTest
	public void setExtend() {
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String repName = "WeatherTech_Report-"+timeStamp+".html";
	
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/extent-reports/"+repName);

		htmlReporter.config().setDocumentTitle("Weathertech.com Project");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Build No.", "7");
		extent.setSystemInfo("QA Engineer", "Roman");
		
	}

	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	
		if (result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test case failed is: " + result.getName());
			test.log(Status.FAIL, "ERROR/EXCEPTION: " + result.getThrowable());
			
			
			String screenshotPath = getScreenshot(driver, result.getName());
			test.fail("SCREENSHOT: ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			

		    } else if (result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP, "Test case skipped is: " + result.getName());
			
			} else if (result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, "Test case passed is: " + result.getName());
			}
		   
			driver.quit();
			log.info("Driver closed");
	}
	
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
			String dateName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName +".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;	
		}
	
}
