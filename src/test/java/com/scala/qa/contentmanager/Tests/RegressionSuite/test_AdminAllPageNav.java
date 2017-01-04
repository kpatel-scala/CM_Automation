package com.scala.qa.contentmanager.Tests.RegressionSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Admin.PersonalSettings;
import com.scala.qa.contentmanager.PageObjects.Content.Media;
import com.scala.qa.contentmanager.PageObjects.Content.Template;
import com.scala.qa.contentmanager.PageObjects.Dashboard;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
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

import com.scala.qa.contentmanager.Utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by kpatel on 12/5/2016.
 */
public class test_AdminAllPageNav extends TestBaseSetup{

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
    private Utilities util;

    private String userName;
    private String userPassword;
    private String imageMedia;
    private String videoMedia;
    private String templateName;
    private String msgName = "AutoMsgFromTemplate" + timeStamp;
    private String simplePlaylistName = "AutoSimplePlaylist" + timeStamp;
    private String smartPlayistName = "AutoSmartPlaylist" + timeStamp;
    private String channelName = "AutoChannel" + timeStamp;
    private String scheduleName = "AutoSchedule" + timeStamp;
    private String playerName = "AutoPlayer" + timeStamp;
    private String maintjobName = "AutoMaintJob" + timeStamp;
    private String Uname = "AutoAdminUser" + timeStamp;
    private String Upwd = "scala123";
    private String Ulastname = "Autotest" + timeStamp;
    private String Uemail = "test@scala.com";
    private String Urole = "Administrator";
    private String wgName = "AutoWG" + timeStamp;
    private String catName = "AutoCategory" + timeStamp;
    private String mmName = "AutoMediaMetadata" + timeStamp;
    private String pgName = "AutoPlayerGroup" + timeStamp;
    private String pmName = "AutoPlayerMetadata" + timeStamp;

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
        util =  new Utilities();

