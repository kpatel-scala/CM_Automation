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
public class Distribution extends PageBase{

    private LeftNavMenu leftNav;

    @FindBy(xpath = "//nav/ul[@class=\"left\"]//a[@href=\"#distribution\"]") private WebElement eleDistributionMenu;
    @FindBy(linkText = "Main") private WebElement eleMainServer;
    @FindBy(linkText = "IAdea Bridge Servers") private WebElement eleBroadcastServer;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"column middle box\"]//button[@class=\"newBroadcastServer\"]") private WebElement eleBtnNewBrdCastServer;



    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"subNetworks\"]") private WebElement eleSubNetworkTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"schedule\"]") private WebElement eleScheduleTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"mediaDistribution\"]") private WebElement eleMediaDistributionTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"syncHistory\"]") private WebElement elePlanGenHistoryTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]//dt[@data-tabgroup=\"broadcasts\"]") private WebElement eleBroadcastTab;



    public Distribution(WebDriver driver){
        super();
    }

    public boolean clickDistributionMenu() throws Exception {
        try{
            leftNav = new LeftNavMenu(driver);
            leftNav.clickNetworkMenu();
            clickElement(eleDistributionMenu, "Distribution server landing page");
            return true;
        }catch (Exception e){return false;}

}

    public boolean openBroadcastServer() throws Exception {
        try {
            clickDistributionMenu();
            return  clickElement(eleBroadcastServer, "Open Distribution Broadcast server");
        }catch (Exception e){return false;}

    }

    public boolean openMainServer() throws Exception {
        try {
            clickDistributionMenu();
            clickElement(eleMainServer, "Open Distribution Main server");
            return true;
        }catch (Exception e){return false;}

    }

    public boolean clickBroadcastServerTabs() throws Exception {
        try {
            clickElement(elePropertiesTab, "Distribution Broadcast server Properties tab");
            clickElement(eleSubNetworkTab, "Distribution Broadcast server Driver Option tab");
            clickElement(eleScheduleTab, "Distribution Broadcast server Schedule tab");
            clickElement(eleMediaDistributionTab, "Distribution Broadcast server Media distribution tab");
            clickElement(elePlanGenHistoryTab, "Distribution Broadcast server Plan Gen history tab");
//        clickElement(eleBroadcastTab, "Distribution Broadcast server Broadcasts tab");
            return true;
        }catch (Exception e){ return false;}
    }

    public boolean clickMainServerTabs() throws Exception {
        try {
            clickElement(elePropertiesTab, "Distribution Main server Properties tab");
            clickElement(eleScheduleTab, "Distribution Main server Schedule tab");
            clickElement(eleMediaDistributionTab, "Distribution Main server Media distribution tab");
            clickElement(elePlanGenHistoryTab, "Distribution Main server Plan Gen history tab");
            return true;
        }catch (Exception e){ return false;}
    }



    public boolean isNotDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()) {
            case "distribution":
                leftNav.clickNetworkMenu();
                return isNotDisplayed(eleDistributionMenu);
            case "new broadcast server":
                clickDistributionMenu();
                return isNotDisplayed(eleBtnNewBrdCastServer);
            case "main server":
                clickDistributionMenu();
                return isNotDisplayed(eleMainServer);
            case "iadea bridge server":
                clickDistributionMenu();
                return isNotDisplayed(eleBroadcastServer);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()) {
            case "distribution":
                leftNav.clickNetworkMenu();
                return isDisplayed(eleDistributionMenu);
            case "new broadcast server":
                clickDistributionMenu();
                return isDisplayed(eleBtnNewBrdCastServer);
            case "main server":
                clickDistributionMenu();
                return isDisplayed(eleMainServer);
            case "iadea bridge server":
                clickDistributionMenu();
                return isDisplayed(eleBroadcastServer);
        }
        return false;
    }

}
