package com.automationexcercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage 
{
	WebDriver driver;
	  public CheckOutPage (WebDriver idriver)
	  {
		  this.driver=idriver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  //Test case 14
	  //Repository
	  //14. Verify Address Details and Review Your Order
	  @FindBy(xpath="//h2[text()='Address Details']") WebElement addrssDetailsText;
	  @FindBy(xpath="//h2[text()='Review Your Order']") WebElement reviewOrder;
	  //15. Enter description in comment text area and click 'Place Order'
	  @FindBy(xpath="//textarea[@name='message']") WebElement description;
	  @FindBy(xpath="//a[contains(text(),'Place Order')]") WebElement placeAnOrder;
	  
	  //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
	  @FindBy(xpath="//input[@name='name_on_card']") WebElement nameOnCard;
	  @FindBy(xpath="//input[@name='card_number']") WebElement cardNumber;
	  @FindBy(xpath="//input[@name='cvc']") WebElement cvv;
	  @FindBy(xpath="//input[@name='expiry_month']") WebElement expMonth;
	  @FindBy(xpath="//input[@name='expiry_year']") WebElement expYear;
	//  17. Click 'Pay and Confirm Order' button
	  @FindBy(xpath="//button[contains(text(),'Pay and Confirm Order')]") WebElement payAndConfirm;
	  //18. Verify success message 'Your order has been placed successfully!'
	  
	  public void EnterCheckOutDetails()
	  {
		  System.out.println(addrssDetailsText.getText());
		  System.out.println(reviewOrder.getText());
		  description.sendKeys("good quality product");
		  placeAnOrder.click();
		  nameOnCard.sendKeys("guvi");
		  cardNumber.sendKeys("123456789123456");
		  cvv.sendKeys("123");
		  expMonth.sendKeys("06");
		  expYear.sendKeys("2027");
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  WebElement payAndConfirm = driver.findElement(By.xpath("//button[contains(text(),'Pay and Confirm Order')]"));
	      js.executeScript("arguments[0].scrollIntoView(true);", payAndConfirm); 
		  payAndConfirm.click();
	  }
		  
	  
	  //Test case24
	  
	  //18. Verify success message 'Your order has been placed successfully!'
	  //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
	 @FindBy(xpath="//a[text()='Download Invoice']") WebElement downLoadInvoice;
	 //20. Click 'Continue' button
	 @FindBy(xpath="//a[text()='Continue']") WebElement clickOnContinue;
	  
		 public void verifyAddressDetailsAndReviewOrder()
		 {
			 System.out.println(addrssDetailsText.getText());
			  System.out.println(reviewOrder.getText());
		 }
		  
		 public void enterDescriptionAndPlaceOrder()
		 {
			 description.sendKeys("good quality product");
			  placeAnOrder.click();
		 }
		 
		 public void enterPaymentDetails()
		 {
			 nameOnCard.sendKeys("guvi");
			  cardNumber.sendKeys("123456789123456");
			  cvv.sendKeys("123");
			  expMonth.sendKeys("06");
			  expYear.sendKeys("2027");
		 }
		 
		 public void clickOnPayConfirm()
		 {
			 payAndConfirm.click();
		 }
		 
		 public void clickOnDownloadInvoice()
		 {
			 downLoadInvoice.click();
			 //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
		 }
		 
		 public void clickOnContinue()
		 {
			 clickOnContinue.click();
		 }
 }


