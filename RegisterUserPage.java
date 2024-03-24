package com.automationexcercise.pages;

//import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;


public class RegisterUserPage 
{
	WebDriver driver;
	  public RegisterUserPage (WebDriver idriver)
	  {
		  this.driver=idriver;
		  PageFactory.initElements(driver, this);
	  }
	  
	//Repository
	  
	  //4.  Signup / Login
     @FindBy(xpath="//a[contains(.,' Signup / Login')]")WebElement signUpOrLoginButton;
     // 5. Verify 'New User Signup!' is visible
     @FindBy(xpath="//h2[text()='New User Signup!']") WebElement newUserSignUpText;
     //6. Enter name and email address
      @FindBy(name="name") WebElement name;
	  @FindBy(xpath="//input[3][@type='email']")WebElement emailAddress;
	 // 7. Click 'Signup' button
	  @FindBy(xpath="//button[@data-qa='signup-button']")WebElement signUpButton;
	 // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
	  @FindBy(xpath="//b[text()='Enter Account Information']") WebElement accountInformationText;
	  //9. Fill details: Title, Name, Email, Password, Date of birth
	  @FindBy(id="id_gender2") WebElement title;
	  @FindBy(xpath="//input[@id='password']")WebElement password;
	  @FindBy(id="days") WebElement day;
	  @FindBy(id="months") WebElement month;
	  @FindBy(id="years") WebElement year;
	  //10. Select checkbox 'Sign up for our newsletter!'
	  @FindBy(xpath="//input[@id='newsletter']") WebElement checkBox1;
	  //11. Select checkbox 'Receive special offers from our partners!'
	  @FindBy(xpath="//input[@id='optin']") WebElement checkBox2;
	  //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
	  @FindBy(id="first_name") WebElement firstName;
	  @FindBy(id="last_name") WebElement lastName;
	  @FindBy(id="company") WebElement companyName;
	  @FindBy(id="address1") WebElement address1;
	  @FindBy(id="address2") WebElement address2;
	  @FindBy(id="country") WebElement countryName;
	  @FindBy(id="state") WebElement stateName;
	  @FindBy(id="city") WebElement cityName;
	  @FindBy(id="zipcode") WebElement zipCode;
	  @FindBy(id="mobile_number") WebElement mobileNumber;
	//13. Click 'Create Account button
	  @FindBy(xpath="//button[@type='submit']")WebElement createAccountButton;
	  //14. Verify that 'ACCOUNT CREATED!' is visible
	  @FindBy(xpath="//b[text()='Account Created!']") WebElement accountCreatedText;
	  ////b[text()='Account Created!']
	  //15. Click 'Continue' button
	  @FindBy(xpath="//a[contains(text(),'Continue')]")WebElement continueButton;
	  //16. Verify that 'Logged in as username' is visible
	  @FindBy(xpath="//a[text()=' Logged in as ']/b[text()='vidya']")WebElement accountVisibleName;
	  //17. Click 'Delete Account' button
	  @FindBy(xpath="//a[text()=' Delete Account']") WebElement deleteAccount;
	  //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
      @FindBy(xpath="//b[text()='Account Deleted!']")  WebElement deleteAccountText; 
      @FindBy(xpath="//a[text()='Continue']") WebElement contButton;
      
      //Test Case 2
      
      //5. Verify 'Login to your account' is visible
      @FindBy(xpath="//h2[contains(text(),'Login to your account')]") WebElement loginText;
      //6. Enter correct email address and password
      @FindBy(xpath="//input[@name='email'][@data-qa='login-email']") WebElement loginEmailID;
      @FindBy(xpath="//input[@name='password']") WebElement loginPassword;
      //7. Click 'login' button
      @FindBy(xpath="//button[text()='Login']") WebElement loginButton;
      
      //Test case 3
      
      //8. Verify error 'Your email or password is incorrect!' is visible
      @FindBy(xpath="//p[text()='Your email or password is incorrect!']") WebElement invalidErrorMessage;
      
      //TestCase 4
      
      //7. Click 'login' button
      @FindBy(xpath="//a[text()=' Logout']") WebElement logoutButton;
      
