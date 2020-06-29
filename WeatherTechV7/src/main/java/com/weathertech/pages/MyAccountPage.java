package com.weathertech.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePageObject{
	
	private String pageUrl = "https://www.weathertech.com/my-account/";
	
	private By logOutButton = By.xpath("//input[@id='btnLogOut']");
	private By myAccountInc = By.xpath("//h1[@class='pageHeading-lg']");
	
	
	public MyAccountPage(WebDriver driver, Logger log) {
		super(driver, log);	
	}
	
	
	/** Get URL variable from PageObject  */
	public String getPageUrl() {
		return pageUrl;
	}
	
	
	/**  Verification if logOutButton is visible on the page  */
	public boolean isLogOutButtonVisible() {
		return find(logOutButton).isDisplayed();
	}
	
	/** Return text from MyAccount inscription */
	public String getMyAccountInscriptionText() {
		return find(myAccountInc).getText();
	}

}
