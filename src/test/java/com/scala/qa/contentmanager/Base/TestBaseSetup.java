package com.scala.qa.contentmanager.Base;

/**
 * Created by kpatel on 11/22/2016.
 */
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.scala.qa.contentmanager.PageObjects.Admin.Logout;
import com.scala.qa.contentmanager.PageObjects.Dashboard;
import com.scala.qa.contentmanager.PageObjects.LoginPage;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import com.scala.qa.contentmanager.Utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBaseSetup {

    WebDriver driver;
    private LoginPage loginPage;
    private PageBase page;
    private Logout logout;
    static String driverPath = "c://chromedriver.exe";
    private Utilities util;
    protected static String URL;
    protected static String browser;
    protected static  String userName;
    protected static  String pwd;
    protected static  String reportpath;
    protected static  String filePath;
    protected static String proxy;
    protected static String timeStamp = new SimpleDateFormat("MMddYY_hhmm").format(Calendar.getInstance().getTime());

    protected ExtentReports extent;
    protected ExtentTest test;


    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        if (browserType.equals("chrome")) {
            driver = initChromeDriver(appURL);

        } else if (browserType.equals("firefox")) {
            driver = initFirefoxDriver(appURL);

        } else {
            System.out.println("browser : " + browserType
                    + " is invalid, Launching Firefox as browser of choice..");
            driver = initFirefoxDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        System.setProperty("webdriver.gecko.driver","C:\\AutomationWebDrivers\\geckodriver.exe");

        FirefoxProfile profile = new FirefoxProfile();

        if (proxy.equals("ON")) {
            profile.setPreference("network.proxy.type", 1);
            profile.setPreference("network.proxy.http", "localhost");
            profile.setPreference("network.proxy.http_port", 8090);
        }

        WebDriver driver = new FirefoxDriver(profile);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    @BeforeSuite
    public void initializeTestBaseSetup() throws Exception {
        util = new Utilities();

        browser = util.getPropertyValue("browser");
        URL = util.getPropertyValue("URL");
        reportpath = util.getPropertyValue("reportpath");
        proxy = util.getPropertyValue("proxy");

        filePath = reportpath + "Result_" + timeStamp +".html";


        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    setDriver("chrome", URL);
                    break;
                case "firefox":
                    setDriver("firefox", URL);
                    break;
            }
            extent = ExtentManager.getReporter(filePath);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @BeforeTest
    public void appLogin() throws Exception {
        page = new PageBase(driver);
        userName = util.getPropertyValue("uName");
        pwd = util.getPropertyValue("password");
        loginPage = new LoginPage(driver);
        loginPage.Login(userName, pwd);
    }

    @AfterSuite
    public void tearDown() throws Exception {
        logout = new Logout(driver);
        logout.Logout();

        extent.close();

        driver.quit();
    }

    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }

        extent.endTest(test);
        extent.flush();
    }
}
