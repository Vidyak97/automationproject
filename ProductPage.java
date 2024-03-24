package com.automationexcercise.pages;


import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage 
{
	WebDriver driver;
	  public ProductPage (WebDriver idriver)
	  {
		  this.driver=idriver;
		  PageFactory.initElements(driver, this);
	  }
	  
 	 //Repository 
     //Test case 8
	  
	  //4. Click on 'Products' button
	  @FindBy(xpath="//a[text()=' Products']") WebElement productButton;
	  //5. Verify user is navigated to ALL PRODUCTS page successfully
	  @FindBy(xpath="//h2[text()='All Products']") WebElement pageText;
	  //7. Click on 'View Product' of first product
	  @FindBy(xpath="(//a[text()='View Product'])[1]") WebElement viewFirstProduct;
	  //Verify that detail detail is visible: product name, category, price, availability, condition, brand
	  @FindBy(xpath="//h2[text()='Blue Top']") WebElement productName;
	  @FindBy(xpath="//div[@class='product-information']//p") List<WebElement> productDetails;
	  
	  //Test case 9
	  
	  //6. Enter product name in search input and click search button
	  @FindBy(xpath="//input[@name='search']") WebElement search;
	  @FindBy(xpath="//button[@type='button']") WebElement searchButton;
	  //7. Verify 'SEARCHED PRODUCTS' is visible
	  @FindBy(xpath="//h2[text()='Searched Products']") WebElement searchedProductText;
	  //8. Verify all the products related to search are visible
	  @FindBy(xpath="//div[contains(@class, 'productinfo')]//p") List<WebElement> items;
	  
	  //Test case12
	  @FindBy(xpath="//a[@data-product-id='1']") WebElement firstProduct;
	  @FindBy(xpath="//button[text()='Continue Shopping']") WebElement continueShopping;
	  @FindBy(xpath="(//a[@data-product-id='2']") WebElement secondProduct;
	  @FindBy(xpath="//a//u[text()='View Cart']") WebElement viewCart;
	  
	  //Test case 13
	  //6. Increase quantity to 4
	  @FindBy(xpath="//*[@id=\"quantity\"]")  WebElement txtQuantity;
	  //7. Click 'Add to cart' button
	  @FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button") WebElement buttonAddToCart;
	  //8. Click 'View Cart' button
	  @FindBy(xpath="//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u") WebElement buttonViewCart;
	  //9. Verify that product is displayed in cart page with exact quantity
	  @FindBy(xpath="//*[@id=\"product-1\"]/td[4]/button")  WebElement cartText;
	  
	  //Test case19
	  //4. Verify that Brands are visible on left side bar
	  @FindBy(xpath="//h2[text()='Brands']") WebElement displayBrandText;
	  //5. Click on any brand name
	  @FindBy(xpath="//a[text()='Polo']") WebElement brandPolo;
	  //6. Verify that user is navigated to brand page and brand products are displayed
      @FindBy(xpath="//h2[text()='Brand - Polo Products']") WebElement displayPoloProducts;
	  //7. On left side bar, click on any other brand link
	  @FindBy(xpath="//a[text()='H&M']") WebElement brandHAndM;
	  //8. Verify that user is navigated to that brand page and can see products
	  @FindBy(xpath="//h2[text()='Brand - H&M Products']") WebElement displayHandMProducts;
	  
	  //Test Case 20 
	  //4. Verify user is navigated to ALL PRODUCTS page successfully
	  
	  //Test Case 21
	  @FindBy(xpath="//a[text()='Write Your Review']") WebElement verifyReviewText;
	  @FindBy(xpath="//input[@id='name']") WebElement enterYourName;
	  @FindBy(xpath="//input[@id='email']") WebElement enterEmail;
	  @FindBy(xpath="//textarea[@id='review']") WebElement enterText;
	  @FindBy(xpath="(//button[@type='submit'])[1]") WebElement clickOnSubmitButton;
	  @FindBy(xpath="//span[text()='Thank you for your review.']") WebElement verifyMessage;
	  
	  
	  
	  public void addProductIncart()
	  {
		  
		  WebElement firstProduct = driver.findElement(By.xpath("//a[@data-product-id='1']"));
	      JavascriptExecutor js=(JavascriptExecutor) driver;
	      js.executeScript("arguments[0].scrollIntoView(true);", firstProduct); firstProduct.click();
		 
	      continueShopping.click();
	    	  
	      WebElement secondProduct = driver.findElement(By.xpath("//a[@data-product-id='2']"));
		  js.executeScript("arguments[0].scrollIntoView(true);", secondProduct); secondProduct.click();
		  
		  viewCart.click();
		  
		  List<WebElement> firstProductDetails=driver.findElements(By.id("product-1"));
		  List<WebElement> secondProductDetails=driver.findElements(By.id("product-2"));
	        HashMap<Integer, String> map= new HashMap<Integer, String>();
	        map.put(1, "Blue Top");
	        map.put(1, "Women > Tops");
	        map.put(1, "Rs. 500");
	        map.put(1, "1");
	        map.put(1, "Rs. 500");
	        map.put(2, "Men Tshirt");
	        map.put(2, "Men > Tshirts");
	        map.put(2, "Rs. 400");
	        map.put(2, "1");
	        map.put(2, "Rs. 400");
	 		for(int i=0;i<firstProductDetails.size();i++)
	 		{
	 			assertTrue(firstProductDetails.get(i).getText().contains(map.get(1)));
	 			assertTrue(secondProductDetails.get(i).getText().contains(map.get(2)));
	 			}
	  }
	  
	  
	    public void productPage() 
	  {
		  productButton.click();
		  System.out.println(pageText.getText());
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  viewFirstProduct.click();
		 // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	//WebElement viewFirstProduct=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View Product'])[1]")));
	    	//viewFirstProduct.click();
		  System.out.println(productName.getText());
		  for(int i=0; i<productDetails.size();i++)
		  {
			  System.out.println(productDetails.get(i).getText());
		  }
	  }
	  
	  public void clickOnProductButton()
	  {
		  productButton.click();
	  }
	  
	  public void verifyProductPage()
	  {
		  System.out.println(pageText.getText());
	  }
	  
	  public void searchProduct()
	  {
		  search.sendKeys("Jeans");
		  searchButton.click();
		  System.out.println(searchedProductText.getText());
		  for(int i=0; i<items.size();i++)
		  {
			  System.out.println(items.get(i).getText());
		  }
	  }
	  
	  //Test case 13
	  public void increaseTheQuantity()
	  {
	      WebElement viewFirstProduct = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
	      JavascriptExecutor js=(JavascriptExecutor) driver;
	      js.executeScript("arguments[0].scrollIntoView(true);", viewFirstProduct); viewFirstProduct.click();
		  txtQuantity.clear();
		  txtQuantity.sendKeys("4");
		  buttonAddToCart.click();
		  buttonViewCart.click();
		  System.out.println(cartText.getText());
	  }
	  
	  //Test case 14
	  
	  public void addProductToCart()
	  {
		  WebElement firstProduct = driver.findElement(By.xpath("//a[@data-product-id='1']"));
	      JavascriptExecutor js=(JavascriptExecutor) driver;
	      js.executeScript("arguments[0].scrollIntoView(true);", firstProduct); 
		  firstProduct.click();
	      
	      //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	      //WebElement firstProduct=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-product-id='1']")));
	     // firstProduct.click();
		  continueShopping.click();
	  }
	  
	  //To view first product
	  public void clickOnFirstProduct()
	  {
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	WebElement viewFirstProduct=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View Product'])[1]")));
	    	viewFirstProduct.click();
	    	continueShopping.click();
	  }
	  
	  //view cart
	  public void clickOnViewCart()
	  {
		  viewCart.click();
	  }
	  
	  //brand
	  public void brand()
	  {
		  System.out.println(displayBrandText.getText());
		  brandPolo.click();
		  System.out.println(displayPoloProducts.getText());
		  brandHAndM.click();
		  System.out.println(displayHandMProducts.getText());
	  }
	  
	  //Test case 20
	 public void searchedProduct()
	 {
		 search.sendKeys("Top");
		 searchButton.click();
		 System.out.println(searchedProductText.getText());
	 }
	  
	 //Test Case 21
	 public void viewProduct()

	 {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   WebElement viewFirstProduct=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='View Product'])[1]")));
	   viewFirstProduct.click();
	 }
	 
	 public void verifyReviewText()
	 {
		 System.out.println(verifyReviewText.getText());
		 enterYourName.sendKeys("vidya");
		 enterEmail.sendKeys("test@gmail.com");
		 enterText.sendKeys("hiii");
		 clickOnSubmitButton.click();
		 System.out.println(verifyMessage.getText());
	 }
	 
	 //Test case 8
	 //viewFirstProduct
	 public void clickOnViewFirstProduct()
	 {
		 WebElement viewFirstProduct = driver.findElement(By.xpath("(//a[text()='View Product'])[1]"));
    	 JavascriptExecutor js=(JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].scrollIntoView(true);", viewFirstProduct); viewFirstProduct.click();
		 System.out.println(productName.getText());
		 for(int i=0;i<=productDetails.size();i++)
		 {
			 System.out.println(productDetails.get(i).getText());
		 }
		 
	 }
	 
	  
}
