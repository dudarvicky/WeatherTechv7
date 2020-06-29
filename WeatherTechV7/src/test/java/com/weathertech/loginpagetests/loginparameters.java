package com.weathertech.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.weathertech.base.BaseTest;
import com.weathertech.pages.LoginPage;
import com.weathertech.pages.MainPage;
import com.weathertech.pages.MyAccountPage;

public class loginparameters extends BaseTest {

	
	@Parameters({ "email", "password" })
	@Test
	public void loginP(String email, String password) {
		
		test=extent.createTest("TC_LOG_PAR");
		log.info("Started login test");
		
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
			
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();

		// Execute login
		MyAccountPage map = lp.logIn(email, password);
		
		
		
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

		
	
}