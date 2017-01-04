package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Planning.Channels;
import com.scala.qa.contentmanager.PageObjects.Planning.Schedules;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/29/2016.
 */
public class test_PlanningChannels extends TestBaseSetup {
    private WebDriver driver;
    private Channels channels;

    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        channels= new Channels(getDriver());
    }
    @Test(description = "Opens a Channel and its tabs ")
    public void test_OpenChannelsTabs() throws Exception {
        System.out.println("Open channels test...");
        channels.clickChannelMenu();
        channels.openChannel(" asd");
        channels.clickChannelTabs();
    }

}
