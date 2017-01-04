package com.scala.qa.contentmanager.Base;

import com.scala.qa.contentmanager.Utilities.WebDriverThread;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by kpatel on 11/29/2016.
 */
public class DriverFactory {
  /*  private static ThreadLocal < WebDriverThread > driverThread;
    @BeforeSuite
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                return webDriverThread;
            }
        };
    }
    public static WebDriver getDriver() throws Exception {
        return driverThread.get(). getDriver();
    }
    @AfterMethod
    public static void clearCookies() throws Exception {
        getDriver(). manage(). deleteAllCookies();
    }

    @AfterSuite
    public static void closeDriverObjects() {
        for (WebDriverThread webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }
    */
}
