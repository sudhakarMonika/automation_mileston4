package com.milestone.four.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.util.Date;

public class Screenshot {
    public static void capture() {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) DriverFactory.getDriver());
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            Date currentDate = new Date();
            String screenshotFileName = currentDate.toString().replace(":", ".");
            String userHome = System.getProperty("user.home");
            File DestFile = new File(userHome+"/Documents/Record "+ screenshotFileName + ".png");
            FileHandler.copy(SrcFile, DestFile);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
