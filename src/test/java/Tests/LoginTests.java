package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Ecommerce Application")
@Feature("Login Module")
public class LoginTests extends BaseTest
{
  @Test(priority=1)
  @Severity(SeverityLevel.CRITICAL)
  @Story("Valid Login Test")
  @Description("Test verifies that user can log in with valid credentials.")
  public void LoginWithValidUser()
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login("divyapatil@gmail.com", "Divya@123");
  }
  
  @Test(priority=2)
  @Severity(SeverityLevel.CRITICAL)
  @Story("InValid Login Test")
  @Description("Test verifies that user cannot log in with Invalid credentials.")
  public void LoginWithInavalidUser()
  {
	  LoginPage login=new LoginPage(driver);
	  login.Login("diduyapatil@gmail.com", "Divya@123");
	String error=login.ErrorMessage();
	Assert.assertTrue(error.contains("Login was unsuccessful"), "Error message not shown for invalid login.");
	  
  }
}
//divyapatil@gmail.com  Divya@123