        imageMedia = util.getPropertyValue("ImageMedia");
        videoMedia = util.getPropertyValue("VideoMedia");
        templateName = util.getPropertyValue("TemplateMedia");
    }


    @Test(priority = 1)
    public void test_DashboardApprovals() throws Exception {
        test = extent.startTest("Dashboard Approvals");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("approvals"));
        dashboard.click_Approvals();
    }


    @Test(priority = 2)
    public void test_DashboardMedia() throws Exception {
        test = extent.startTest("Dashboard Media");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("media"));
        dashboard.click_Media();
    }


    @Test(priority = 3)
    public void test_DashboardPlaylists() throws Exception {
        test = extent.startTest("Dashboard Playlist");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("playlists"));
        dashboard.click_Playlists();
    }

    @Test(priority = 4)
    public void test_DashboardChannels() throws Exception {
        test = extent.startTest("Dashboard Channels");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("Channels"));
        dashboard.click_Channel();
    }

    @Test(priority = 5)
    public void test_DashboardPlayers() throws Exception {
        test = extent.startTest("Dashboard Players");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("Players"));
        dashboard.click_Players();
    }

    @Test(priority = 6)
    public void test_DashboardPlayerHealth() throws Exception {
        test = extent.startTest("Dashboard Player Health");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("Player Health"));
        dashboard.click_PlayerHealth();
    }

    @Test(priority = 7)
    public void test_DashboardHostedNetwork() throws Exception {
        test = extent.startTest("Dashboard Hosted Network");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("hosted Networks"));
        dashboard.click_HostedNetwork();
    }

    @Test(priority = 8)
    public void test_DashboardUsers() throws Exception {
        test = extent.startTest("Dashboard Users");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dashboard.isDisplayed("Users"));
        dashboard.click_Users();
    }


    @Test(priority = 9)
    public void test_ContentMediaViewable() throws Exception {
        test = extent.startTest("Media menu item viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(media.isDisplayed("Media"));
    }

    @Test(priority = 10)
    public void test_ContentMediaUploadable() throws Exception {
        test = extent.startTest("Media uploadable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(media.isDisplayed("MediaUpload"));
    }


    @Test(priority = 11)
    public void test_ContentMediaUploadImage() throws Exception {
        test = extent.startTest("Upload media - Image");
        dashboard.click_DashboardHome();
        Assert.assertTrue(media.uploadMedia(imageMedia, browser));
    }


    @Test(priority = 12)
    public void test_ContentMediaUploadVideo() throws Exception {
        test = extent.startTest("Upload media - Video");
        dashboard.click_DashboardHome();
        Assert.assertTrue(media.uploadMedia(videoMedia, browser));
    }


    @Test(priority = 13)
    public void test_clickContentImagePages() throws Exception {
        test = extent.startTest("Media pages - Image");
        dashboard.click_DashboardHome();
        media.openMedia("AutoImage.jpg");
        Assert.assertTrue(media.clickMediaTabs());
    }


    @Test(priority = 14)
    public void test_clickContentVideoPages() throws Exception {
        test = extent.startTest("Media pages - Video");
        dashboard.click_DashboardHome();
        media.openMedia("AutoVideo.mp4");
        Assert.assertTrue(media.clickMediaTabs());
    }

    @Test(priority = 15)
    public void test_ContentTemplatesViewable() throws Exception {
        test = extent.startTest("Template menu item viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(template.isDisplayed("Template"));
    }

    @Test(priority = 16)
    public void test_ContentTemplatesUploadable() throws Exception {
        test = extent.startTest("Template uploadable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(template.isDisplayed("TemplateUpload"));
    }

    @Test(priority = 17)
    public void test_ContentTemplateUpload() throws Exception {
        test = extent.startTest("Upload Template");
        dashboard.click_DashboardHome();
        Assert.assertTrue(template.uploadTemplate(templateName + ".scz"));
    }


    @Test(priority = 18)
    public void test_clickContentTemplatePages() throws Exception {
        test = extent.startTest("Template pages");
        dashboard.click_DashboardHome();
        template.openTemplate(templateName + ".scb");
        template.clickTemplateTabs();
    }


    @Test(priority = 19)
    public void test_createMsgFromTemplate() throws Exception {
        test = extent.startTest("Create a Message from Template Landing page");
        dashboard.click_DashboardHome();
        Assert.assertTrue(template.CreateMsgfromTemplateLanding(templateName + ".scb", msgName));
    }

    @Test(priority = 20)
    public void test_clickContentMsgPages() throws Exception {
        test = extent.startTest("Message pages");
        dashboard.click_DashboardHome();
        media.openMedia(msgName);
        Assert.assertTrue(media.clickMsgMediaTabs());
    }


    @Test(priority = 21)
    public void test_PlanningPlaylistViewable() throws Exception {
        test = extent.startTest("Playlist - menu item viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playlist.isDisplayed("playlist"));
    }


    @Test(priority = 22)
    public void test_PlanningPlaylistCreatable() throws Exception {
        test = extent.startTest("Playlist - Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playlist.isDisplayed("newsimple"));
    }

    @Test(priority = 23)
    public void test_createSimplePlaylist() throws Exception {
        test = extent.startTest("Playlist - Create Simple playlist");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playlist.createSimplePlaylist(simplePlaylistName));
    }

    @Test(priority = 24)
    public void test_addMediaSimplePlaylist() throws Exception {
        test = extent.startTest("Playlist - Add media to simple playlist");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playlist.addMediaSimplePlaylist(simplePlaylistName, imageMedia, videoMedia, msgName));
    }


    @Test(priority = 25)
    public void test_clickSimplePlaylistTabs() throws Exception {
        test = extent.startTest("Playlist - simple playlist pages");
        dashboard.click_DashboardHome();
        playlist.openPlaylist(simplePlaylistName);
        playlist.clickSimplePlaylistTabs();
    }


    @Test(priority = 26)
    public void test_PlanningSmartPlaylistCreatable() throws Exception {
        test = extent.startTest("Playlist - Smart playlist creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playlist.isDisplayed("newsmart"));
        playlist.clickPlaylistMenu();
    }

    @Test(priority = 27)
    public void test_createSmartPlaylist() throws Exception {
        test = extent.startTest("Playlist - Create Smart playlist");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playlist.createSmartPlaylist(smartPlayistName));
    }

    @Test(priority = 28)
    public void test_addMediaSmartPlaylist() throws Exception {
        test = extent.startTest("Playlist - add media to Smart playlist");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playlist.addItemSmartPlaylist(smartPlayistName, imageMedia, videoMedia, msgName));
    }

    @Test(priority = 29)
    public void test_clickSmartPlaylistTabs() throws Exception {
        test = extent.startTest("Playlist - Smart playlist tabs");
        dashboard.click_DashboardHome();
        playlist.openPlaylist(smartPlayistName);
        playlist.clickSmartPlaylistTabs();
    }


    @Test(priority = 30)
    public void test_PlanningChannelViewable() throws Exception {
        test = extent.startTest("Planning - Channel Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(channels.isDisplayed("channels"));
    }


    @Test(priority = 31)
    public void test_PlanningChannelCreatable() throws Exception {
        test = extent.startTest("Planning - Channel Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(channels.isDisplayed("new"));
    }

    @Test(priority = 32)
    public void test_CreateNewChannel() throws Exception {
        test = extent.startTest("Planning - Create Channel");
        dashboard.click_DashboardHome();
        channels.createNewChannel(channelName);
    }

    @Test(priority = 33)
    public void test_OpenChannelTabs() throws Exception {
        test = extent.startTest("Planning - Channel Viewable");
        dashboard.click_DashboardHome();
        channels.openChannel(channelName);
        channels.clickChannelTabs();
    }

    @Test(priority = 34)
    public void test_PlanningScheduleViewable() throws Exception {
        test = extent.startTest("Planning - Schedule Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(schedules.isDisplayed("Schedules"));
    }

    @Test(priority = 35)
    public void test_PlanningScheduleEditable() throws Exception {
        test = extent.startTest("Planning - Schedule Editable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(schedules.isDisplayed("new"));
    }


    @Test(priority = 36)
    public void test_CreateNewSchedule() throws Exception {
        test = extent.startTest("Planning - Create new Schedule");
        dashboard.click_DashboardHome();
        Assert.assertTrue(schedules.createNewSchedule(scheduleName, simplePlaylistName));
    }

    @Test(priority = 37)
    public void test_OpenScheduleTabs() throws Exception {
        test = extent.startTest("Planning - Open Schedule tabs");
        dashboard.click_DashboardHome();
        Assert.assertTrue(schedules.clickScheduleTabs());
    }


    @Test(priority = 38)
    public void test_NetworkPlayerViewable() throws Exception {
        test = extent.startTest("Network - Player Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(players.isDisplayed("players"));
    }

    @Test(priority = 39)
    public void test_NetworkPlayerEditable() throws Exception {
        test = extent.startTest("Network - Player Editable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(players.isDisplayed("new"));
    }


    @Test(priority = 40)
    public void test_createNetworkPlayer() throws Exception {
        test = extent.startTest("Network - Create new Player");
        dashboard.click_DashboardHome();
        Assert.assertTrue(players.createPlayer(playerName));
    }


    @Test(priority = 41)
    public void test_assignChannelToNetworkPlayer() throws Exception {
        test = extent.startTest("Network - Assign channel to player");
        dashboard.click_DashboardHome();
        Assert.assertTrue(players.assignChanneltoPlayer(playerName, channelName));
    }

    @Test(priority = 42)
    public void test_openNetworkPlayerTabs() throws Exception {
        test = extent.startTest("Network - Player tabs");
        dashboard.click_DashboardHome();
        players.openPlayer(playerName);
        Assert.assertTrue(players.clickPlayerTabs());
    }


    @Test(priority = 43)
    public void test_NetworkPlayerHealthViewable() throws Exception {
        test = extent.startTest("Network - Player Health Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerHealth.isDisplayed("player health"));
    }


    @Test(priority = 44)
    public void test_clickNetworkPlayerHealthTabs() throws Exception {
        test = extent.startTest("Network - Player Health tabs");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerHealth.clickPlayerHealthMenu());
    }


    @Test(priority = 50)
    public void test_NetworkMaintJobViewable() throws Exception {
        test = extent.startTest("Network - Maintenance job Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(maintJob.isDisplayed("maintenance job"));
    }

    @Test(priority = 51)
    public void test_NetworkMaintJobCreatable() throws Exception {
        test = extent.startTest("Network - Maintenance job creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(maintJob.isDisplayed("new"));
    }


    @Test(priority = 52)
    public void test_createNetworkMaintJob() throws Exception {
        test = extent.startTest("Network - create Maintenance job");
        dashboard.click_DashboardHome();
        Assert.assertTrue(maintJob.createMaintJob(maintjobName, playerName));
    }


    @Test(priority = 53)
    public void test_openNetworkMaintJobTabs() throws Exception {
        test = extent.startTest("Network - Maintenance job tabs");
        dashboard.click_DashboardHome();
        maintJob.openMaintJob(maintjobName);
        Assert.assertTrue(maintJob.clickMaintJobTabs());
    }


    @Test(priority = 54)
    public void test_NetworkDistributionViewable() throws Exception {
        test = extent.startTest("Network - Distribution servers Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(distribution.isDisplayed("distribution"));
    }


    @Test(priority = 55)
    public void test_NetworkDistributionCreatable() throws Exception {
        test = extent.startTest("Network - Distribution Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(distribution.isDisplayed("New Broadcast Server"));
    }


    @Test(priority = 56)
    public void test_OpenDistributionMainServerTabs() throws Exception {
        test = extent.startTest("Network - Distribution Main server tabs");
        dashboard.click_DashboardHome();
        distribution.openMainServer();
        Assert.assertTrue(distribution.clickMainServerTabs());
    }


    @Test(priority = 57)
    public void test_OpenDistributionBroadcastServer() throws Exception {
        test = extent.startTest("Network - Distribution Broadcast server");
        dashboard.click_DashboardHome();
        Assert.assertTrue(distribution.openBroadcastServer());
    }

    @Test(priority = 58)
    public void test_OpenDistributionBroadcastServerTabs() throws Exception {
        test = extent.startTest("Network - Distribution Broadcast server tabs");
        dashboard.click_DashboardHome();
        Assert.assertTrue(distribution.openBroadcastServer());
        Assert.assertTrue(distribution.clickBroadcastServerTabs());
    }


    @Test(priority = 60)
    public void test_SystemNetworkViewable() throws Exception {
        test = extent.startTest("System submenu - System Network viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(networkSettings.isDisplayed("Network Settings"));
    }


    @Test(priority = 61)
    public void test_openSystemNetworkTabs() throws Exception {
        test = extent.startTest("System submenu - System Network tabs");
        dashboard.click_DashboardHome();
        networkSettings.clickNetworkSettingsMenu();
        Assert.assertTrue(networkSettings.clickNetworkSettingsTabs());
    }


    @Test(priority = 63)
    public void test_SystemLicenseViewable() throws Exception {
        test = extent.startTest("System submenu - License viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(licenseStatus.isDisplayed("License Status"));
    }

    @Test(priority = 64)
    public void test_openSystemLicenseTabs() throws Exception {
        test = extent.startTest("System submenu - License tabs");
        dashboard.click_DashboardHome();
        Assert.assertTrue(licenseStatus.clickLicenseStatusMenu());
    }



    @Test(priority = 66)
    public void test_SystemDBConfigViewable() throws Exception {
        test = extent.startTest("System submenu - DBConfiguration viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(dbConfig.isDisplayed("Database Configuration"));
    }


    @Test(priority = 67)
    public void test_openSystemDBConfigTabs() throws Exception {
        test = extent.startTest("System submenu - DBConfiguration tabs");
        dashboard.click_DashboardHome();
        dbConfig.clickDBConfigMenu();
        Assert.assertTrue(dbConfig.clickDBConfigTabs());
    }



    @Test(priority = 68)
    public void test_SystemServerSettingsViewable() throws Exception {
        test = extent.startTest("System submenu - Server Settings viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(serverSettings.isDisplayed("Server Settings"));
    }

    @Test(priority = 69)
    public void test_openServerSettingsTabs() throws Exception {
        test = extent.startTest("System submenu - Server Settings tabs");
        dashboard.click_DashboardHome();
        serverSettings.clickServerSettingsMenu();
        Assert.assertTrue(serverSettings.clickServerSettingsTabs());
    }


    @Test(priority = 71)
    public void test_SystemUserActivityViewable() throws Exception {
        test = extent.startTest("System submenu - User activity viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(userActivity.isDisplayed("User Activity"));
    }

    @Test(priority = 72)
    public void test_openUserActivityTabs() throws Exception {
        test = extent.startTest("System submenu - User Activity tabs");
        dashboard.click_DashboardHome();
        Assert.assertTrue(userActivity.clickUserActivityMenu());
    }



    @Test(priority = 75)
    public void test_SystemUserProfileViewable() throws Exception {
        test = extent.startTest("System submenu - User Profile viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(userProfile.isDisplayed("User Profile"));
    }

    @Test(priority = 76)
    public void test_SystemUserProfileCreatable() throws Exception {
        test = extent.startTest("System submenu - User Profile creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(userProfile.isDisplayed("new"));
    }

    @Test(priority = 77)
    public void test_createUserProfile() throws Exception {
        test = extent.startTest("System submenu - create User Profile");
        dashboard.click_DashboardHome();
        Assert.assertTrue(userProfile.createNewUser(Uname, Upwd, Ulastname, Uemail, Urole));
    }

    @Test(priority = 78)
    public void test_openUserProfileTabs() throws Exception {
        test = extent.startTest("System submenu - User Profile tabs");
        dashboard.click_DashboardHome();
        userProfile.openUser(Uname);
        Assert.assertTrue(userProfile.clickUserProfileTabs());
    }


    @Test(priority = 80)
    public void test_SystemUserRoleViewable() throws Exception {
        test = extent.startTest("System submenu - User role viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(userRoles.isDisplayed("user role"));
    }


    @Test(priority = 90)
    public void test_SystemWorkGroupViewable() throws Exception {
        test = extent.startTest("System submenu - Workgroup viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(workgroups.isDisplayed("workgroups"));
    }

    @Test(priority = 91)
    public void test_SystemWorkGroupCreatable() throws Exception {
        test = extent.startTest("System submenu - Workgroup Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(workgroups.isDisplayed("new"));
    }

    @Test(priority = 92)
    public void test_createWorkGroup() throws Exception {
        test = extent.startTest("System submenu - create Workgroup");
        dashboard.click_DashboardHome();
        Assert.assertTrue(workgroups.createNewWorkgroup(wgName));
    }


    @Test(priority = 95)
    public void test_SystemCategoryViewable() throws Exception {
        test = extent.startTest("System submenu - Category Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(categories.isDisplayed("categories"));
    }

    @Test(priority = 96)
    public void test_SystemCategoryCreatable() throws Exception {
        test = extent.startTest("System submenu - Category Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(categories.isDisplayed("new"));
    }

    @Test(priority = 97)
    public void test_createCategory() throws Exception {
        test = extent.startTest("System submenu - Create new Category");
        dashboard.click_DashboardHome();
        Assert.assertTrue(categories.createNewCategory(catName));
    }


    @Test(priority = 100)
    public void test_SystemMediaMetadataViewable() throws Exception {
        test = extent.startTest("System submenu - Media Metadata Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(mediaMetadata.isDisplayed("media metadata"));
    }

    @Test(priority = 101)
    public void test_SystemMediaMetadataCreatable() throws Exception {
        test = extent.startTest("System submenu - Media Metadata Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(mediaMetadata.isDisplayed("new"));
    }

    @Test(priority = 102)
    public void test_createMediaMetadata() throws Exception {
        test = extent.startTest("System submenu - Create Media Metadata");
        dashboard.click_DashboardHome();
        Assert.assertTrue(mediaMetadata.createMediaMetadata(mmName));
    }


    @Test(priority = 110)
    public void test_SystemPlayerGroupViewable() throws Exception {
        test = extent.startTest("System submenu - Player group Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerGroups.isDisplayed("player group"));
    }

    @Test(priority = 111)
    public void test_SystemPlayerGroupCreatable() throws Exception {
        test = extent.startTest("System submenu - Player group Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerGroups.isDisplayed("new"));
    }

    @Test(priority = 112)
    public void test_createPlayerGroup() throws Exception {
        test = extent.startTest("System submenu - Create Player group");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerGroups.createPlayerGroup(pgName));
    }


    @Test(priority = 120)
    public void test_SystemPlayerMetadataViewable() throws Exception {
        test = extent.startTest("System submenu - Player metadata Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerMetadata.isDisplayed("Player metadata"));
    }

    @Test(priority = 121)
    public void test_SystemPlayerMetadataCreatable() throws Exception {
        test = extent.startTest("System submenu - Player metadata Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerMetadata.isDisplayed("new"));
    }

    @Test(priority = 122)
    public void test_createPlayerMetadata() throws Exception {
        test = extent.startTest("System submenu - Create Player metadata");
        dashboard.click_DashboardHome();
        Assert.assertTrue(playerMetadata.createPlayerMetadata(pmName));
    }


    @Test(priority = 125)
    public void test_SystemFoldersViewable() throws Exception {
        test = extent.startTest("System submenu - Folders Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(folders.isDisplayed("folders"));
    }

    @Test(priority = 126)
    public void test_SystemFoldersCreatable() throws Exception {
        test = extent.startTest("System submenu - Folders Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(folders.isDisplayed("new"));
    }

    @Test(priority = 130)
    public void test_SystemPublishLocationsViewable() throws Exception {
        test = extent.startTest("System submenu - Publish Locations Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(publishLocations.isDisplayed("publish locations"));
    }

    @Test(priority = 131)
    public void test_SystemPublishLocationsCreatable() throws Exception {
        test = extent.startTest("System submenu - Publish Locations Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(publishLocations.isDisplayed("new"));
    }
    @Test(priority = 132)
    public void test_SystemFramesetViewable() throws Exception {
        test = extent.startTest("System submenu - Framesets Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(frameSets.isDisplayed("framesets"));
    }

    @Test(priority = 133)
    public void test_SystemFramesetCreatable() throws Exception {
        test = extent.startTest("System submenu - Framesets Creatable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(frameSets.isDisplayed("new"));
    }

    @Test(priority = 140)
    public void test_AdminPersonalSettingsViewable() throws Exception {
        test = extent.startTest("System submenu - Personal Settings Viewable");
        dashboard.click_DashboardHome();
        Assert.assertTrue(personalSettings.clickPersonalSettingMenu());
    }

    @Test(priority = 141)
    public void test_AdminPersonalSettingsEditable() throws Exception {
        test = extent.startTest("System submenu - Personal Settings Editable");
        dashboard.click_DashboardHome();
        personalSettings.clickPersonalSettingMenu();
        Assert.assertTrue(personalSettings.clickPersonalSettingsTabs());
    }



}
