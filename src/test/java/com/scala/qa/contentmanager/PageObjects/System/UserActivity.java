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
public class UserActivity extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#useractivity\"]") private WebElement eleUserActivity ;

    public UserActivity(WebDriver driver){
        super();
    }

    public boolean clickUserActivityMenu() throws Exception {
        try {
            rightNav = new RightNavMenu(driver);
            rightNav.clickSystemMenu();
            clickElement(eleUserActivity, "UserActivity Landing page");
            return true;
        }catch (Exception e){return false;}
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "user activity":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleUserActivity);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "user activity":
                rightNav.clickSystemMenu();
                return isDisplayed(eleUserActivity);
        }
        return false;
    }
}

