package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.FrameworkConstants;

public class WaitUtils 
{
	public static void ElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(FrameworkConstants.Explicit_Wait));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
