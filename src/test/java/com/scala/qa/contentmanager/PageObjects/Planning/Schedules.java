package com.scala.qa.contentmanager.PageObjects.Planning;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/**
 * Created by kpatel on 11/28/2016.
 */
public class Schedules extends PageBase{

    private LeftNavMenu leftNav;

    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#schedule\"]") private WebElement eleScheduleMenu;
    @FindBy(xpath = "//div[@class=\"main\"]/descendant::div[@class=\"contents\"]/descendant::dd[@class=\"schedule\"]/descendant::button[@class=\"newTimeslotTrigger\"]") private WebElement eleBtnNewSchedule;
    @FindBy(xpath = "//div[@class=\"modal\"]/footer/div/button[@class=\"button-primary save\"]") private WebElement eleBtnSelectPlaylist;
    @FindBy(xpath = "//footer/div/button[@class=\"button-primary save\"]") private WebElement eleBtnCreateSchedule;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actions\"]/button[@class=\"button-primary saveAndClose\"]") private WebElement eleBtnSaveNClose;
    @FindBy(xpath = "//div[@class=\"main\"]/descendant::div[@class=\"contents\"]/descendant::dd[@class=\"schedule\"]/descendant::div[@class=\"timeslots\"]//h6") private WebElement eleTxtPlyname;
    @FindBy(xpath = "//div[@class=\"timeslotEditor\"]//div[@class=\"column col5 playlistItem\"]/descendant::button[@class=\"playlistSelect\"]") private WebElement eleBtnChangePlaylist;


    @FindBy(xpath = "//div[@class=\"contents\"]/dl/dt[@data-tabgroup=\"schedule\"]") private WebElement eleCalendarTab;
    @FindBy(xpath = "//div[@class=\"contents\"]/dl/dt[@data-tabgroup=\"eventTriggers\"]") private WebElement eleEventTriggersTab;
    @FindBy(xpath = "//div[@class=\"contents\"]/dl/dt[@data-tabgroup=\"timeTriggers\"]") private WebElement eleTimeTriggersTab;
    @FindBy(xpath = "//div[@class=\"contents\"]/dl/dt[@data-tabgroup=\"nonScheduledContent\"]") private WebElement eleNonScheduleTab;


    public Schedules(WebDriver driver){
        super();
    }

    public void clickScheduleMenu() throws Exception {
        leftNav = new LeftNavMenu(driver);
        leftNav.clickPlanningMenu();
        clickElement(eleScheduleMenu, "Schedule landing page");
    }

    public boolean createNewSchedule(String ScheduleName, String playlistName) throws Exception {
        try {
            clickScheduleMenu();
            clickElement(eleBtnNewSchedule, "New schedule button");
            clickElement(eleBtnChangePlaylist, "Change Playlist");
            pickItem("//section[@class=\"content\"]//div[@class=\"selector\"]//ul[@class=\"basic\"]//div[@class=\"name column col2\"]", playlistName);
            clickElement(eleBtnSelectPlaylist, "select playlist");
            clickElement(eleBtnCreateSchedule, "Create Schedule button");
            clickElement(eleBtnSaveNClose, "Schedule save and close");
            clickScheduleMenu();
            Assert.assertTrue(eleTxtPlyname.getText().contains(playlistName));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean clickScheduleTabs() throws Exception {
        try {
            clickScheduleMenu();
            clickElement(eleCalendarTab, "Schedule's Calendar Tab");
            clickElement(eleEventTriggersTab, "Schedule's Event triggers Tab");
            clickElement(eleTimeTriggersTab, "Schedule's Time triggers Tab");
            clickElement(eleNonScheduleTab, "Schedule's non-schedule Tab");
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public boolean isNotDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()) {
            case "schedules":
                leftNav.clickPlanningMenu();
                return isNotDisplayed(eleScheduleMenu);
            case "new":
                clickScheduleMenu();
                return isNotDisplayed(eleBtnNewSchedule);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "schedules":
                leftNav.clickPlanningMenu();
                return isDisplayed(eleScheduleMenu);
            case "new":
                clickScheduleMenu();
                return isDisplayed(eleBtnNewSchedule);
        }
        return false;
    }

}
