package com.weathertech.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MainPage extends BasePageObject{
	

	
	private String pageUrl = "https://www.weathertech.com/";
	private String pageFacebookUrl = "https://www.facebook.com/WeatherTech";
	private String pageTwitterUrl = "https://twitter.com/WeatherTech";
	private String pageYouTubeUrl = "https://www.youtube.com/weathertech";
	private String pagePinterestUrl = "https://www.pinterest.com/weathertech/";
	private String pageInstagramUrl = "https://www.instagram.com/weathertech/";
	private String pageBlogUrl = "https://www.weathertech.com/blog/";
	
	private By MyAccountIcon = By.xpath("//span[@class='icon-my_account']");
	private By ShoppingCardIcon = By.xpath("//span[@class='icon-shopping_cart']");
	private By FacebookIcon = By.xpath("//a[@class='icon-facebook']");
	private By TwitterIcon = By.xpath("//a[@class='icon-twitter']");
	private By YouTubeIcon = By.xpath("//a[@class='icon-youtube']");
	private By PinterestIcon = By.xpath("//a[@class='icon-pinterest']");
	private By InstagramIcon = By.xpath("//a[@class='icon-instagram']");
	private By BlogIcon = By.xpath("//a[@class='icon-blog']");

	public MainPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/** Open WelcomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}
	
	/** Open LoginPage by clicking of MyAccountIcon */
	public LoginPage clickMyAccountIcon() 
	{
		log.info("Clicked My Account Icon on Main Page");
		click(MyAccountIcon);
		return new LoginPage(driver, log);		
	} 
	/** Socil Media Link clicks */
	public void clickFacebook() {
		click(FacebookIcon);
	}
	public void clickTwitter() {
		click(TwitterIcon);
	}
	public void clickYouTube() {
		click(YouTubeIcon);
	}
	public void clickPinterest() {
		click(PinterestIcon);
	}
	public void clickInstagram() {
		click(InstagramIcon);
	}
	public void clickBlog() {
		click(BlogIcon);
	}
	public void switchToFacebook() {
		switchToWindowWithTitle("WeatherTech - Home | Facebook");
	}
	public void switchToTwitter() {
		switchToWindowWithTitle("WeatherTech (@WeatherTech) / Twitter");
	}
	public void switchToYouTube() {
		switchToWindowWithTitle("WeatherTech - YouTube");
	}
	public void switchToPinterest() {
		switchToWindowWithTitle("WeatherTech: Auto Products (weathertech) on Pinterest");
	}
	public void switchToInstagram() {
		switchToWindowWithTitle("WeatherTech Official (@weathertech) • Instagram photos and videos");
	}
	public String getPageFacebookUrl() {
		return pageFacebookUrl;
	}
	public String getPageTwitterUrl() {
		return pageTwitterUrl;
	}
	public String getPageYouTubeUrl() {
		return pageYouTubeUrl;
	}
	public String getPagePinterestUrl() {
		return pagePinterestUrl;
	}
	public String getPageInstagramUrl() {
		return pageInstagramUrl;
	}
	public String getPageBlogUrl() {
		return pageBlogUrl;
	}
	

}
