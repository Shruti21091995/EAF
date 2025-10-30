package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.WaitUtils;

public class RegisterPage 
{
public WebDriver driver;

@FindBy(id="gender-female")
public WebElement Gender;

@FindBy(id="FirstName")
public WebElement FirstNameField;

@FindBy(id="LastName")
public WebElement LastNameField;

@FindBy(id="Email")
public WebElement EmailField;

@FindBy(id="Password")
public WebElement Password;

@FindBy(id="ConfirmPassword")
public WebElement ConfirmPasswordField;

@FindBy(id="register-button")
public WebElement RegisterButton;

@FindBy(xpath="//div[@class='result']")
public WebElement getTextMessage;

public RegisterPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public String getTextmethod()
{
	WaitUtils.ElementToBeVisible(driver, getTextMessage);
	return getTextMessage.getText();
}
public void ClickOnGender()
{
	WaitUtils.ElementToBeVisible(driver, Gender);
	Gender.click();
}


public void EnterFirstName(String name)
{
	WaitUtils.ElementToBeVisible(driver, FirstNameField);
	FirstNameField.sendKeys(name);
}

public void LastNameField(String Lastname)
{
	WaitUtils.ElementToBeVisible(driver, LastNameField);
	LastNameField.sendKeys(Lastname);
}

public void EmailMethod(String emil)
{
	WaitUtils.ElementToBeVisible(driver, EmailField);
	EmailField.sendKeys(emil);
}

public void passwordMethod(String pass)
{
	WaitUtils.ElementToBeVisible(driver, Password);
	Password.sendKeys(pass);
}

public void ConfirmPassword(String passw)
{
	WaitUtils.ElementToBeVisible(driver, ConfirmPasswordField);
	ConfirmPasswordField.sendKeys(passw);
}

public void RegisterButton()
{
	WaitUtils.ElementToBeVisible(driver, RegisterButton);
	RegisterButton.click();
}

public void RegisterMethod(String fName,String LName,String EmailName,String passwrod,String pass2)
{
	ClickOnGender();
	EnterFirstName(fName);
	LastNameField(LName);
	EmailMethod(EmailName);
	passwordMethod(passwrod);
	ConfirmPassword(pass2);
	RegisterButton();
	getTextmethod();
}














}

