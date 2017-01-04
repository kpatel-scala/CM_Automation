package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

/**
 * Created by kpatel on 11/21/2016.
 */

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.Admin.Logout;
import com.scala.qa.contentmanager.PageObjects.Dashboard;
import com.scala.qa.contentmanager.PageObjects.LoginPage;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import org.testng.annotations.*;

public class test_DashboardLinks extends TestBaseSetup {

    private Dashboard dashboard;

    @Test(description = "Opens all links on the CM dashboard")
    public void testLinks() throws Exception {
        System.out.println("Dashboard links test...");
        PageBase basePage = new PageBase(getDriver());
        dashboard = new Dashboard(getDriver());

        dashboard.click_Approvals();
        dashboard.click_DashboardHome();
        dashboard.click_Media();
        dashboard.click_DashboardHome();
        dashboard.click_Playlists();
        dashboard.click_DashboardHome();
        dashboard.click_Channel();
        dashboard.click_DashboardHome();
        dashboard.click_Players();
        dashboard.click_DashboardHome();
        dashboard.click_PlayerHealth();
        dashboard.click_DashboardHome();
        dashboard.click_HostedNetwork();
        dashboard.click_DashboardHome();
        dashboard.click_Users();
        dashboard.click_DashboardHome();
    }
}

