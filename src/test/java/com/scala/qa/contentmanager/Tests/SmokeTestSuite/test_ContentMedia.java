package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Content.Media;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import com.scala.qa.contentmanager.Utilities.CMReporter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * Created by kpatel on 11/29/2016.
 */
//@Listeners(value= CMReporter.class)
public class test_ContentMedia extends TestBaseSetup {
    private Media media;
    ExtentReports extent = new ExtentReports("C:\\Work\\Automation Test Results\\Result1.html", true);
    ExtentTest test = extent.startTest("test_ContentMedia", "Content testing");


    @BeforeTest
    public void testSetup() {
        test.log(LogStatus.PASS, "Browser successfully Setup");
        media = new Media(getDriver());
    }

    @AfterMethod
    public void tearitdown(ITestResult result){
        result.getStatus();

    }


    @Test(description = "Opens an Image media and its tabs")
    public void test01_OpenImage() throws Exception {
        System.out.println("Open Image test...");
        media.clickMediaMenu();
        media.openMedia("Image");
        media.clickMediaTabs();
        Assert.assertTrue(true);
        test.log(LogStatus.PASS,"Opened Media Successfully");
    }

    @Test(description = "Opens a Video media and its tabs")
    public void test02_OpenVideo() throws Exception {
        System.out.println("Open Video test...");
        media.clickMediaMenu();
        media.openMedia("Video");
        media.clickMediaTabs();
        test.log(LogStatus.PASS,"Opened Media - Video tabs Successfully");
    }

    @Test(description = "Opens a message media's and its tabs")
    public void test03_OpenMsg() throws Exception {
        System.out.println("Open Message test...");
        media.clickMediaMenu();
        media.openMedia("Message");
        media.clickMsgMediaTabs();
        test.log(LogStatus.PASS,"Opened Media - Message tabs Successfully");
        extent.endTest(test);
        extent.flush();
    }


}
