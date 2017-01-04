package com.scala.qa.contentmanager.PageObjects;

import com.scala.qa.contentmanager.Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/27/2016.
 */
public class LeftNavMenu extends PageBase {

    @FindBy(xpath = "//nav/ul[contains(@class,\"left\")]/li[1]/a") private WebElement eleContentMenu;
    @FindBy(xpath = "//nav/ul[contains(@class,\"left\")]/li[2]/a") private WebElement elePlanningMenu;
    @FindBy(xpath = "//nav/ul[contains(@class,\"left\")]/li[3]/a") private WebElement eleNetworktMenu;
    @FindBy(xpath = "//nav/ul[contains(@class,\"left\")]/li[4]/a") private WebElement eleReportingMenu;


    public LeftNavMenu(WebDriver driver){
        super();
    }

    public void clickContentMenu() throws Exception {
        clickElement(eleContentMenu, "Content menu");
    }

    public void clickPlanningMenu() throws Exception {
        clickElement(elePlanningMenu, "Planning menu");
    }

    public void clickNetworkMenu() throws Exception {
        clickElement(eleNetworktMenu, "Network menu");
    }

    public void clickReportingMenu() throws Exception {
        clickElement(eleReportingMenu, "Reporting menu");
    }


    public boolean isNotDisplayed(String name){
        switch(name.toLowerCase()) {
            case "content":
                return isNotDisplayed(eleContentMenu);
            case "planning":
                return isNotDisplayed(elePlanningMenu);
            case "network":
                return isNotDisplayed(eleNetworktMenu);
            case "reporting":
                return isNotDisplayed(eleReportingMenu);
        }
        return false;
    }

    public boolean isDisplayed(String name){
        switch(name.toLowerCase()) {
            case "content":
                return isDisplayed(eleContentMenu);
            case "planning":
                return isDisplayed(elePlanningMenu);
            case "network":
                return isDisplayed(eleNetworktMenu);
            case "reporting":
                return isDisplayed(eleReportingMenu);
        }
        return false;
    }

}
