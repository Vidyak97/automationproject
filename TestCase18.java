package com.automationexcercise.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcercise.pages.HomePage;



public class TestCase18 
{
		WebDriver driver;
		HomePage objHomePage;
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
		public void testCase18()
		{
			objHomePage= new HomePage(driver);
			objHomePage.categoryList();
		}
	}
	
	

