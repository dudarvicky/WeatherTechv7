package com.weathertech.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{
	
	private String pageUrl = "https://www.weathertech.com/my-account/login/";
	
	private By EmailField = By.xpath("//input[@id='CT_Main_0_txtUsername']");
	private By PasswordField = By.xpath("//input[@id='CT_Main_0_txtPassword']");
	private By LoginButton = By.xpath("//input[@id='CT_Main_0_btnLogin']");
	private By RegisterButton = By.xpath("//input[@id='CT_Main_0_btnRegister']");
	private By errorDetails = By.xpath("//div[@class='errorDetails']");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**  Execute login  */
	public MyAccountPage logIn(String email, String password) {
		log.info("Executed logIn with username: " + email + " and password: "+password);
		type(email, EmailField);
		type(password, PasswordField);
		click(LoginButton);
		return new MyAccountPage(driver, log);
	}
	
	/** Open RegistrationPage by clicking of RegisterButton */
	public RegistrationPage clickRegisterButton() 
	{
		log.info("Clicked RegisterButton on Login Page");
		click(RegisterButton);
		return new RegistrationPage(driver, log);		
	} 
	
	
	/**  Enter email  */
	public void enterEmail(String email) {
		type(email, EmailField);
	}
	/**  Enter password  */
	public void enterPassword(String password) {
		type(password, PasswordField);
	}
	/**  click login button  */
	public void clickLogin() {
		click(LoginButton);
	}
	/** Get URL variable from PageObject  */
	public String getPageUrl() {
		return pageUrl;
	}
	
	/** Return text from Error Message */
	public String getErrorDetailsText() {
		return find(errorDetails).getText();
	}

	

}
