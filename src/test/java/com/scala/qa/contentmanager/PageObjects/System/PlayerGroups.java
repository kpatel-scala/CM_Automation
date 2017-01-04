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
public class PlayerGroups  extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#playergroup\"]") private WebElement elePlayerGroups;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;
    @FindBy(xpath = "//div[@class=\"newItem\"]//section[@class=\"content\"]//li[@class=\"name\"]//input[@data-property=\"name\"]") private WebElement eleTxtMMName;
    @FindBy(xpath = "//div[@class=\"newItem\"]//div[@class=\"modal\"]//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnSave;



    public PlayerGroups(WebDriver driver){
        super();
    }

    public void clickPlayerGroupsMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(elePlayerGroups, "Player Groups Landing page");
    }

    public boolean createPlayerGroup(String PGname) throws Exception {
        try{
            clickPlayerGroupsMenu();
            clickElement(eleBtnNew, "Click New button");
            enterText(eleTxtMMName, PGname, "enter Player group name");
            clickElement(eleBtnSave, "Click create button");
            return true;
        }catch (Exception e){return false;}
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "player groups":
                rightNav.clickSystemMenu();
                return isNotDisplayed(elePlayerGroups);
            case "new":
                clickPlayerGroupsMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "player groups":
                rightNav.clickSystemMenu();
                return isDisplayed(elePlayerGroups);
            case "new":
                clickPlayerGroupsMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}