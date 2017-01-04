package com.scala.qa.contentmanager.PageObjects.System;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import jdk.nashorn.internal.runtime.ECMAException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/28/2016.
 */
public class DBConfig extends PageBase {

    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"left\"]/descendant::a[@href=\"#dbconfig\"]") private WebElement eleDBConfig;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"advanced\"]") private WebElement eleAdvancedTab;


    public DBConfig(WebDriver driver){
        super();
    }

    public void clickDBConfigMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleDBConfig, "DBConfig Landing page");
    }

    public boolean clickDBConfigTabs() throws Exception {
        try {
            clickElement(elePropertiesTab, "DBConfig Properties tab");
            clickElement(eleAdvancedTab, "DBConfig Advanced tab");
            return true;
        }catch (Exception e){return false;}
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "database configuration":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleDBConfig);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "database configuration":
                rightNav.clickSystemMenu();
                return isDisplayed(eleDBConfig);
        }
        return false;
    }
}
