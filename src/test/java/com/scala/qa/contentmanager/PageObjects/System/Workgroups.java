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
public class Workgroups extends PageBase{
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#workgroup\"]") private WebElement eleWorkgroups;
    @FindBy(className = "addChild") private WebElement eleBtnNew;
    @FindBy(xpath = "//li[@class=\"name\"]/div/input[@type=\"text\"]") private WebElement eleInputName;
    @FindBy(xpath = "//footer/div[@class=\"actions\"]/button[@class=\"button-primary save\"]") private WebElement eleBtnSaveBeforeAtlanta;
    @FindBy(className = "ok") private WebElement eleBtnSave;


    public Workgroups(WebDriver driver){
        super();
    }

    public void clickWorkgroupMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleWorkgroups, "Workgroups Landing page");
    }

    public boolean createNewWorkgroup(String wgName) throws Exception {
        try {
            clickWorkgroupMenu();
            clickElement(eleBtnNew, "New Workgroup button");
            enterText(eleInputName, wgName, "Enter new workgroup name");
            clickElement(eleBtnSave, "Save Workgroup");
            return true;
        }catch (Exception e){return false;}
    }


    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "workgroup":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleWorkgroups);
            case "new":
                clickWorkgroupMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "workgroups":
                rightNav.clickSystemMenu();
                return isDisplayed(eleWorkgroups);
            case "new":
                clickWorkgroupMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}
