package com.scala.qa.contentmanager.PageObjects.Planning;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by kpatel on 11/27/2016.
 */

public class Playlist extends PageBase{

    private LeftNavMenu leftNav;

    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#playlists\"]") private WebElement elePlaylistMenu;
    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#schedule\"]") private WebElement eleScheduleMenu;
    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#channel\"]") private WebElement eleChannelsMenu;

    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"column middle box\"]/descendant::button[@class=\"newItem\"]") private WebElement eleBtnNewPlaylist;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"column middle box\"]/descendant::button[@class=\"newSmartPlaylist\"]") private WebElement eleBtnNewSmartPlaylist;

    @FindBy(xpath = "//div[@class=\"formContainer\"]//li[@class=\"name\"]//input[@data-property=\"name\"]") private WebElement eleNewPlaylistName;
    @FindBy(xpath = "//div[@class=\"newItem\"]/descendant::footer/div/button[@class=\"button-primary save\"]") private WebElement eleBtnPlaylistCreate;
    @FindBy(xpath = "//div[@class=\"formContainer\"]/descendant::div[@class=\"playlist\"]/descendant::button[@class=\"newItem\"]") private WebElement eleAddMedia;
    @FindBy(xpath = "//div[@class=\"listItemSelect newPlaylistMediaItems\"]//footer/div[@class=\"actions\"]/button[@class=\"button-primary saveAndClose\"]") private WebElement eleBtnAddNClose;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actions\"]/button[@class=\"button-primary saveAndClose\"]") private WebElement eleBtnSaveNClose;
    @FindBy(xpath = "//dl[@class=\"playlistProperties\"]/descendant::dd[@class=\"itemConditions\"]/descendant::div[@class=\"playlistItemConditions\"]/descendant::button[@class=\"addMore\"]") private WebElement eleBtnAddCond;
    @FindBy(xpath = "//dl[@class=\"playlistProperties\"]/descendant::dd[@class=\"itemConditions\"]/descendant::ul[@class=\"playlistCondition\"]/descendant::input[@data-property=\"comparatorValue\"]") private WebElement eleTxtCond;
    @FindBy(id = "listConditionItems") private WebElement eleBtnShowMatchingItems;
    @FindBy(xpath = "//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnProceed;
    @FindBy(xpath = "//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnOk;

    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"ordering\"]") private WebElement eleOrderingTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"objectHistory\"]") private WebElement eleObjectHistoryTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"itemConditions\"]") private WebElement eleItemCondTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"items\"]") private WebElement eleItemsTab;


    public Playlist(WebDriver driver){
        super();
    }

    public boolean clickPlaylistMenu() throws Exception {
        try {
            leftNav = new LeftNavMenu(driver);
            leftNav.clickPlanningMenu();
            clickElement(elePlaylistMenu, "Playlist landing page");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean openPlaylist(String playlistName) throws Exception {
        try {
            clickPlaylistMenu();
            clickElement(driver.findElement(By.linkText(playlistName)), "Open a Simple Playlist");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean createSimplePlaylist(String playlistName) throws Exception {
        try {
            clickPlaylistMenu();
            clickElement(eleBtnNewPlaylist, "Create new simple Playlist");
            enterText(eleNewPlaylistName, playlistName, "Entering Simple playlist's name");
            clickElement(eleBtnPlaylistCreate, "Click Create");
            clickPlaylistMenu();
            isDisplayed(driver.findElement(By.linkText(playlistName)));
            return true;
        }catch(Exception e){
            return false;
        }
    }


    public boolean addMediaSimplePlaylist(String playlistName, String imageMedia, String videoMedia, String msgName) throws Exception {
        try {
            clickPlaylistMenu();
            openPlaylist(playlistName);
            clickElement(eleItemsTab, "Simple Playlist Items tab");
            clickElement(eleAddMedia, "Simple Playlist add Media");

            pickItem("//ul[@class=\"basic\"]/li[@mediatype=\"IMAGE\"]//div[@class=\"name column col2\"]/ul/li[1]", imageMedia);
            pickItem("//ul[@class=\"basic\"]/li[@mediatype=\"VIDEO\"]//div[@class=\"name column col2\"]/ul/li[1]", videoMedia);
            pickItem("//ul[@class=\"basic\"]/li[@mediatype=\"MESSAGE\"]//div[@class=\"name column col2\"]/ul/li[1]", msgName);

            clickElement(eleBtnAddNClose, "Add and close");
            clickElement(eleBtnSaveNClose, "Save and close");

            clickPlaylistMenu();

            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean createSmartPlaylist(String playlistName) throws Exception {
        try {
            clickPlaylistMenu();
            clickElement(eleBtnNewSmartPlaylist, "Create new smart Playlist");
            enterText(eleNewPlaylistName, playlistName, "Entering smart playlist's name");
            clickElement(eleBtnPlaylistCreate, "Click Create");
            clickPlaylistMenu();
            isDisplayed(driver.findElement(By.linkText(playlistName)));
            return true;
        }catch(Exception e){
            return false;
        }
    }


    public boolean addItemSmartPlaylist(String playlistName, String imageMedia, String videoMedia, String msgName) throws Exception {
        try {
            clickPlaylistMenu();
            openPlaylist(playlistName);
            clickElement(eleItemCondTab, "Smart Playlist Items conditions tab");
            clickElement(eleBtnAddCond, "Smart Playlist add Condition");

            enterText(eleTxtCond, "a", "Enter Smart Playlist condition");
            clickElement(eleBtnShowMatchingItems, "Show matching Items Smart Playlsit");
            clickElement(eleBtnProceed, "Click proceed");
            pickItem("//div[@class=\"listItemSelect\"]/descendant::section[@class=\"content\"]/descendant::li[@class=\"columns\"]//div[@class=\"name column col3\"]/ul/li[1]",
                    imageMedia);
            pickItem("//div[@class=\"listItemSelect\"]/descendant::section[@class=\"content\"]/descendant::li[@class=\"columns\"]//div[@class=\"name column col3\"]/ul/li[1]",
                    videoMedia);
            pickItem("//div[@class=\"listItemSelect\"]/descendant::section[@class=\"content\"]/descendant::li[@class=\"columns\"]//div[@class=\"name column col3\"]/ul/li[1]",
                    msgName);

            clickElement(eleBtnOk, "Smart matching item OK button");
            clickElement(eleBtnSaveNClose, "Save and close");

            return true;
        }catch (Exception e){
            return false;
        }
    }


    public void clickSimplePlaylistTabs() throws Exception {
        clickElement(elePropertiesTab, "Simple Playlist properties tab");
        clickElement(eleOrderingTab, "Simple Playlist Ordering tab");
        clickElement(eleObjectHistoryTab, "Simple Playlist Object History tab");
        clickElement(eleItemsTab, "Simple Playlist Items tab");
    }




    public void clickSmartPlaylistTabs() throws Exception {
        clickElement(elePropertiesTab, "Smart Playlist properties tab");
        clickElement(eleOrderingTab, "Smart Playlist Ordering tab");
        clickElement(eleObjectHistoryTab, "Smart Playlist Object History tab");
        clickElement(eleItemCondTab, "Smart Playlist Item Conditions tab");
        clickElement(eleItemsTab, "Smart Playlist Items tab");
    }


    public boolean isNotDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()) {
            case "playlist":
                leftNav.clickPlanningMenu();
                return isNotDisplayed(elePlaylistMenu);
            case "newsimple":
                clickPlaylistMenu();
                return isNotDisplayed(eleBtnNewPlaylist);
            case "newsmart":
                clickPlaylistMenu();
                return isNotDisplayed(eleBtnNewSmartPlaylist);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "playlist":
                leftNav.clickPlanningMenu();
                return isDisplayed(elePlaylistMenu);
            case "newsimple":
                clickPlaylistMenu();
                return isDisplayed(eleBtnNewPlaylist);
            case "newsmart":
                clickPlaylistMenu();
                return isDisplayed(eleBtnNewSmartPlaylist);
        }
        return false;
    }


}
