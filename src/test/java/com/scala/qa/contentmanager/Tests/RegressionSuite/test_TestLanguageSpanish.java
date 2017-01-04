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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 12/16/2016.
 */
public class test_TestLanguageSpanish extends TestBaseSetup {

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
    private String userName;
    private String userPassword;
    private String imageMedia = "AutoImage.jpg";
    private String videoMedia = "AutoVideo.mp4";
    private String UploadtemplateName = "AutoTemplate.scz";
    private String templateName = "AutoTemplate.scb";
    private String msgName = "AutoMsgFromTemplate";
    private String simplePlaylistName = "AutoSimplePlaylist";
    private String smartPlayistName = "AutoSmartPlaylist";
    private String channelName = "AutoChannel";
    private String scheduleName = "AutoSchedule";
    private String playerName = "AutoPlayer";
    private String maintjobName = "AutoMaintJob";


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


    /*
        @Test(priority = 1)
        public void test_DashboardApprovals() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("approvals"));
            dashboard.click_Approvals();
        }

        @Test(priority = 2)
        public void test_DashboardMedia() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("media"));
            dashboard.click_Media();
        }

        @Test(priority = 3)
        public void test_DashboardPlaylists() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("playlists"));
            dashboard.click_Playlists();
        }

        @Test(priority = 4)
        public void test_DashboardChannels() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("Channels"));
            dashboard.click_Channel();
        }

        @Test(priority = 5)
        public void test_DashboardPlayers() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("Players"));
            dashboard.click_Players();
        }

        @Test(priority = 6)
        public void test_DashboardPlayerHealth() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("Player Health"));
            dashboard.click_PlayerHealth();
        }

        @Test(priority = 7)
        public void test_DashboardHostedNetwork() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("hosted Networks"));
            dashboard.click_HostedNetwork();
        }

        @Test(priority = 8)
        public void test_DashboardUsers() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(dashboard.isDisplayed("Users"));
            dashboard.click_Users();
        }


        @Test(priority = 9)
        public void test_ContentMediaViewable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(media.isDisplayed("Media"));
        }

        @Test(priority = 10)
        public void test_ContentMediaUploadable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(media.isDisplayed("MediaUpload"));
        }


        @Test(priority = 11)
        public void test_ContentMediaUploadImage() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(media.uploadMedia("Image"));
        }


        @Test(priority = 12)
        public void test_ContentMediaUploadVideo() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(media.uploadMedia("Video"));
        }


        @Test(priority = 13)
        public void test_clickContentImagePages() throws Exception {
            dashboard.click_DashboardHome();
            media.openMedia("AutoImage.jpg");
            Assert.assertTrue(media.clickMediaTabs());
        }


        @Test(priority = 14)
        public void test_clickContentVideoPages() throws Exception {
            dashboard.click_DashboardHome();
            media.openMedia("AutoVideo.mp4");
            Assert.assertTrue(media.clickMediaTabs());
        }

        @Test(priority = 15)
        public void test_ContentTemplatesViewable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(template.isDisplayed("Template"));
        }

        @Test(priority = 16)
        public void test_ContentTemplatesUploadable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(template.isDisplayed("TemplateUpload"));
        }

        @Test(priority = 17)
        public void test_ContentTemplateUpload() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(template.uploadTemplate(UploadtemplateName));
        }


        @Test(priority = 18)
        public void test_clickContentTemplatePages() throws Exception {
            dashboard.click_DashboardHome();
            template.openTemplate(templateName);
            template.clickTemplateTabs();
        }


        @Test(priority = 19)
        public void test_createMsgFromTemplate() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(template.CreateMsgfromTemplateLanding(templateName));
        }

        @Test(priority = 20)
        public void test_clickContentMsgPages() throws Exception {
            dashboard.click_DashboardHome();
            media.openMedia(msgName);
            Assert.assertTrue(media.clickMsgMediaTabs());
        }


        @Test(priority = 21)
        public void test_PlanningPlaylistViewable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(playlist.isDisplayed("playlist"));
        }

        @Test(priority = 22)
        public void test_PlanningPlaylistCreatable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(playlist.isDisplayed("newsimple"));
        }

        @Test(priority = 23)
        public void test_createSimplePlaylist() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(playlist.createSimplePlaylist(simplePlaylistName));
        }

        @Test(priority = 24)
        public void test_addMediaSimplePlaylist() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(playlist.addMediaSimplePlaylist(simplePlaylistName, imageMedia, videoMedia, msgName));
        }


        @Test(priority = 25)
        public void test_clickSimplePlaylistTabs() throws Exception {
            dashboard.click_DashboardHome();
            playlist.openPlaylist(simplePlaylistName);
            playlist.clickSimplePlaylistTabs();
        }


        @Test(priority = 26, dependsOnMethods = "test_PlanningPlaylistViewable")
        public void test_PlanningSmartPlaylistCreatable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(playlist.isDisplayed("newsmart"));
            playlist.clickPlaylistMenu();
        }

        @Test(priority = 27)
        public void test_createSmartPlaylist() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(playlist.createSmartPlaylist(smartPlayistName));
        }

        @Test(priority = 28)
        public void test_addMediaSmartPlaylist() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(playlist.addItemSmartPlaylist(smartPlayistName, imageMedia, videoMedia, msgName));
        }

        @Test(priority = 29)
        public void test_clickSmartPlaylistTabs() throws Exception {
            dashboard.click_DashboardHome();
            playlist.openPlaylist(smartPlayistName);
            playlist.clickSmartPlaylistTabs();
        }


        @Test(priority = 30)
        public void test_PlanningChannelViewable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(channels.isDisplayed("channels"));
        }


        @Test(priority = 31)
        public void test_PlanningChannelCreatable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(channels.isDisplayed("new"));
        }

        @Test(priority = 32)
        public void test_CreateNewChannel() throws Exception {
            dashboard.click_DashboardHome();
            channels.createNewChannel(channelName);
        }

        @Test(priority = 33)
        public void test_OpenChannelTabs() throws Exception {
            dashboard.click_DashboardHome();
            channels.openChannel(channelName);
            channels.clickChannelTabs();
        }

        @Test(priority = 34)
        public void test_PlanningScheduleViewable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(schedules.isDisplayed("Schedules"));
        }

        @Test(priority = 35)
        public void test_PlanningScheduleEditable() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(schedules.isDisplayed("new"));
        }


        @Test(priority = 36)
        public void test_CreateNewSchedule() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(schedules.createNewSchedule(scheduleName, simplePlaylistName));
        }

        @Test(priority = 37)
        public void test_OpenScheduleTabs() throws Exception {
            dashboard.click_DashboardHome();
            Assert.assertTrue(schedules.clickScheduleTabs());
        }


        @Test(priority = 38)
        public void test_NetworkPlayerViewable() throws Exception {
            dashboard.click_DashboardHome();
            players.isDisplayed("players");
        }

        @Test(priority = 39)
        public void test_NetworkPlayerEditable() throws Exception {
            dashboard.click_DashboardHome();
            players.isDisplayed("new");
        }


        @Test(priority = 40)
        public void test_createNetworkPlayer() throws Exception {
            dashboard.click_DashboardHome();
            players.createPlayer(playerName);
        }


        @Test(priority = 41)
        public void test_assignChannelToNetworkPlayer() throws Exception {
            dashboard.click_DashboardHome();
            players.assignChanneltoPlayer(playerName, channelName);
        }

        @Test(priority = 42)
        public void test_openNetworkPlayerTabs() throws Exception {
            dashboard.click_DashboardHome();
            players.openPlayer(playerName);
            players.clickPlayerTabs();
        }


        @Test(priority = 43)
        public void test_NetworkPlayerHealthViewable() throws Exception {
            dashboard.click_DashboardHome();
            playerHealth.isDisplayed("player health");
        }


        @Test(priority = 44)
        public void test_clickNetworkPlayerHealthTabs() throws Exception {
            dashboard.click_DashboardHome();
            playerHealth.clickPlayerHealthMenu();
        }

    */

