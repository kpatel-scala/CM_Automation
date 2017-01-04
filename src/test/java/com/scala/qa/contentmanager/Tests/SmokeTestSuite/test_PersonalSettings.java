package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Admin.PersonalSettings;
import com.scala.qa.contentmanager.PageObjects.System.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/30/2016.
 */
public class test_PersonalSettings extends TestBaseSetup {
    private WebDriver driver;
    private PersonalSettings personalSettings;

    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        personalSettings = new PersonalSettings(getDriver());
    }

    @Test
    public void test01_OpenPersonalSettingsTabs() throws Exception {
        personalSettings.clickPersonalSettingMenu();
        personalSettings.clickPersonalSettingsTabs();
    }
}
