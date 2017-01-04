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
public class LicenseStatus  extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"left\"]/descendant::a[@href=\"#license\"]") private WebElement eleLicense;

    public LicenseStatus(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public boolean clickLicenseStatusMenu() throws Exception {
        try {
            rightNav = new RightNavMenu(driver);
            rightNav.clickSystemMenu();
            clickElement(eleLicense, "License Landing page");
            return true;
        }catch (Exception e){return false;}
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "license status":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleLicense);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "license status":
                rightNav.clickSystemMenu();
                return isDisplayed(eleLicense);
        }
        return false;
    }
}
