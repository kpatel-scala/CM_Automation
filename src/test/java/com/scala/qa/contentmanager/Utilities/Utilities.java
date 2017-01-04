package com.scala.qa.contentmanager.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by kpatel on 11/21/2016.
 */
public class Utilities {
    public static void captureScreenshot(WebDriver driver, String fileWithPath) //String screenshotName)
    {
        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
//            System.out.println("Screenshot taken - ");
            File destination = new File("C:\\Work\\Automation Test Results" +fileWithPath);
            FileUtils.copyFile(source,destination);
        }
        catch (Exception e)
        {
            System.out.println("Exception while taking screenshot "+ e.getMessage());
        }
    }

    public String getPropertyValue(String key) throws IOException {
        String value = "";
        try {
            File file = new File("system.properties");
            FileInputStream fileInput = null;
            try { fileInput = new FileInputStream(file); } catch (FileNotFoundException e) { e.printStackTrace(); }
            Properties property = new Properties();

            try { property.load(fileInput);}
            catch (IOException e) { e.printStackTrace(); }

            value = property.getProperty(key);
            fileInput.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}



