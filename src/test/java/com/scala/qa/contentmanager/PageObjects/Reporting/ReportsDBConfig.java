package com.scala.qa.contentmanager.PageObjects.Reporting;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 12/1/2016.
 */
public class ReportsDBConfig extends PageBase {
        private WebDriver driver;
        private LeftNavMenu leftNav;

        @FindBy(xpath = "//nav/ul[@class=\"left\"]//a[@href=\"#pamDbConfig\"]") private WebElement eleReportDBConfig;

        public ReportsDBConfig(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void clickReportsDBConfigMenu() throws Exception {
            leftNav = new LeftNavMenu(driver);
            leftNav.clickReportingMenu();
            clickElement(eleReportDBConfig, "Report Settings landing page");
        }
}