    @Test(priority = 1)
    public void test_ChangeLanguage() throws Exception {
        personalSettings.clickPersonalSettingMenu();
        personalSettings.changeDefaultLanguage("Español");
    }


    @Test(priority = 44)
    public void test_NetworkMaintJobViewable() throws Exception {
        dashboard.click_DashboardHome();
        maintJob.isDisplayed("maintenance job");
    }

    @Test(priority = 44)
    public void test_NetworkMaintJobCreatable() throws Exception {
        dashboard.click_DashboardHome();
        maintJob.isDisplayed("new");
    }


    @Test(priority = 44)
    public void test_createNetworkMaintJob() throws Exception {
        dashboard.click_DashboardHome();
        maintJob.createMaintJob(maintjobName, playerName);
    }


    @Test(priority = 45)
    public void test_openNetworkMaintJobTabs() throws Exception {
        dashboard.click_DashboardHome();
        maintJob.openMaintJob(maintjobName);
        maintJob.clickMaintJobTabs();
    }


    @Test(priority = 46)
    public void test_NetworkDistributionViewable() throws Exception {
        dashboard.click_DashboardHome();
        distribution.isDisplayed("distribution");
    }


    @Test(priority = 47)
    public void test_NetworkDistributionCreatable() throws Exception {
        dashboard.click_DashboardHome();
        distribution.isDisplayed("New Broadcast Server");
    }


    @Test(priority = 48)
    public void test_OpenDistributionMainServerTabs() throws Exception {
        dashboard.click_DashboardHome();
        distribution.openMainServer();
        distribution.clickMainServerTabs();
    }


    @Test(priority = 49)
    public void test_OpenDistributionBroadcastServerTabs() throws Exception {
        dashboard.click_DashboardHome();
        distribution.openBroadcastServer();
        distribution.clickBroadcastServerTabs();
    }







    /*




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


    @Test
    public void test_uploadMediaImage() throws Exception {
        media.clickMediaMenu();
        Assert.assertTrue(media.uploadMedia("Image"));
    }

    @Test
    public void test_uploadMediaVideo() throws Exception {
        media.clickMediaMenu();
        Assert.assertTrue(media.uploadMedia("Video"));
    }
*/


}

