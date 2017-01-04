package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Admin.PersonalSettings;
import com.scala.qa.contentmanager.PageObjects.AllPagesNTabs;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 12/1/2016.
 */
public class test_ForeignLanguages extends TestBaseSetup{
    private WebDriver driver;
    private AllPagesNTabs allPagesNTabs;
    private PersonalSettings personalSettings;

    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        personalSettings = new PersonalSettings(getDriver());
        allPagesNTabs = new AllPagesNTabs(getDriver());
    }

    @Test
    public void test01_Dansk() throws Exception {
        personalSettings.changeDefaultLanguage("Da");
//        allPagesNTabs.clickAllPagesNTabs();
    }



}
