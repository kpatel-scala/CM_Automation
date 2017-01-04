package com.scala.qa.contentmanager.PageObjects.System;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/28/2016.
 */
public class ServerSettings extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"left\"]/descendant::a[@href=\"#serversetting\"]") private WebElement eleServerSetting;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"SystemInformation\"]" ) private WebElement eleSysInfoTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"status\"]" ) private WebElement eleStatusTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"clientConnections\"]" ) private WebElement eleClientConnTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"LDAPConfig\"]" ) private WebElement eleLDAPConfigTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"serverStatistics\"]" ) private WebElement eleServerMonTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"DBPoolStats\"]" ) private WebElement eleDBPoolTab;


    public ServerSettings(WebDriver driver){
        super();
    }

    public void clickServerSettingsMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleServerSetting, "Server Setting Landing page");
    }

    public boolean clickServerSettingsTabs() throws Exception {
            try {
                clickElement(eleSysInfoTab, "DBConfig System Info tab");
                clickElement(eleStatusTab, "DBConfig Status tab");
                clickElement(eleClientConnTab, "DBConfig Client Connection tab");
                clickElement(eleLDAPConfigTab, "DBConfig LDAP config tab");
                clickElement(eleServerMonTab, "DBConfig Server Mon tab");
                //       clickElement(eleDBPoolTab,"DBConfig DB Pool tab");
                return true;
            }catch (Exception e){return false;}
    }
    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "server settings":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleServerSetting);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "server settings":
                rightNav.clickSystemMenu();
                return isDisplayed(eleServerSetting);
        }
        return false;
    }
}
