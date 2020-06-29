package com.weathertech.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePageObject{
	
	
	private By EmailField = By.xpath("//input[@id='CT_Main_0_txtBillingEmail']");
	private By PasswordField = By.xpath("//input[@id='CT_Main_0_txtPassword']");
	private By ConfirmPasswordField = By.xpath("//input[@id='CT_Main_0_txtConfirmPassword']");
	
	private By FirstNameField = By.xpath("//input[@name='CT_Main_0$txtBillingFirstName']");
	private By LastNameField = By.xpath("//input[@name='CT_Main_0$txtBillingLastName']");
	private By Address1Field = By.xpath("//input[@id='CT_Main_0_txtBillingAddress1']");
	private By CityField = By.xpath("//input[@id='CT_Main_0_txtBillingCity']");
	private By StateField = By.xpath("//select[@id='CT_Main_0_drpBillingState']");
	private By ZIPField = By.xpath("//input[@id='CT_Main_0_txtBillingZip']");
	private By PhoneField = By.xpath("//input[@id='CT_Main_0_txtBillingPhone']");
	
	private By RegisterButton = By.xpath("//input[@id='CT_Main_0_btnSubmit']");
	
	private By errorDetails = By.xpath("//div[@class='errorDetails']");
	
	

	public RegistrationPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**  Enter email  */
	public void enterEmail(String email) {
		type(email, EmailField);
	}
	/**  Enter password  */
	public void enterPassword(String password) {
		type(password, PasswordField);
	}
	/**  Confirm password  */
	public void confirmPassword(String conpassword) {
		type(conpassword, ConfirmPasswordField);
	}
	/**  Enter first name  */
	public void enterFirstName(String firstname) {
		type(firstname, FirstNameField);
	}
	/**  Enter lastname  */
	public void enterLastName(String lastname) {
		type(lastname, LastNameField);
	}
	/**  Enter address1  */
	public void enterAddress1(String address1) {
		type(address1, Address1Field);
	}
	/**  Enter city  */
	public void enterCity(String city) {
		type(city, CityField);
	}
	
	/** This method selects given option from dropdown */
	public void selectState(String i) {
		log.info("Selecting option " + i + " from dropdown");
		WebElement stateElement = find(StateField);
		Select StateField = new Select(stateElement);

		// There are three ways to use Select class
		// #1
		// dropdown.selectByIndex(i);

		// #2
		StateField.selectByValue(i);

		// #3
		// dropdown.selectByVisibleText("Option " + i);
	}
	
	/**  Enter ZIP  */
	public void enterZIP(String ZIP) {
		type(ZIP, ZIPField);
	}
	/**  Enter phone  */
	public void enterPhone(String phone) {
		type(phone, PhoneField);
	}
		
	/**  click register button  */
	public void clickRegisterButton() {
		click(RegisterButton);
	}
	/**  Generate random string  */
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return(generatedString);
	}
	/** Return text from Error Message */
	public String getErrorDetailsText() {
		return find(errorDetails).getText();
	}

}
