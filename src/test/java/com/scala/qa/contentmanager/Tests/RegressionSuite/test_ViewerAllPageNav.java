package com.scala.qa.contentmanager.Tests.RegressionSuite;

import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Admin.PersonalSettings;
import com.scala.qa.contentmanager.PageObjects.Content.Media;
import com.scala.qa.contentmanager.PageObjects.Content.Template;
import com.scala.qa.contentmanager.PageObjects.Dashboard;
import com.scala.qa.contentmanager.PageObjects.Network.Distribution;
import com.scala.qa.contentmanager.PageObjects.Network.MaintJob;
import com.scala.qa.contentmanager.PageObjects.Network.PlayerHealth;
import com.scala.qa.contentmanager.PageObjects.Network.Players;
import com.scala.qa.contentmanager.PageObjects.Planning.Channels;
import com.scala.qa.contentmanager.PageObjects.Planning.Playlist;
import com.scala.qa.contentmanager.PageObjects.Planning.Schedules;
import com.scala.qa.contentmanager.PageObjects.Reporting.Reports;
import com.scala.qa.contentmanager.PageObjects.Reporting.ReportsDBConfig;
import com.scala.qa.contentmanager.PageObjects.Reporting.ReportsSettings;
import com.scala.qa.contentmanager.PageObjects.System.*;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by kpatel on 12/5/2016.
 */
public class test_ViewerAllPageNav extends TestBaseSetup{
    private Dashboard dashboard;
    private Media media;
    private Template template;
    private Playlist playlist;
    private Schedules schedules;
    private Channels channels;
    private Players players;
    private PlayerHealth playerHealth;
    private MaintJob maintJob;
    private Distribution distribution;
    private Reports reports;
    private ReportsSettings reportsSettings;
    private ReportsDBConfig reportsDBConfig;
    private NetworkSettings networkSettings;
    private LicenseStatus licenseStatus;
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
    private PersonalSettings personalSettings;


    @BeforeTest
    public void testSetup() throws Exception {
        dashboard = new Dashboard(getDriver());
        media = new Media(getDriver());
        template = new Template(getDriver());
        playlist = new Playlist(getDriver());
        schedules = new Schedules(getDriver());
        channels = new Channels(getDriver());
        players = new Players(getDriver());
        playerHealth = new PlayerHealth(getDriver());
        maintJob = new MaintJob(getDriver());
        distribution = new Distribution(getDriver());
        reports = new Reports(getDriver());
        reportsSettings = new ReportsSettings(getDriver());
        reportsDBConfig = new ReportsDBConfig(getDriver());
        networkSettings = new NetworkSettings(getDriver());
        licenseStatus = new LicenseStatus(getDriver());
        dbConfig = new DBConfig(getDriver());
        serverSettings = new ServerSettings(getDriver());
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
        personalSettings = new PersonalSettings(getDriver());
    }


    @Test(priority = 1)
    public void test_clickDashboardLinks() throws Exception {

        dashboard.click_DashboardHome();
        try{
            assertTrue(dashboard.isNotDisplayed("approvals"));
            }catch(Exception e){
            Reporter.log("Approvals link was display to the Graphics Designer  -- FAIL", true);
        }
        dashboard.click_DashboardHome();
        try{
            assertTrue(dashboard.isNotDisplayed("media"));
        }catch(Exception e){
            Reporter.log("Media link was display to the Graphics Designer  -- FAIL", true);
        }
/*        dashboard.click_Media();
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
*/
}

/*
    @Test
    public void test_clickContentPages() throws Exception {
        media.clickMediaMenu();
        media.openMedia("Image");
        media.clickMediaTabs();

        media.clickMediaMenu();
        media.openMedia("Video");
        media.clickMediaTabs();

        media.clickMediaMenu();
        media.openMedia("Message");
        media.clickMsgMediaTabs();

        template.clickTemplateMenu();
        template.openTemplate();
        template.clickTemplateTabs();
    }


    @Test(priority = 3)
    public void test_clickPlanningPages() throws Exception {
        playlist.clickPlaylistMenu();
        playlist.openPlaylist();
        playlist.clickPlaylistTabs();

        schedules.clickScheduleMenu();
        schedules.clickScheduleTabs();

        channels.clickChannelMenu();
        channels.openChannel();
        channels.clickChannelTabs();
    }


    @Test(priority = 4)
    public void test_clickNetworkPages() throws Exception {
        players.clickPlayerMenu();
        players.openPlayer();
        players.clickPlayerTabs();

        playerHealth.clickPlayerHealthMenu();
        playerHealth.openPlayerHealth();
        playerHealth.clickPlayerTabs();

        maintJob.clickMaintJobMenu();
        maintJob.openMaintJob();
        maintJob.clickMaintJobTabs();

        distribution.clickDistributionMenu();
        distribution.openBroadcastServer();
        distribution.clickBroadcastServerTabs();

        distribution.clickDistributionMenu();
        distribution.openMainServer();
        distribution.clickMainServerTabs();
    }


    @Test(priority = 5)
    public void test_clickReportPages() throws Exception {
        reports.clickReportsMenu();

        reportsDBConfig.clickReportsDBConfigMenu();

        reportsSettings.clickReportsSettingsMenu();
    }


    @Test(priority = 6)
    public void test_clickSystemMenuItems() throws Exception {
        networkSettings.clickNetworkSettingsMenu();
        networkSettings.clickNetworkSettingsTabs();

        licenseStatus.clickLicenseStatusMenu();

        dbConfig.clickDBConfigMenu();
        dbConfig.clickDBConfigTabs();

        serverSettings.clickServerSettingsMenu();
        serverSettings.clickServerSettingsTabs();

        userActivity.clickUserActivityMenu();

        userProfile.clickUserProfileMenu();

        userRoles.clickUserRolesMenu();

        workgroups.clickWorkgroupMenu();

        categories.clickCategoriesMenu();

        mediaMetadata.clickMediaMetadataMenu();

        playerGroups.clickPlayerGroupsMenu();

        playerMetadata.clickPlayerMetadataMenu();

        folders.clickFoldersMenu();

        publishLocations.clickPublishLocationsMenu();

        frameSets.clickFrameSetsMenu();

        personalSettings.clickPersonalSettingMenu();
        personalSettings.clickPersonalSettingsTabs();
    }
*/
}

