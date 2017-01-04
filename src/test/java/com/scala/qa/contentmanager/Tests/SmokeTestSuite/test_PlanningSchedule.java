package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Planning.Playlist;
import com.scala.qa.contentmanager.PageObjects.Planning.Schedules;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/29/2016.
 */
public class test_PlanningSchedule extends TestBaseSetup{
    private WebDriver driver;
    private Schedules schedules;

    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        schedules = new Schedules(getDriver());
    }

    @Test(description = "Opens a Schedule and its tabs")
    public void test01_OpenScheduleTabs() throws Exception {
        System.out.println("Open Schedule test...");
        schedules.clickScheduleMenu();
        schedules.clickScheduleTabs();
    }
}
