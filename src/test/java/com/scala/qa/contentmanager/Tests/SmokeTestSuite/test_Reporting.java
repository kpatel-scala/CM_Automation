package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Network.Distribution;
import com.scala.qa.contentmanager.PageObjects.Network.MaintJob;
import com.scala.qa.contentmanager.PageObjects.Network.PlayerHealth;
import com.scala.qa.contentmanager.PageObjects.Network.Players;
import com.scala.qa.contentmanager.PageObjects.Reporting.Reports;
import com.scala.qa.contentmanager.PageObjects.Reporting.ReportsDBConfig;
import com.scala.qa.contentmanager.PageObjects.Reporting.ReportsSettings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/29/2016.
 */
public class test_Reporting extends TestBaseSetup {
    private WebDriver driver;
    private Reports reports;
    private ReportsSettings reportsSettings;
    private ReportsDBConfig reportDBConfig;


    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        reports = new Reports(getDriver());
    }
}
