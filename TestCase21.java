package com.automationexcercise.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcercise.pages.ProductPage;

public class TestCase21 
{
	WebDriver driver;
	ProductPage objProductPage;
	@BeforeMethod
	public void LaunchBrowser() throws InterruptedException
	{
		//1. launch browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//2. navigate to URL
		driver.get("https://automationexercise.com/test_cases");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void testCase21() throws InterruptedException
	{
		objProductPage=new ProductPage(driver);
		objProductPage.clickOnProductButton();
		objProductPage.verifyProductPage();
		objProductPage.viewProduct();
		objProductPage.verifyReviewText();
	}
}























