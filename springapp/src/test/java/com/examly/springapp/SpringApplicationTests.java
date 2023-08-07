package com.examly.springapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.util.List;


public class FacebookSignupTest {
	
	WebDriver driver;
	
	String fbUrl = "https://www.fb.com";
	String facebookUrl = "https://www.facebook.com";
	
	@BeforeClass
	public void invokeBrowser(){

		ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://34.85.242.216:4444"), chromeOptions);
		
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		
		driver.get(fbUrl);
		
		String urlFromBrowser = driver.getCurrentUrl();
		
		Assert.assertEquals(urlFromBrowser, facebookUrl, "No redirection happened");
		
		
	}
	
	
	@Test
	public void facebookSignUp() {
		
		driver.findElement(By.name("firstname")).sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("User");
		driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("testPassword");
		
		Select selDate = new Select(driver.findElement(By.id("day")));
		Select selMonth = new Select(driver.findElement(By.id("month")));
		Select selYear = new Select(driver.findElement(By.id("year")));
		
		selDate.selectByVisibleText("21");
		selMonth.selectByVisibleText("Jun");
		selYear.selectByVisibleText("1989");
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='2']")).click();
		
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	}
	
	
	@AfterClass
	public void closeBrowser(){
		
		driver.quit();
		
	}

}