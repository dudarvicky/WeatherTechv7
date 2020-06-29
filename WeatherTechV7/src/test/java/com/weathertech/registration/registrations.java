package com.weathertech.registration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weathertech.base.BaseTest;
import com.weathertech.pages.LoginPage;
import com.weathertech.pages.MainPage;
import com.weathertech.pages.MyAccountPage;
import com.weathertech.pages.RegistrationPage;

public class registrations extends BaseTest{
	
	@Test
	public void regTest001() {
		
		log.info("Starting positive registration test");
		test=extent.createTest("TC_REG_001");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qweasdzxc");
		rp.enterFirstName("Test");
		rp.enterLastName("Test");
		rp.enterAddress1("1 Street");
		rp.enterCity("Dallas");
		rp.selectState("TX");
		rp.enterZIP("50032");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		MyAccountPage map = new MyAccountPage(driver, log);
		// Logout button is visible
		Assert.assertTrue(map.isLogOutButtonVisible(), "Logout button is not visible");

		// My Account inscription is visible
		String expectedins = "My Account";
		String actualins = map.getMyAccountInscriptionText();
		Assert.assertEquals(actualins, expectedins);
		log.info("Assertions completed");
		}
	
	@Test
	public void regTest002() {
		
		log.info("Starting incorrect confirm password registration test");
		test=extent.createTest("TC_REG_002");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qwe");
		rp.enterFirstName("Test");
		rp.enterLastName("Test");
		rp.enterAddress1("1 Street");
		rp.enterCity("Dallas");
		rp.selectState("TX");
		rp.enterZIP("50032");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		// Error message
		String expectedMessage = "The passwords you entered do not match";
		String actualMessage = rp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	
	@Test
	public void regTest003() {
		
		log.info("Starting empty lastname field registration test");
		test=extent.createTest("TC_REG_003");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qweasdzxc");
		rp.enterFirstName("Test");
		rp.enterLastName("");
		rp.enterAddress1("1 Street");
		rp.enterCity("Dallas");
		rp.selectState("TX");
		rp.enterZIP("50032");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		// Error message
		String expectedMessage = "Billing last name is required";
		String actualMessage = rp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	
	@Test
	public void regTest004() {
		
		log.info("Starting empty first name field registration test");
		test=extent.createTest("TC_REG_004");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qweasdzxc");
		rp.enterFirstName("");
		rp.enterLastName("Test");
		rp.enterAddress1("1 Street");
		rp.enterCity("Dallas");
		rp.selectState("TX");
		rp.enterZIP("50032");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		// Error message
		String expectedMessage = "Billing first name is required";
		String actualMessage = rp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	
	@Test
	public void regTest005() {
		
		log.info("Starting empty first name field registration test");
		test=extent.createTest("TC_REG_005");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qweasdzxc");
		rp.enterFirstName("");
		rp.enterLastName("Test");
		rp.enterAddress1("1 Street");
		rp.enterCity("Dallas");
		rp.selectState("TX");
		rp.enterZIP("50032");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		// Error message
		String expectedMessage = "Billing first name is required";
		String actualMessage = rp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	
	@Test
	public void regTest006() {
		
		log.info("Starting empty address1 field registration test");
		test=extent.createTest("TC_REG_006");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qweasdzxc");
		rp.enterFirstName("Test");
		rp.enterLastName("Test");
		rp.enterAddress1("");
		rp.enterCity("Dallas");
		rp.selectState("TX");
		rp.enterZIP("50032");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		// Error message
		String expectedMessage = "Billing address is required";
		String actualMessage = rp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	
	@Test
	public void regTest007() {
		
		log.info("Starting empty address1 field registration test");
		test=extent.createTest("TC_REG_007");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qweasdzxc");
		rp.enterFirstName("Test");
		rp.enterLastName("Test");
		rp.enterAddress1("1 Street");
		rp.enterCity("");
		rp.selectState("TX");
		rp.enterZIP("50032");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		// Error message
		String expectedMessage = "Billing city is required";
		String actualMessage = rp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	   
	   @Test
       public void regTest008() {
		
		log.info("Starting empty ZIP field registration test");
		test=extent.createTest("TC_REG_008");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();
		
		RegistrationPage rp = lp.clickRegisterButton();
		
		
		String randomEmail = rp.randomString()+"@abc.com";
		
		rp.enterEmail(randomEmail);
		rp.enterPassword("123qweasdzxc");
		rp.confirmPassword("123qweasdzxc");
		rp.enterFirstName("Test");
		rp.enterLastName("Test");
		rp.enterAddress1("1 Street");
		rp.enterCity("Dallas");
		rp.selectState("TX");
		rp.enterZIP("");
		rp.enterPhone("321421532513");
		rp.clickRegisterButton();
		
		
		
		// Error message
		String expectedMessage = "Billing zip is required";
		String actualMessage = rp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	   

		
	}


