package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.*;
import com.scala.qa.contentmanager.PageObjects.Admin.Logout;
import com.scala.qa.contentmanager.PageObjects.Admin.PersonalSettings;
import com.scala.qa.contentmanager.PageObjects.Content.Media;
import com.scala.qa.contentmanager.PageObjects.Content.Template;
import com.scala.qa.contentmanager.PageObjects.Network.Distribution;
import com.scala.qa.contentmanager.PageObjects.Network.MaintJob;
import com.scala.qa.contentmanager.PageObjects.Network.PlayerHealth;
import com.scala.qa.contentmanager.PageObjects.Network.Players;
import com.scala.qa.contentmanager.PageObjects.Planning.Channels;
import com.scala.qa.contentmanager.PageObjects.Planning.Playlist;
import com.scala.qa.contentmanager.PageObjects.Planning.Schedules;
import com.scala.qa.contentmanager.Utilities.Utilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/28/2016.
 */
public class test_SecurityAllPages extends TestBaseSetup {

    private AllPagesNTabs allPagesNTabs;
//    private Players players;

    @BeforeTest
    public void testSetup() {
//        PageBase basePage = new PageBase(getDriver());
        allPagesNTabs = new AllPagesNTabs(getDriver());
    }


    @Test(description = "Opens all links on the CM dashboard")
    public void test_AllPageNTabs() throws Exception {
        System.out.println("Click all Pages and Tabs test...");
//        PageBase basePage = new PageBase(getDriver());

        allPagesNTabs.clickAllPagesNTabs();
    }
}

