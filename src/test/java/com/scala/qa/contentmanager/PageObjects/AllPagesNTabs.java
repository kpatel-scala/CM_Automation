package com.scala.qa.contentmanager.PageObjects;

import com.scala.qa.contentmanager.Base.PageBase;
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
import com.scala.qa.contentmanager.PageObjects.Reporting.Reports;
import com.scala.qa.contentmanager.PageObjects.Reporting.ReportsDBConfig;
import com.scala.qa.contentmanager.PageObjects.Reporting.ReportsSettings;
import com.scala.qa.contentmanager.PageObjects.System.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 12/1/2016.
 */
public class AllPagesNTabs extends PageBase {
    private WebDriver driver;

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

    public AllPagesNTabs(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAllPagesNTabs() throws Exception {
        dashboard = new Dashboard(driver);
        media = new Media(driver);
        template = new Template(driver);
        playlist = new Playlist(driver);
        schedules = new Schedules(driver);
        channels = new Channels(driver);
        players = new Players(driver);
        playerHealth = new PlayerHealth(driver);
        maintJob = new MaintJob(driver);
        distribution = new Distribution(driver);
        reports = new Reports(driver);
        reportsSettings = new ReportsSettings(driver);
        reportsDBConfig = new ReportsDBConfig(driver);
        networkSettings = new NetworkSettings(driver);
        licenseStatus = new LicenseStatus(driver);
        dbConfig = new DBConfig(driver);
        serverSettings = new ServerSettings(driver);
        userActivity = new UserActivity(driver);
        userProfile = new UserProfile(driver);
        userRoles = new UserRoles(driver);
        workgroups = new Workgroups(driver);
        categories = new Categories(driver);
        mediaMetadata = new MediaMetadata(driver);
        playerGroups = new PlayerGroups(driver);
        playerMetadata = new PlayerMetadata(driver);
        folders = new Folders(driver);
        publishLocations = new PublishLocations(driver);
        frameSets = new FrameSets(driver);
        personalSettings = new PersonalSettings(driver);

        dashboard.click_DashboardHome();
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
        template.openTemplate("AutoTemplate.scz");
        template.clickTemplateTabs();

        playlist.clickPlaylistMenu();
        playlist.openPlaylist("AutoPlaylist");
        playlist.clickSimplePlaylistTabs();

        schedules.clickScheduleMenu();
        schedules.clickScheduleTabs();

        channels.clickChannelMenu();
        channels.openChannel("asd");
        channels.clickChannelTabs();

        players.clickPlayerMenu();
        players.openPlayer("asd");
        players.clickPlayerTabs();

        playerHealth.clickPlayerHealthMenu();
        playerHealth.openPlayerHealth();
        playerHealth.clickPlayerTabs();

        maintJob.clickMaintJobMenu();
        maintJob.openMaintJob("ad");
        maintJob.clickMaintJobTabs();

        distribution.clickDistributionMenu();
        distribution.openBroadcastServer();
        distribution.clickBroadcastServerTabs();

        distribution.clickDistributionMenu();
        distribution.openMainServer();
        distribution.clickMainServerTabs();

        reports.clickReportsMenu();

        reportsDBConfig.clickReportsDBConfigMenu();

        reportsSettings.clickReportsSettingsMenu();

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
}
