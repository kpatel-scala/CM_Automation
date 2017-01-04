package com.scala.qa.contentmanager.PageObjects.Network;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by kpatel on 11/28/2016.
 */
public class MaintJob extends PageBase{

    private LeftNavMenu leftNavMenu;

    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#maintenanceJob\"]") private WebElement eleMaintJobMenu;
    @FindBy(xpath = "//div[@class=\"column middle box\"]/ul[@class=\"basic maintenanceJob\"]//a[@href=\"#maintenanceJob/1440\"]") private WebElement eleMaintJob;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"column middle box\"]//button[@class=\"newItem\"]") private WebElement eleBtnNewMaintJob;
    @FindBy(xpath = "//div[@class=\"modalContainer\"]//div[@class=\"formContainer\"]//ul/li[@class=\"playerTypeSelector\"]//div[2]") private WebElement eleComboX;
    @FindBy(xpath = "html/body/ul/li[2]") private WebElement eleComboxScalaPlayer;
    @FindBy(xpath = "//div[@class=\"newItem\"]//div[@class=\"modal\"]//div[@class=\"formContainer\"]//div[@class=\"inlineEdit text\"]/input[@data-property=\"name\"]") private WebElement eleTxtMaintjobName;
    @FindBy(xpath = "//div[@class=\"newItem\"]//footer//div[@class=\"actions\"]/button[@class=\"button-primary save\"]") private WebElement eleBtnSave;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dd[@class=\"tasks\"]/button[@class=\"createNewTask\"]") private WebElement eleBtnAddTask;
    @FindBy(xpath = "//div[@class=\"editTask\"]//section[@class=\"content\"]//div[@class=\"task\"]//div[@class=\"current\"]") private WebElement eleTaskTypeComboX;
    @FindBy(xpath = "html/body/ul/li[8]") private WebElement eleRetriveFiles;
    @FindBy(xpath = "//div[@class=\"editTask\"]//li[@class=\"columns maintenanceTask\"]//div[@class=\"column col3 properties_2\"]/div[@class=\"inlineEdit text\"]/input") private WebElement eleTxtTaskpath;
    @FindBy(id = "retrieve-files-in-folders") private WebElement eleChkIncludeSubfolder;
    @FindBy(xpath = "//div[@class=\"editTask\"]//div[@class=\"modal\"]/footer//button[@class=\"button-primary save\"]") private WebElement eleBtnTaskSave;
    @FindBy(xpath = "//dd[@class=\"players loadingPlayers\"]//li[@class=\"player\"]//div[@class=\"column middle box\"]//button[@class=\"newItem\"]") private WebElement eleBtnTaskAddPlayer;
    @FindBy(xpath = "//div[@class=\"listItemSelect showSelectAll\"]//div[@class=\"modal\"]/footer//button[@class=\"button-primary saveAndClose\"]") private WebElement eleBtnSaveNClose;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actions\"]/button[@class=\"button-primary saveAndClose\"]") private WebElement eleBtnSaveNCloseTask;


    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"players\"]") private WebElement elePlayersTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"tasks\"]") private WebElement eleTasksTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"schedules\"]") private WebElement eleSchedulesTab;


    public MaintJob(WebDriver driver){
        super();
    }

    public void clickMaintJobMenu() throws Exception {
        leftNavMenu = new LeftNavMenu(driver);
        leftNavMenu.clickNetworkMenu();
        clickElement(eleMaintJobMenu, "Player landing page");
    }

    public boolean createMaintJob(String maintjobName, String playerName) throws Exception {
        try {
            clickMaintJobMenu();
            clickElement(eleBtnNewMaintJob, "click New Maint job button");
            clickElement(eleComboX, "click the combo box");
            clickElement(eleComboxScalaPlayer, "Select the Scala players");
            enterText(eleTxtMaintjobName, maintjobName, "Enter the maint job name");
            clickElement(eleBtnSave, "Click save button");
            clickElement(eleTasksTab, "Click task tab");
            clickElement(eleBtnAddTask, "Click Add task button");
            clickElement(eleTaskTypeComboX, "click combo box");
            clickElement(eleRetriveFiles, "Select Retrieve files");
            enterText(eleTxtTaskpath, "Logs:\\*.*", "enter path");
            clickElement(eleChkIncludeSubfolder, "Check the Include sub folder checkbox");
            clickElement(eleBtnTaskSave, "Save task");

            clickElement(elePlayersTab, "Click on the player tab");
            clickElement(eleBtnTaskAddPlayer, "Click Add players button");
            pickItem("//li[@class=\"player\"]//div[@class=\"column middle box\"]//ul[@class=\"basic\"]//div[@class=\"name column col3\"]", playerName);
            clickElement(eleBtnSaveNClose, "Save and close add player popup");
            clickElement(eleBtnSaveNCloseTask, "Save and close task");
            return true;
        }catch (Exception e){ return false;}
    }


    public void openMaintJob(String maintjobName) throws Exception {
        clickMaintJobMenu();
        clickElement(driver.findElement(By.linkText(maintjobName)), "Open Player");
    }


    public boolean clickMaintJobTabs() throws Exception {
        try {
            clickElement(elePropertiesTab, "Maintenance Job tab");
            clickElement(elePlayersTab, "Maintenance Job Players tab");
            clickElement(eleTasksTab, "Maintenance Job Tasks tab");
            clickElement(eleSchedulesTab, "Maintenance Job Scheduling tab");
            return true;
        }catch (Exception e){return false;}
    }


    public boolean isNotDisplayed(String name) throws Exception {
        leftNavMenu = new LeftNavMenu(driver);
        switch(name.toLowerCase()) {
            case "maintenance job":
                leftNavMenu.clickNetworkMenu();
                return isNotDisplayed(eleMaintJobMenu);
            case "new":
                clickMaintJobMenu();
                return isNotDisplayed(eleBtnNewMaintJob);
        }

        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNavMenu = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "maintenance job":
                leftNavMenu.clickNetworkMenu();
                return isDisplayed(eleMaintJobMenu);
            case "new":
                clickMaintJobMenu();
                return isDisplayed(eleBtnNewMaintJob);
        }
        return false;
    }
}
