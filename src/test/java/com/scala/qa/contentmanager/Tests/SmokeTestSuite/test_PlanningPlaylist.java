package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Content.Media;
import com.scala.qa.contentmanager.PageObjects.Planning.Playlist;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/29/2016.
 */
public class test_PlanningPlaylist extends TestBaseSetup{
    private WebDriver driver;
    private Playlist playlist;

    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        playlist = new Playlist(getDriver());
    }

    @Test(description = "Opens a Playlist and its tabs")
    public void test01_OpenPlaylistTabs() throws Exception {
        System.out.println("Open Playlist test...");
        playlist.clickPlaylistMenu();
        playlist.openPlaylist("AutoPlaylist");
        playlist.clickSimplePlaylistTabs();
    }
}
