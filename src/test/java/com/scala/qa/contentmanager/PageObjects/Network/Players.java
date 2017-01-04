package com.scala.qa.contentmanager.PageObjects.Network;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/28/2016.
 */
public class Players extends PageBase{

    private LeftNavMenu leftNav;

    @FindBy(linkText = "AutoPlayer") private WebElement elePlayer;
    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#player\"]") private WebElement elePlayerMenu;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"column middle box\"]//button[@class=\"newItem\"]") private WebElement eleBtnNewPlayer;
    @FindBy(id = "SCALA") private WebElement elePlayerType;
    @FindBy(xpath = "//div[@class=\"modal\"]//div[@class=\"formContainer\"]//li[@class=\"distributionId\"]//div[@tabindex=\"0\"]") private WebElement eleDServerDropdown;
    @FindBy(xpath = "//ul/li[@data-id=\"1-IP_P2P\"]") private WebElement eleScalaDServer;
    @FindBy(xpath = "//div[@class=\"newItem\"]//div[@class=\"modal\"]/footer//button[@class=\"button-primary save\"]") private WebElement eleBtnNextSave;
    @FindBy(xpath = "//div[@class=\"newItem\"]//div[@class=\"modal\"]//div[@class=\"formContainer\"]//div[@class=\"inlineEdit text\"]/input[@data-property=\"name\"]") private WebElement eleTxtPlayerName;
    @FindBy(xpath = "//dd[@class=\"properties columns\"]//div[@class=\"playerDisplaySelector\"]//li[@class=\"channel1\"]//div[@id=\"s2id_comboBox\"]//b[@role=\"presentation\"]") private WebElement eleComboX;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actions\"]/button[@class=\"button-primary save\"]") private WebElement eleBtnSaveNClose;


    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"status\"]") private WebElement eleStatusTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"configuration\"]") private WebElement eleConfigurationTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"metadata\"]") private WebElement eleMetadataTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"networkBandwidthThrottlingSetting\"]") private WebElement eleNTThrottlingTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"exmodules\"]") private WebElement eleEXModulesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"logs\"]") private WebElement eleLogsTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"inventory\"]") private WebElement eleInventoryTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"health\"]") private WebElement eleHealthTab;


    public Players(WebDriver driver){
        super();
    }

    public void clickPlayerMenu() throws Exception {
        leftNav = new LeftNavMenu(driver);
        leftNav.clickNetworkMenu();
        clickElement(elePlayerMenu, "Player landing page");
    }


    public boolean createPlayer(String playerName) throws Exception {
        try {
            clickPlayerMenu();
            clickElement(eleBtnNewPlayer, "new player button");
            clickElement(elePlayerType, "select player type");
            clickElement(eleBtnNextSave, "click next");
            enterText(eleTxtPlayerName, playerName, "enter new player name");
            clickElement(eleDServerDropdown, "Click the distribution server dropdown");
            clickElement(eleScalaDServer, "Select Scala server");clickElement(eleBtnNextSave, "click Save");
            return true;
        }catch (Exception e){ return false;}
    }

    public boolean assignChanneltoPlayer(String playerName, String channelName) throws Exception {
        try {
            openPlayer(playerName);
            clickElement(elePropertiesTab, "Player Properties tab");
            clickElement(eleComboX, "Click on combo box");
            pickItem("//div[@id=\"select2-drop\"]//div[@class=\"select2-result-label\"]", channelName);
            clickElement(eleBtnSaveNClose, "Click save and close");
            Thread.sleep(2000);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void openPlayer(String playerName) throws Exception {
        clickPlayerMenu();
        clickElement(driver.findElement(By.linkText(playerName)), "Open Player");
    }

    public boolean clickPlayerTabs() throws Exception {
        try {
            clickElement(elePropertiesTab, "Player Properties tab");
            clickElement(eleStatusTab, "Player Status tab");
            clickElement(eleConfigurationTab, "Player Configuration tab");
            clickElement(eleMetadataTab, "Player Metadata tab");
            clickElement(eleNTThrottlingTab, "Player NT bandwidth throttling tab");
            clickElement(eleEXModulesTab, "Player EX Module tab");
            clickElement(eleLogsTab, "Player Logs tab");
            clickElement(eleInventoryTab, "Player Inventory tab");
            clickElement(eleHealthTab, "Player Health tab");
            return true;
        } catch (Exception e){ return false;}
    }


    public boolean isNotDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()) {
            case "player":
                leftNav.clickNetworkMenu();
                return isNotDisplayed(elePlayerMenu);
            case "new":
                clickPlayerMenu();
                return isNotDisplayed(eleBtnNewPlayer);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "player":
                leftNav.clickNetworkMenu();
                return isDisplayed(elePlayerMenu);
            case "new":
                clickPlayerMenu();
                return isDisplayed(eleBtnNewPlayer);
        }
        return false;
    }
}
