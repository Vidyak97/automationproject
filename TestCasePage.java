package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage 
{
	WebDriver driver;
	  public TestCasePage (WebDriver idriver)
	  {
		  this.driver=idriver;
		  PageFactory.initElements(driver, this);
	  }
	  
	     //Repository
	    //Test Case 7
       //4. Click on 'Test Cases' button
	  @FindBy(xpath="//a[text()=' Test Cases']") WebElement testCaseButton;
	  
	  @FindBy(xpath="//b[text()='Test Cases']") WebElement testCasePageText;
	  
	  public void clickOnTestCaseButton()
	  {
		  testCaseButton.click();
		  System.out.println(testCasePageText.getText());
	  }
}
