package com.weathertech.sociallinktests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weathertech.base.BaseTest;
import com.weathertech.pages.MainPage;

public class socialmedialinks2 extends BaseTest {
	
	@Test
	public void socMedLinksTest001() {
		
		
		log.info("Started Social Media Links Test");
		test=extent.createTest("TC_SML_001");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickFacebook();
		mp.switchToFacebook();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageFacebookUrl());
		log.info("Assertions is completed");

 }
	
	@Test
	public void socMedLinksTest002() {
		
		
		log.info("Started Social Media Links Test");
		test=extent.createTest("TC_SML_002");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickTwitter();
		mp.switchToTwitter();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageTwitterUrl());
		log.info("Assertions is completed");

 }
	
	@Test
	public void socMedLinksTest003() {
		
		
		log.info("Started Social Media Links Test");
		test=extent.createTest("TC_SML_003");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickYouTube();
		mp.switchToYouTube();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageYouTubeUrl());
		log.info("Assertions is completed");

 }
	
	@Test
	public void socMedLinksTest004() {
		
		
		log.info("Started Social Media Links Test");
		test=extent.createTest("TC_SML_004");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickPinterest();
		mp.switchToPinterest();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPagePinterestUrl());
		log.info("Assertions is completed");

 }
	
	@Test
	public void socMedLinksTest005() {
		
		
		log.info("Started Social Media Links Test");
		test=extent.createTest("TC_SML_005");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickInstagram();
		mp.switchToInstagram();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageInstagramUrl());
		log.info("Assertions is completed");

 }
	
	@Test
	public void socMedLinksTest006() {
		
		
		log.info("Started Social Media Links Test");
		test=extent.createTest("TC_SML_006");
		
		// Open test page
		MainPage mp = new MainPage(driver, log);
		mp.openPage();
		
		mp.clickBlog();
		
		Assert.assertEquals(mp.getCurrentUrl(), mp.getPageBlogUrl());
		log.info("Assertions is completed");
		

	}
 }










