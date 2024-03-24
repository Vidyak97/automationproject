package com.automationexcercise.pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	  public HomePage (WebDriver idriver)
	  {
		  this.driver=idriver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  //Test case 10
	 //Repository 
	  //5. Verify text 'SUBSCRIPTION'
	  @FindBy(xpath="//h2[text()='Subscription']") WebElement subscriptionText;
	  //6. Enter email address in input and click arrow button
	  @FindBy(xpath="//input[@id='susbscribe_email']") WebElement subscriptionEmail;
	  @FindBy(xpath="//button[@id='subscribe']") WebElement subscriptionButton;
	 // 7. Verify success message 'You have been successfully subscribed!' is visible
	  @FindBy(xpath="//div[@class='alert-success alert']") WebElement verifyText;
	  
	  //Test case18
	  //Home button
	  @FindBy(xpath="//a[text()=' Home']") WebElement homeButton;
	  //3. Verify that categories are visible on left side bar
	  @FindBy(xpath="//h2[text()='Category']") WebElement verifyCategory;
	  //4. Click on 'Women' category
	  @FindBy(xpath="//a[contains(@href,'Women')]") WebElement womenCategory;
	  //5. Click on any category link under 'Women' category, for example: Dress
	  @FindBy(xpath="//a[contains(@href, '1') and text()='Dress ']") WebElement dress;
	  //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
	  @FindBy(xpath="//h2[text()='Women - Dress Products']") WebElement displaytText;
	  //7. On left side bar, click on any sub-category link of 'Men' category
	  @FindBy(xpath="//a[contains(@href,'Men')]") WebElement menCategory;
	  @FindBy(xpath="//a[contains(text(),'Jeans ')]") WebElement jeans;
	  //8. Verify that user is navigated to that category page

	  @FindBy(xpath="//h2[text()='Men - Jeans Products']") WebElement displayMenText;
	  
	  public void homePageSubscription()
	  {
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,30000)");
		  System.out.println(subscriptionText.getText());
		  subscriptionEmail.sendKeys("pno24@gmail.com");
		  subscriptionButton.click();
		  System.out.println(verifyText.getText());
	  }
	  
	  public void categoryList()
	  {
		  homeButton.click();
		  System.out.println(verifyCategory.getText());
		  //womenCategory.click();
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	      WebElement womenCategory=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'Women')]")));
	      womenCategory.click();
	      dress.click();
	      System.out.println(displaytText.getText());
	      menCategory.click();
	      jeans.click();
	      System.out.println(displayMenText.getText());
	  }
	  
	  //Test case 22
	  @FindBy(xpath="//h2[text()='recommended items']") WebElement displayRecommendedProduct;
	  @FindBy(xpath="(//a[text()='Add to cart'])[1]") WebElement addRecPrdctToCart;
	  @FindBy(xpath="//u[text()='View Cart']") WebElement viewCart;
	  @FindBy(xpath="//li[text()='Shopping Cart']") WebElement verifyCartPage;
	  
	  public void selectRecomendedProduct()
	  {
		  homeButton.click();
		  System.out.println(displayRecommendedProduct.getText());
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,30000)");
		  addRecPrdctToCart.click();
		  viewCart.click();
		  System.out.println(verifyCartPage.getText());
		  
	  }
	  
	  //TestCase 25
	//TestCase26
	  @FindBy(xpath="(//h2[text()='Full-Fledged practice website for Automation Engineers'])[2]") WebElement text;
	  
	  public void scrollUpAndScrollDown()
	  {
		  homeButton.click();
		  //4. Scroll down page to bottom
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,30000)");
		  //5. Verify 'SUBSCRIPTION' is visible
		  System.out.println(subscriptionText.getText());
		  subscriptionEmail.sendKeys("pno24@gmail.com");
		  //6. Click on arrow at bottom right side to move upward
		//  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    //  WebElement subscriptionButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='subscribe']")));
	      subscriptionButton.click();
		  //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		  js.executeScript("window.scrollTo({ behavior: \"smooth\", left: 0, top: 0 });");
		  System.out.println(text.getText());
	  }
	  
	  //TestCase26
	  
	  public void scrollUpWithoutArrow()
	  {
		  homeButton.click();
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,30000)");
		  System.out.println(subscriptionText.getText());
		//  js.executeScript("window.scrollIntoView(top))");
		  js.executeScript("window.scrollTo({ behavior: \"smooth\", left: 0, top: 0 });");
		  System.out.println(text.getText());
	  }
}
