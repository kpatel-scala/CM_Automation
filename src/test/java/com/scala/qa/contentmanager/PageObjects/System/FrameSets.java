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
public class FrameSets  extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#frameset\"]") private WebElement eleFramesets;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;

    public FrameSets(WebDriver driver){
        super();
    }

    public void clickFrameSetsMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleFramesets, "Framesets Landing page");
    }


    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "framesets":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleFramesets);
            case "new":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "framesets":
                rightNav.clickSystemMenu();
                return isDisplayed(eleFramesets);
            case "new":
                clickFrameSetsMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }

}