package com.scala.qa.contentmanager.PageObjects.Planning;

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
public class Channels extends PageBase{

    private LeftNavMenu leftNav;

    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#channel\"]") private WebElement eleChannelMenu;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"column middle box\"]//button[@class=\"newItem\"]") private WebElement eleBtnNewChannel;
    @FindBy(xpath = "//div[@class=\"newChannel\"]//section[@class=\"content\"]//div[@class=\"formContainer\"]//input[@data-property=\"name\"]") private WebElement eleTxtChannelName;
    @FindBy(xpath = "//div[@class=\"newChannel\"]//section[@class=\"content\"]//div[@class=\"inlineEdit frameset\"]//button[@class=\"change\"]") private WebElement eleBtnSelectFrame;
    @FindBy(xpath = "//div[@class=\"newChannel listItemSelect\"]//div[@class=\"selector\"]//div[@class=\"column middle box\"]//li[@id=\"8\"]") private WebElement eleFrame;
    @FindBy(xpath = "//div[@class=\"newChannel listItemSelect\"]//div[@class=\"modal\"]//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnSaveFrame;
    @FindBy(xpath = "//div[@class=\"newChannel newItem\"]//div[@class=\"modal\"]//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnCreateChannel;

    @FindBy(xpath = "//div[@class=\"detail box channel\"]/div/dl/dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box channel\"]/div/dl/dt[@data-tabgroup=\"audiovisuals\"]") private WebElement eleAudioVisualTab;
    @FindBy(xpath = "//div[@class=\"detail box channel\"]/div/dl/dt[@data-tabgroup=\"playerMetaData\"]") private WebElement elePlayerMetadataTab;
    @FindBy(xpath = "//div[@class=\"detail box channel\"]/div/dl/dt[@data-tabgroup=\"variables\"]") private WebElement eleVariablesTab;

    public Channels(WebDriver driver) {
        super();
    }

    public void clickChannelMenu() throws Exception {
        leftNav = new LeftNavMenu(driver);
        leftNav.clickPlanningMenu();
        clickElement(eleChannelMenu, "Channel landing page");
    }

    public boolean createNewChannel(String channelName) throws Exception {
        try {
            clickChannelMenu();
            clickElement(eleBtnNewChannel, "Click new button Channels");
            enterText(eleTxtChannelName, channelName, "Enter channel name");
            clickElement(eleBtnSelectFrame, "select frame");;
            clickElement(eleFrame, "Pick frame");
            clickElement(eleBtnSaveFrame, "Save the selected frame");
            clickElement(eleBtnCreateChannel, "Create channel");
            clickChannelMenu();
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public boolean openChannel(String channelName) throws Exception {
        try {
            clickChannelMenu();
            clickElement(driver.findElement(By.linkText(channelName)), "Open a channel");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void clickChannelTabs() throws Exception {
        clickElement(elePropertiesTab, "Channel properties tab");
        clickElement(eleAudioVisualTab, "Channel Audio Visual tab");
        clickElement(elePlayerMetadataTab, "Channel Player Metadata tab");
        clickElement(eleVariablesTab, "Channel Variable tab");
    }


    public boolean isNotDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        leftNav.clickPlanningMenu();
        switch(name.toLowerCase()) {
            case "channels":
                return isNotDisplayed(eleChannelMenu);
            case "new":
                return isNotDisplayed(eleBtnNewChannel);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "channels":
                leftNav.clickPlanningMenu();
                return isDisplayed(eleChannelMenu);
            case "new":
                clickChannelMenu();
                return isDisplayed(eleBtnNewChannel);
        }
        return false;
    }

}
