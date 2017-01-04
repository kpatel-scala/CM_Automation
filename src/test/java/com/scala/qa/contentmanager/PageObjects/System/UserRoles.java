package com.scala.qa.contentmanager.PageObjects.System;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by kpatel on 11/28/2016.
 */
public class UserRoles extends PageBase {

    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#role\"]") private WebElement eleUserRoles;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;
    @FindBy(xpath = "//div[@class=\"newItem\"]//section[@class=\"content\"]//li[@class=\"name\"]//input[@data-property=\"name\"]") private WebElement eleTxtRoleName;
    @FindBy(xpath = "//div[@class=\"newItem\"]//div[@class=\"modal\"]//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnSave;

    public UserRoles(WebDriver driver){
        super();
    }

    public void clickUserRolesMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav. clickSystemMenu();
        clickElement(eleUserRoles, "UserRole Landing page");
    }


    public void createUserRole(String roleName) throws Exception {
        clickUserRolesMenu();
        clickElement(eleBtnNew, "Click new button Roles");
        enterText(eleTxtRoleName, roleName, "Enter role name");
        clickElement(eleBtnSave, "Click save button Roles");
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "user role":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleUserRoles);
            case "new":
                clickUserRolesMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "user role":
                rightNav.clickSystemMenu();
                return isDisplayed(eleUserRoles);
            case "new":
                clickUserRolesMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}

