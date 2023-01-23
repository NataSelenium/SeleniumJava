package task70.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static task70.util.TestConfig.*;

public class ScreenShot {
    public static String fileName = SCREEN_SHORT_FILE + "HomePage.jpg";

    public static void takeHomePageScreenShot(WebDriver driver)
    {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isScreenShotFileExist()
    {
        File screenshot = new File(fileName);
        return screenshot.exists();
    }
}
