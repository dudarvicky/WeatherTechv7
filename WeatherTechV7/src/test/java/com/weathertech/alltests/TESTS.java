package com.weathertech.alltests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weathertech.base.BaseTest;
import com.weathertech.pages.LoginPage;
import com.weathertech.pages.MainPage;
import com.weathertech.pages.MyAccountPage;
import com.weathertech.pages.RegistrationPage;

public class TESTS extends BaseTest {

	

	@Test
	public void loginTest001() {
		
		
		log.info("Starting [positive] login test");
		test=extent.createTest("TC_LOG_001");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
			
		// Click on My Account
		LoginPage lp = mp.clickMyAccountIcon();

		// Execute login
//		MyAccountPage map = lp.logIn("romdudar@gmail.com", "1qazxsw2"); 
		MyAccountPage map = lp.logIn("romdudar@gmail.com", "1qazxsw22www"); 

		
		
		// Verifications:
		// New url
		Assert.assertEquals(map.getCurrentUrl(), map.getPageUrl());

		// Logout button is visible
		Assert.assertTrue(map.isLogOutButtonVisible(), "Logout button is not visible");

		// My Account inscription is visible
		String expectedins = "My Account";
		String actualins = map.getMyAccountInscriptionText();
		Assert.assertEquals(actualins, expectedins);
		log.info("Assertions completed");
		}
	
	@Test
	public void loginTest002() {
		
		log.info("Starting [invalid email] login test");
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

		
		// My Account inscription is visible
		String expectedMessage = "The password you entered does not match the one for this account. Please try again, or go to the forgot your password page to retrieve it";
		String actualMessage = lp.getErrorDetailsText();
		Assert.assertEquals(actualMessage, expectedMessage);
		log.info("Assertions completed");
		}
	
	@Test
	public void loginTest003() {
		
		log.info("Starting [invalid password] login test");
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
		log.info("Assertions completed");
		}
	
	@Test
	public void loginTest004() {
		
		log.info("Starting [emplty field password] login test");
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
		log.info("Assertions completed");
		}
	

	@Test
	public void socMedLinksTest001() {
		
		
		log.info("Starting [Facebook] Social Media Links Test");
		test=extent.createTest("TC_SML_001");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickFacebook();
		mp.switchToFacebook();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageFacebookUrl());
		log.info("Assertions completed");

 }
	
	@Test
	public void socMedLinksTest002() {
		
		
		log.info("Starting [Twitter] Social Media Links Test");
		test=extent.createTest("TC_SML_002");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickTwitter();
		mp.switchToTwitter();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageTwitterUrl());
		log.info("Assertions completed");

 }
	
	@Test
	public void socMedLinksTest003() {
		
		
		log.info("Starting [YouTube] Social Media Links Test");
		test=extent.createTest("TC_SML_003");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickYouTube();
     	mp.switchToYouTube();
	
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageYouTubeUrl());
		log.info("Assertions completed");

 }
	
	@Test
	public void socMedLinksTest004() {
		
		
		log.info("Starting [Pinterest] Social Media Links Test");
		test=extent.createTest("TC_SML_004");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickPinterest();
		mp.switchToPinterest();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPagePinterestUrl());
		log.info("Assertions completed");

 }
	


	
	@Test
	public void regTest001() {
		
		log.info("Starting [Positive] registration test");
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
		
		log.info("Starting [Incorrect confirm password] registration test");
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
		
		log.info("Starting [Empty lastname field] registration test");
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
		
//		rp.enterLastName("");
		rp.enterLastName("dasda");
		
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
	
}