      // Test Case 5
      
      //8. Verify error 'Email Address already exist!' is visible
      @FindBy(xpath="//p[text()='Email Address already exist!']") WebElement accountExitMessage;
	  
  
     public void clickOnSignUpLoginButton()
     {
    	 signUpOrLoginButton.click();
     }
     
     public void signUpText()
     {
    	 System.out.println(newUserSignUpText.getText());
     }
     
     public void clickOnSignUp()
     {
    	 name.sendKeys("vidya");
    	 emailAddress.sendKeys("vidyakike92@gmail.com");
    	 signUpButton.click();
     }
     
     public void accountInformationText()
     {
    	 boolean accountInformationText1=accountInformationText.isDisplayed();
    	 if(accountInformationText1)
    	 {
    		 System.out.println("ENTER ACCOUNT INFORMATION is visible");
    	 }
    	 else
    	 {
    		 System.out.println("ENTER ACCOUNT INFORMATION is not visible");
    	 }
     }
     
     public void createAccount()
     {
    	 title.click();
    	 password.sendKeys("test@123");
    	 Select dayDropDown=new Select(day);
    	 dayDropDown.selectByVisibleText("8");
    	 Select monthDropDown=new Select(month);
    	 monthDropDown.selectByVisibleText("June");
    	 Select yearDropDown=new Select(year);
    	 yearDropDown.selectByVisibleText("2000");
    	 WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='newsletter']"));
    	 JavascriptExecutor js=(JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].scrollIntoView(true);", checkBox1); 
    	 checkBox1.click();
    	 WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='optin']"));
    	 js.executeScript("arguments[0].scrollIntoView(true);", checkBox2); 
    	 checkBox2.click();
    	 firstName.sendKeys("vidya");
    	 lastName.sendKeys("alike");
    	 companyName.sendKeys("xyz");
    	 address1.sendKeys("Bengaluru");
    	 address2.sendKeys("BTM");
    	 countryName.sendKeys("India");
    	 stateName.sendKeys("Karnataka");
    	 cityName.sendKeys("Bengaluru");
    	 zipCode.sendKeys("560100");
    	 mobileNumber.sendKeys("1234567890");
    	 WebElement createAccountButton = driver.findElement(By.xpath("//button[@type='submit']"));
         js.executeScript("arguments[0].scrollIntoView(true);", createAccountButton); 
         createAccountButton.click();
         System.out.println(accountCreatedText.getText());
     	 continueButton.click();
	}
     
     public void accountCreatedText()
     {
    	  System.out.println(accountCreatedText.getText());
     }
     
     public void clickOnDeleteAccount()
     {
    	 deleteAccount.click();
    	 System.out.println(deleteAccountText.getText());
    	 contButton.click();
     }
     
     public void deleteAccountText()
     {
    	System.out.println(deleteAccountText.getText());
     }
     
     public void clickOnContinueButton()
     {
    	 contButton.click();
     }
     
     //Test case 2
     
     public void loginText()
     {
    	 System.out.println(loginText.getText());
     }
     
     public void clickOnLoginButton()
     {
    	 loginEmailID.sendKeys("vidyak97852@gmail.com");
    	 loginPassword.sendKeys("test@123");
    	 loginButton.click();
     }
     
     public void displayNameOnAccount()
     {
    	System.out.println(accountVisibleName.getText());
     }
     
     public void loginWithIncorrectCredentials()
     {
    	 loginEmailID.sendKeys("randam123@gmail.com");
    	 loginPassword.sendKeys("abc@123");
    	 loginButton.click(); 	 
     }
     
     public void displayIncorrectMessage()
     {
    	 System.out.println(invalidErrorMessage.getText());
     }
     
     public void clickOnLogoutButton()
     {
    	 logoutButton.click();
     }
     
     public void verifyLoginPage()
     {
    	 String title = driver.getTitle();
		 System.out.println(title);
     }
     
     public void displayAccountExistMessage()
     {
    	 System.out.println(accountExitMessage.getText());
     }
     
     
}
