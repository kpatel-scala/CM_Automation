package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Network.Distribution;
import com.scala.qa.contentmanager.PageObjects.Network.MaintJob;
import com.scala.qa.contentmanager.PageObjects.Network.PlayerHealth;
import com.scala.qa.contentmanager.PageObjects.Network.Players;
import com.scala.qa.contentmanager.PageObjects.Planning.Schedules;
import jdk.nashorn.internal.runtime.ECMAException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/29/2016.
 */
public class test_Network extends TestBaseSetup{
    private WebDriver driver;
    private Players players;
    private MaintJob maintJob;
    private PlayerHealth playerHealth;
    private Distribution distribution;


    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        players = new Players(getDriver());
        maintJob = new MaintJob(getDriver());
        playerHealth = new PlayerHealth(getDriver());
        distribution = new Distribution(getDriver());
    }

    @Test
    public void test01_OpenPlayersTabs() throws Exception {
        players.clickPlayerMenu();
        players.openPlayer("sdf");
        players.clickPlayerTabs();
    }

    @Test
    public void test02_OpenPlayerHealthTabs() throws Exception{
        playerHealth.clickPlayerHealthMenu();
        playerHealth.openPlayerHealth();
    }

    @Test
    public void test03_OpenMaintJobTabs() throws Exception {
        maintJob.clickMaintJobMenu();
        maintJob.openMaintJob("asd");
        maintJob.clickMaintJobTabs();
    }

    @Test
    public void test04_OpenDistributionTabs() throws Exception {
        distribution.clickDistributionMenu();
        distribution.openBroadcastServer();
        distribution.clickBroadcastServerTabs();
        distribution.openMainServer();
        distribution.clickMainServerTabs();
    }
}
