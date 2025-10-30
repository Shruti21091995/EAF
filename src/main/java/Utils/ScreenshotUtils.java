package Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            // Take screenshot and store it in a temporary file
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Easy-to-understand version of file path
            //throghy this it will create screenshot file at folder location automatically and multiple times
            String path = "target/screenshots/" + name + ".png"; // where to save
            //another way in this case we are creation file manually and giving path
         //   String Filepath="/EcommerceAutomation/target/Screenshots/Screenshot.png";
            File dest = new File(path); // create file object for that path

            // Move the file to the new location
            src.renameTo(dest);

            System.out.println("Screenshot saved at: " + path);
        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
