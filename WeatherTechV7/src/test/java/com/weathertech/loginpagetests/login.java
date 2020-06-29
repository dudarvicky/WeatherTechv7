package com.weathertech.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weathertech.base.BaseTest;
import com.weathertech.pages.LoginPage;
import com.weathertech.pages.MainPage;
import com.weathertech.pages.MyAccountPage;

public class login extends BaseTest {

	

	@Test
	public void loginTest001() {
		
		
		log.info("Started login test");
		test=extent.createTest("TC_LOG_001");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
			
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();

		// Execute login
		MyAccountPage map = lp.logIn("romdudar@gmail.com", "1qazxsw2");
		
		
		
		// Verifications:
		// New url
		Assert.assertEquals(map.getCurrentUrl(), map.getPageUrl());

		// Logout button is visible
		Assert.assertTrue(map.isLogOutButtonVisible(), "Logout button is not visible");

		// My Account inscription is visible
		String expectedins = "My Account";
		String actualins = map.getMyAccountInscriptionText();
		Assert.assertEquals(actualins, expectedins);
		log.info("Assertions is completed");
		}
	
	@Test
	public void loginTest002() {
		
		log.info("Started login test");
		test=extent.createTest("TC_LOG_002");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		lp.enterEmail("notexisting@email.com");
		lp.enterPassword("1qazxsw2");
		lp.clickLogin();
		
		// Verifications:
		// url
		Assert.assertEquals(lp.getCurrentUrl(), lp.getPageUrl());

		
		// Error message
		String expectedMessage = "The password you entered does not match the one for this account. Please try again, or go to the forgot your password page to retrieve it";
		String actualMessage = lp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions is completed");
		}
	
	@Test
	public void loginTest003() {
		
		log.info("Started login test");
		test=extent.createTest("TC_LOG_003");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		lp.enterEmail("romdudar@gmai.com");
		lp.enterPassword("iNvAliDpassword");
		lp.clickLogin();
		
		// Verifications:
		// url
		Assert.assertEquals(lp.getCurrentUrl(), lp.getPageUrl());

		
		// My Account inscription is visible
		String expectedMessage = "The password you entered does not match the one for this account. Please try again, or go to the forgot your password page to retrieve it";
		String actualMessage = lp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions is completed");
		}
	
	@Test
	public void loginTest004() {
		
		log.info("Started login test");
		test=extent.createTest("TC_LOG_004");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		lp.enterEmail("romdudar@gmai.com");
		lp.enterPassword("");
		lp.clickLogin();
		
		// Verifications:
		// url
		Assert.assertEquals(lp.getCurrentUrl(), lp.getPageUrl());

		
		// My Account inscription is visible
		String expectedMessage = "You must provide your password";
		String actualMessage = lp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions is completed");
		}
	
	@Test
	public void loginTest005() {
		
		log.info("Started login test");
		test=extent.createTest("TC_LOG_005");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		lp.enterEmail("");
		lp.enterPassword("");
		lp.clickLogin();
		
		// Verifications:
		// url
		Assert.assertEquals(lp.getCurrentUrl(), lp.getPageUrl());

		
		// My Account inscription is visible
		String expectedMessage = "You must provide your username";
		String actualMessage = lp.getErrorDetailsText();
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contains expected");
		log.info("Assertions is completed");
		}

}