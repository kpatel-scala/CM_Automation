package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Admin.Logout;
import com.scala.qa.contentmanager.PageObjects.LoginPage;
import com.scala.qa.contentmanager.PageObjects.Reporting.Reports;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import com.scala.qa.contentmanager.PageObjects.System.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/29/2016.
 */
public class test_SystemMenu extends TestBaseSetup {
    private WebDriver driver;

    private NetworkSettings networkSettings;
    private LicenseStatus license;
    private DBConfig dbConfig;
    private ServerSettings serverSettings;
    private UserActivity userActivity;
    private UserProfile userProfile;
    private UserRoles userRoles;
    private Workgroups workgroups;
    private Categories categories;
    private MediaMetadata mediaMetadata;
    private PlayerGroups playerGroups;
    private PlayerMetadata playerMetadata;
    private Folders folders;
    private PublishLocations publishLocations;
    private FrameSets frameSets;
    private Logout logout;
    private LoginPage loginPage;


    @BeforeTest
    public void testSetup() throws Exception {
        PageBase basePage = new PageBase(getDriver());
        networkSettings = new NetworkSettings(getDriver());
        license = new LicenseStatus(getDriver());
        dbConfig = new DBConfig(getDriver());
        serverSettings =  new ServerSettings(getDriver());
        userActivity = new UserActivity(getDriver());
        userProfile = new UserProfile(getDriver());
        userRoles = new UserRoles(getDriver());
        workgroups = new Workgroups(getDriver());
        categories = new Categories(getDriver());
        mediaMetadata = new MediaMetadata(getDriver());
        playerGroups = new PlayerGroups(getDriver());
        playerMetadata = new PlayerMetadata(getDriver());
        folders = new Folders(getDriver());
        publishLocations = new PublishLocations(getDriver());
        frameSets = new FrameSets(getDriver());
        loginPage = new LoginPage(getDriver());
        logout = new Logout(getDriver());

    }
/*
    @Test
    public void test01_OpenSystemsTabs() throws Exception {
        networkSettings.clickNetworkSettingsTabs();
        license.clickLicenseStatusMenu();
        dbConfig.clickDBConfigTabs();
        serverSettings.clickServerSettingsTabs();
        userActivity.clickUserActivityMenu();
        userProfile.clickUserProfileMenu();
        workgroups.clickWorkgroupMenu();
        categories.clickCategoriesMenu();
        mediaMetadata.clickMediaMetadataMenu();
        playerGroups.clickPlayerGroupsMenu();
        playerMetadata.clickPlayerMetadataMenu();
        folders.clickFoldersMenu();
        publishLocations.clickPublishLocationsMenu();
        frameSets.clickFrameSetsMenu();
    }
*/


}
