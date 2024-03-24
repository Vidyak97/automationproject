package com.automationexcercise.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcercise.pages.CartPage;
import com.automationexcercise.pages.ProductPage;
import com.automationexcercise.pages.RegisterUserPage;

public class Testcase23 
{
	WebDriver driver;
	RegisterUserPage objRegisterUserPage;
	ProductPage objProductPage;
	CartPage objCartPage;
	@BeforeMethod
	public void LaunchBrowser() throws InterruptedException
	{
		//1. launch browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//2. navigate to URL
		driver.get("https://automationexercise.com/test_cases");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   //3.verify home page
	    String title = driver.getTitle();
		 System.out.println(title);
		 if(title.equalsIgnoreCase("Automation Practice Website for UI Testing - Test Cases"))
		 {
				System.out.println("Title Matched");
		 }
			else
				System.out.println("Title not match");
	}
	
	@Test
	public void testCase23()
	{
		objRegisterUserPage= new RegisterUserPage(driver);
		objRegisterUserPage.clickOnSignUpLoginButton();
		objRegisterUserPage.clickOnSignUp();
		objRegisterUserPage.createAccount();
		objRegisterUserPage.displayNameOnAccount();
		objProductPage=new ProductPage(driver);
		objProductPage.clickOnProductButton();
		objProductPage.addProductToCart();
		objCartPage=new CartPage(driver);
		objCartPage.clickOnCartButton();
		objCartPage.verifyCartPage();
		objCartPage.procedToChcekOut();
		//12. Verify that the delivery address is same address filled at the time registration of account
		//13. Verify that the billing address is same address filled at the time registration of account
		objRegisterUserPage.clickOnDeleteAccount();
		//objRegisterUserPage.deleteAccountText();
	}
}
