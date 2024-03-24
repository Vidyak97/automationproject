package com.automationexcercise.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	WebDriver driver;
	  public CartPage (WebDriver idriver)
	  {
		  this.driver=idriver;
		  PageFactory.initElements(driver, this);
	  }
	  
	//Repository
	  
	  // test case 11
	  //4. Click 'Cart' button
	  @FindBy(xpath="//a[contains(text(),' Cart')]") WebElement cartButton;
	  //6. Verify text 'SUBSCRIPTION'
	  @FindBy(xpath="//h2[text()='Subscription']") WebElement verifyCartSubscription;
	  //7. Enter email address in input and click arrow button
	  @FindBy(xpath="//input[@id='susbscribe_email']")WebElement cartSubscriptionEmail;
	  @FindBy(xpath="//button[@id='subscribe']") WebElement cartSubriptionButton;
	  //8. Verify success message 'You have been successfully subscribed!' is visible
	  @FindBy(xpath="//div[@class='alert-success alert']") WebElement cartSubscriptionVerifymessage;
	  
	  //Test case 14
	  //13. Click 'Proceed To Checkout' button
	  @FindBy(xpath="//a[text()='Proceed To Checkout']") WebElement checkOut;
	  //Verify that cart page is displayed
	  @FindBy(xpath="//li[text()='Shopping Cart']") WebElement cartPageText;
	  
	  //Test case 17
	  //7. Click 'X' button corresponding to particular product
	  @FindBy(xpath="//a[@class='cart_quantity_delete']") WebElement removeproductFromCart;
	  
	  @FindBy(xpath="//span[@id='empty_cart']//b") WebElement verifyEmptyCartPage;
	  
	  public void cartPageSubscription() 
	  {
		  cartButton.click();
		  System.out.println(verifyCartSubscription.getText());
		  cartSubscriptionEmail.sendKeys("automation@gmail.com");
		  cartSubriptionButton.click();
		  System.out.println(cartSubscriptionVerifymessage.getText());
	  }
	  
	  public void clickOnCartButton()
	  {
		  cartButton.click();
	  }
	  
	  public void verifyCartPage()
	  {
		  System.out.println(cartPageText.getText());
		//String  text=cartPageText.getText();
		//assertEquals(text,"Shopping Cart" );
	  }
	  
	  public void procedToChcekOut()
	  {
		  checkOut.click();
	  }  
	  
	  public void clickOnRemoveProduct()
	  {
		  removeproductFromCart.click();
	  }
	  
	  public void verifyEmptyCartPage()
	  {
		  System.out.println(verifyEmptyCartPage.getText());
	  }
	  
	  //Test case 24
	  @FindBy(xpath="//u[text()='Register / Login']") WebElement registerOrLogin;
	  
	  public void clickOnRegisterOrLogin()
	  {
		  registerOrLogin.click();
	  }
}
