package com.scala.qa.contentmanager.PageObjects.Reporting;

import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/28/2016.
 */
public class Reports {

    private WebDriver driver;
    private LeftNavMenu leftNav;

    public Reports(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickReportsMenu() throws Exception {
        leftNav = new LeftNavMenu(driver);
        leftNav.clickReportingMenu();
    }
}
