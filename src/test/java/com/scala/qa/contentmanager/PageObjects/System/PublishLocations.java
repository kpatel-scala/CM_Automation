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
public class PublishLocations  extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#publishlocation\"]") private WebElement elePublishLocation;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;

    public PublishLocations(WebDriver driver) {
        super();
    }

    public void clickPublishLocationsMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(elePublishLocation, "PublishLocation Landing page");
    }


    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "publish location":
                rightNav.clickSystemMenu();
                return isNotDisplayed(elePublishLocation);
            case "new":
                clickPublishLocationsMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "publish locations":
                rightNav.clickSystemMenu();
                return isDisplayed(elePublishLocation);
            case "new":
                clickPublishLocationsMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }


}