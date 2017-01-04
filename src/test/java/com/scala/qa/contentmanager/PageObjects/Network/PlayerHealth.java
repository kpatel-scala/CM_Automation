package com.scala.qa.contentmanager.PageObjects.Network;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/28/2016.
 */
public class PlayerHealth extends PageBase{

    private LeftNavMenu leftNav;

    @FindBy(xpath = "//ul[@class=\"basic playerhealth\"]/li[@id=\"71548\"]//a[@href=\"#playerhealth/71548\"]") private WebElement elePlayerProblem;
    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#playerhealth\"]") private WebElement elePlayerHealthMenu;

    @FindBy(xpath = "//div[@class=\"main\"]//dl[@class=\"playerHealth\"]/dt[@data-tabgroup=\"properties\"]") private WebElement eleDetailsTab;
    @FindBy(xpath = "//div[@class=\"main\"]//dl[@class=\"playerHealth\"]/dt[@data-tabgroup=\"reportedBy\"]") private WebElement eleReportedByTab;


    public PlayerHealth(WebDriver driver){
        super();
    }

    public boolean clickPlayerHealthMenu() throws Exception {
        try {
            leftNav = new LeftNavMenu(driver);
            leftNav.clickNetworkMenu();
            clickElement(elePlayerHealthMenu, "Player landing page");
            return true;
        }catch (Exception e){return false;}
    }

    public void openPlayerHealth() throws Exception {
        clickElement(elePlayerProblem, "Open Player");
    }

    public void clickPlayerTabs() throws Exception {
        clickElement(eleDetailsTab, "PlayerHealth Details tab");
        clickElement(eleReportedByTab, "Player ReportedBy tab");
    }


    public boolean isNotDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()) {
            case "player health":
                leftNav.clickNetworkMenu();
                return isNotDisplayed(elePlayerHealthMenu);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "player health":
                leftNav.clickNetworkMenu();
                return isDisplayed(elePlayerHealthMenu);
        }
        return false;
    }
}
