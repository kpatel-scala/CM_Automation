package com.scala.qa.contentmanager.PageObjects;

import com.gargoylesoftware.htmlunit.Page;
import com.scala.qa.contentmanager.Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by kpatel on 11/18/2016.
 */
public class Dashboard extends PageBase {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class=\"breadcrumbs box\"]/descendant::a[@href =\"#dashboard\"]") private WebElement eleHome;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[contains(@href,\"#media/?\")]") private WebElement eleApprovals;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[@href =\"#media\"]") private WebElement eleMedia;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[@href =\"#playlists\"]") private WebElement elePlaylists;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[@href =\"#channel\"]") private WebElement eleChannel;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[@href =\"#player\"]") private WebElement elePlayers;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[@href =\"#playerhealth\"]") private WebElement elePlayerHealth;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[@href =\"#hostedNetwork\"]") private WebElement eleHostedNetworks;
    @FindBy(xpath = "//div[@class=\"content\"]/descendant::a[@href =\"#user\"]") private WebElement eleUsers;
    @FindBy(xpath = "//div[@class=\"supports\"]/descendant::a[@href =\"http://www.scala.com/extras?product=CM&version=11&langid=en\"]") private WebElement eleExtraHomePage;
    @FindBy(xpath = "//div[@class=\"supports\"]/descendant::a[@href =\"https://docs.scala.com/display/CM1102\"]") private WebElement eleUsersGuide;
    @FindBy(xpath = "//div[@class=\"supports\"]/descendant::a[@href =\"http://www.scala.com/support?product=CM&version=11.2&langid=en\"]") private WebElement eleScalaSupport;
    @FindBy(xpath = "//div[@class=\"supports\"]/descendant::a[@href =\"https://license.scala.com/downloadcenter?sn=SSWC-NMGR-0000-0101-1149&run=true&product=CM&version=11&langid=en\"]") private WebElement eleSWUpdates;
    @FindBy(xpath = "//div[@class=\"supports\"]/descendant::a[@href =\"http://scala.com/releases/\"]") private WebElement eleUpdateBlogs;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_DashboardHome() throws  Exception{
        clickElement(eleHome, "Dashboard home link");
    }

    public void click_Approvals() throws Exception {
        clickElement(eleApprovals, "Dashboard Approvals link");
    }

    public void click_Media() throws Exception{
        clickElement(eleMedia, "Dashboard Media link");
    }

    public void click_Playlists() throws Exception{
        clickElement(elePlaylists, "Dashboard Playlists link");
    }

    public void click_Channel() throws Exception{
        clickElement(eleChannel, "Dashboard Channel link");
    }

    public void click_Players() throws Exception{
        clickElement(elePlayers, "Dashboard Players link");
    }

    public void click_PlayerHealth () throws Exception{
        clickElement(elePlayerHealth, "Dashboard PlayerHealth link");
    }

    public void click_HostedNetwork() throws Exception{
        clickElement(eleHostedNetworks, "Dashboard Hosted Network link");
    }

    public void click_Users() throws Exception{
        clickElement(eleUsers, "Dashboard Users link");
    }

    public void click_ExtrasHomePage() throws Exception{
        clickElement(eleExtraHomePage, "Dashboard Extras Home Page link");
    }

    public void click_UserGuide() throws Exception{
        clickElement(eleUsersGuide, "Dashboard User Guide link");
    }

    public void click_ScalaSupport() throws Exception{
        clickElement(eleScalaSupport, "Dashboard Scala Support link");
    }

    public void click_SWUpdate() throws Exception{
        clickElement(eleSWUpdates, "Dashboard Software Updates link");
    }

    public void click_UpdatesBlog() throws Exception{
        clickElement(eleUpdateBlogs, "Dashboard Updates Blog link");
    }

    public boolean isNotDisplayed(String name){
        switch(name.toLowerCase()){
            case "approvals":
                return isNotDisplayed(eleApprovals);
            case "media":
                return isNotDisplayed(eleMedia);
            case "playlist":
                return isNotDisplayed(elePlaylists);
            case "channel":
                return isNotDisplayed(eleChannel);
            case "players":
                return isNotDisplayed(elePlayers);
            case "player health":
                return isNotDisplayed(elePlayerHealth);
            case "hosted networks":
                return isNotDisplayed(eleHostedNetworks);
            case "users":
                return isNotDisplayed(eleUsers);
        }
        return false;
    }

    public boolean isDisplayed(String name){
        switch(name.toLowerCase()){
            case "approvals":
                return isDisplayed(eleApprovals);
            case "media":
                return isDisplayed(eleMedia);
            case "playlists":
                return isDisplayed(elePlaylists);
            case "channels":
                return isDisplayed(eleChannel);
            case "players":
                return isDisplayed(elePlayers);
            case "player health":
                return isDisplayed(elePlayerHealth);
            case "hosted networks":
                return isDisplayed(eleHostedNetworks);
            case "users":
                return isDisplayed(eleUsers);
        }
        return false;
    }
}
