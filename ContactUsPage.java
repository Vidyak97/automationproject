package com.automationexcercise.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ContactUsPage 
{
	WebDriver driver;
	  public ContactUsPage (WebDriver idriver)
	  {
		  this.driver=idriver;
		  PageFactory.initElements(driver, this);
	  }
	  
	//Repository
	  
	  //Test case 6
	  //4. Click on 'Contact Us' button
	  @FindBy(xpath="//a[text()=' Contact us']") WebElement contactUsButton;
	  // Verify 'GET IN TOUCH' is visible
	  @FindBy(xpath="//h2[text()='Get In Touch']") WebElement getInTouchText;
	  //6. Enter name, email, subject and message
	  @FindBy(xpath="//input[@name='name']") WebElement enterName;
	  @FindBy(xpath="//input[@name='email']") WebElement enterEmail;
	  @FindBy(xpath="//input[@name='subject']") WebElement enterSubject;
	  @FindBy(xpath="//textarea[@name='message']") WebElement enterMessage;
	  //7. Upload file
	  @FindBy(xpath="//input[@name='upload_file']") WebElement uploadFile;
	  //8. Click 'Submit' button
	  @FindBy(xpath="//input[@type='submit']") WebElement submitButton;
	  //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
	  @FindBy(xpath="//div[@class='contact-form']//div[contains(@class, 'alert-success')]") WebElement successMessage;
	  //11. Click 'Home' button and verify that landed to home page successfully
	  @FindBy(xpath="//span[text()=' Home']") WebElement homeButton;
	  
	  public void contactUs()
	  {
		  contactUsButton.click();
		  System.out.println(getInTouchText.getText());
		  enterName.sendKeys("vidya");
		  enterEmail.sendKeys("alike@gmail.com");
		  enterSubject.sendKeys("Selenium");
		  enterMessage.sendKeys("Demo session");
		  uploadFile.sendKeys("C:\\Users\\asus\\Downloads/testcase1.png");
		  
		  WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
	      JavascriptExecutor js=(JavascriptExecutor) driver;
	      js.executeScript("arguments[0].scrollIntoView(true);", submitButton); submitButton.click();
		//  submitButton.click();
		  //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    	//WebElement submitButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
	    	//submitButton.click();
	    	//9. Click OK button
		    driver.switchTo().alert().accept();
		  System.out.println(successMessage.getText());
		  homeButton.click();
		  String title = driver.getTitle();
		 System.out.println(title);
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
