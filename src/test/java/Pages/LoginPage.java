package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class LoginPage 
{
  public WebDriver driver;
  
  @FindBy(id="Email")
  public WebElement emailFiled;
  
  @FindBy(id="Password")
  public WebElement PasswordField;
  
  @FindBy(xpath="//input[@class='button-1 login-button']")
  public WebElement LoginButton;
  
  @FindBy(xpath="//div[@class='validation-summary-errors']")
  public WebElement ErrorMessage;
  
  public LoginPage(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  
  public void enterEmail(String email)
  {
	  WaitUtils.ElementToBeVisible(driver, emailFiled);
	  emailFiled.clear();
	  emailFiled.sendKeys(email);
  }
  
  public void enterPassword(String Password)
  {
	  WaitUtils.ElementToBeVisible(driver, PasswordField);
	  PasswordField.clear();
	  PasswordField.sendKeys(Password);
  }
  
  public void LoginButton()
  {
	  WaitUtils.ElementToBeVisible(driver, LoginButton);
	  LoginButton.click();
  }
  
  public void Login(String email,String Password)
  {
	  enterEmail(email);
	  enterPassword(Password);
	  LoginButton();
	  
  }
  public String ErrorMessage()
  {
	  return ErrorMessage.getText();
  }
  
}














