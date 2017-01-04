package com.scala.qa.contentmanager.PageObjects.System;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/28/2016.
 */
public class NetworkSettings extends PageBase {

    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"left\"]/descendant::a[@href=\"#networksetting\"]") private WebElement eleNTSetting;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dl/dt[@data-tabgroup=\"approval\"]") private WebElement eleApprovalTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dl/dt[@data-tabgroup=\"miscellaneous\"]") private WebElement eleMiscTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dl/dt[@data-tabgroup=\"playerAuth\"]") private WebElement elePlayerAuthTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dl/dt[@data-tabgroup=\"mailServerSetting\"]") private WebElement eleMailServerSettingsTab;

    public NetworkSettings(WebDriver driver){
        super();
    }

    public void clickNetworkSettingsMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleNTSetting, "Network Setting Landing page");
    }

    public boolean clickNetworkSettingsTabs() throws Exception {
        try {
            clickElement(eleApprovalTab, "NT Settings Approval tab");
            clickElement(eleMiscTab, "NT Settings Miscellaneous tab");
            clickElement(elePlayerAuthTab, "NT Settings Player authentication tab");
            clickElement(eleMailServerSettingsTab, "NT Settings Mail Server settings tab");
            return true;
        }catch (Exception e){return false;}
    }


    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "network settings":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleNTSetting);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "network settings":
                rightNav.clickSystemMenu();
                return isDisplayed(eleNTSetting);
        }
        return false;
    }
}
