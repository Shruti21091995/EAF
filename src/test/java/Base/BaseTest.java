package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecommerceAutomation.demowebshop.factory.WebDriverFactory;

import Utils.PropertyUtils;

public class BaseTest
{
	public WebDriver driver;
	public PropertyUtils proper;
	
	@BeforeMethod
	public void setup()
	{
		//Initialize PropertyUtils with config file path
		proper = new PropertyUtils("src/test/resources/Config/Config.properties");
		
		//fetching the data from config.properties file
		String browser = proper.GetPropery("browser");
		String BaseUrl = proper.GetPropery("url");
		
		//now invoke the webdriver based on the browser type and call the createdriver method of class WebDriverFactory
		driver = WebDriverFactory.CraeteDriver(browser);
		driver.manage().window().maximize();
		driver.get(BaseUrl);
		
	}
	public WebDriver getDriver() {
        return driver;
    }

	@AfterMethod
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.close();
		}
	}
}