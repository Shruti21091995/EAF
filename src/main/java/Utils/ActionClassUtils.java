package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClassUtils 
{
	public static WebDriver driver;
	public static Actions action;
	public static void ActionClassMouseHoverMethod(WebDriver driver,WebElement element) 
	{
		action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public static void RightClickMethod(WebDriver driver,WebElement element)
	{
		action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	
	public static void DoubleClickMethod(WebDriver driver,WebElement element)
	{
		action=new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	public static void DragAndDropMethod(WebDriver driver,WebElement sourceelement,WebElement targetElement)
	{
		action=new Actions(driver);
		action.dragAndDrop(sourceelement, targetElement).build().perform();
	}
	
	
  
  
  
}
