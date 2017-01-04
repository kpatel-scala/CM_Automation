package com.scala.qa.contentmanager.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by kpatel on 11/22/2016.
 */

public class WebDriverThread {
    private WebDriver webdriver;
    private final String operatingSystem = System.getProperty("os.name"). toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");
    public WebDriver getDriver() throws Exception {
        if (null == webdriver) {
            System.out.println(" ");
            System.out.println("Current Operating System: " + operatingSystem);
            System.out.println("Current Architecture: " + systemArchitecture);
            System.out.println("Current Browser Selection: Firefox");
            System.out.println(" ");

            webdriver = new FirefoxDriver(DesiredCapabilities.firefox());
        }
        return webdriver;
    }
    public void quitDriver() {
        if (null != webdriver) {
            webdriver.quit(); webdriver = null;
        }
    }
}

