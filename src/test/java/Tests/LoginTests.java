package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.LoginPage;

public class LoginTests extends BaseTest
{
  @Test(priority=1)
  public void LoginWithValidUser()
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login("divyapatil@gmail.com", "Divya@123");
  }
  
  @Test(priority=2)
  public void LoginWithInavalidUser()
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login("diduyapatil@gmail.com", "Divya@123");
	String error=login.ErrorMessage();
	Assert.assertTrue(error.contains("Login was unsuccessful"), "Error message not shown for invalid login.");
	  
  }
}
//divyapatil@gmail.com  Divya@123