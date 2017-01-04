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
public class Folders  extends PageBase {

    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#directory\"]") private WebElement eleFolders;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;

    public Folders(WebDriver driver){
        super();
    }

    public void clickFoldersMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleFolders, "Folders Landing page");
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "folders":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleFolders);
            case "new":
                clickFoldersMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "folders":
                rightNav.clickSystemMenu();
                return isDisplayed(eleFolders);
            case "new":
                clickFoldersMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}