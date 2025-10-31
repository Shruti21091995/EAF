package Listner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Base.BaseTest;
import Utils.ScreenshotUtils;
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
    	//this method is used to get the current object of test class where error Occurred
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
      // 1️⃣ Save screenshot file locally (your existing logic)
        ScreenshotUtils.takeScreenshot(driver, result.getName());
      // 2️⃣ Attach screenshot to Allure Report
        saveAllureScreenshot(driver);
    }

    // 🔹 This method attaches screenshot bytes to Allure
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveAllureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    
    @Override
    public void onTestSuccess(ITestResult result) 
    {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
        System.out.println("Test Skipped: " + result.getName());
    }
}
//Allure serve==for generating report in project directory