package com.scala.qa.contentmanager.Tests;

/**
 * Created by kpatel on 11/22/2016.
 */
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.Utilities.CMReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.lift.match.ValueMatcher;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CMReporter.class)

public class Test_Chromedriver{
    @Test
    public void testRealReportOne(){
        Assert.assertTrue(true);
    }

    @Test
    public void testRealReportTwo(){
        Assert.assertTrue(false);
    }

    //Test case depends on failed testcase= testRealReportTwo
    @Test(dependsOnMethods="testRealReportTwo")
    public void testRealReportThree(){

    }
}

