package com.scala.qa.contentmanager.PageObjects.Admin;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by kpatel on 11/29/2016.
 */
public class PersonalSettings extends PageBase {

    private RightNavMenu rightNav;

    //@FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"userSettings\"]/descendant::a[@href=\"#personalInformation\"]") private WebElement elePersonalSettings;
    @FindBy(xpath = "//a[@href=\"#personalInformation\"]") private WebElement elePersonalSettings;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"personalInformation\"]") private WebElement elePersonalInfoTab;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"changePassword\"]") private WebElement eleChangePwdTab;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"regionalSettings\"]") private WebElement eleRegionalSettingsTab;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"emailAlertsSettings\"]") private WebElement eleEmailAlertTab;
    @FindBy(xpath = "//div[@id=\"options\"]/div/a/span[2]/b[@role=\"presentation\"]") private WebElement eleOpenCombox;
    @FindBy(id = "comboBox") private WebElement eleLangCombox;
    @FindBy(xpath = "//button[@class=\"button-primary saveAndClose\"]") private WebElement eleButSaveNClose;

    @FindBy(xpath = ("//div[@id=\"select2-result-label-146\"]/span")) private WebElement eleEspanol;


    public PersonalSettings(WebDriver driver){
        super();
    }

    public boolean clickPersonalSettingMenu() throws Exception {
        try {
            rightNav = new RightNavMenu(driver);
            rightNav.clickAdminMenu();
            clickElement(elePersonalSettings, "Personal Settings landing page");
            return true;
        }catch (Exception e){return false;}
    }

    public boolean clickPersonalSettingsTabs() throws Exception {
        try {
            clickElement(elePersonalInfoTab, "Personal Settings PersonalInfo tab");
            clickElement(eleChangePwdTab, "Personal Settings Change password tab");
            clickElement(eleRegionalSettingsTab, "Personal Settings Regional Settings tab");
            clickElement(eleEmailAlertTab, "Personal Settings Emal Alert tab");
            return true;
        }catch (Exception e){return false;}
    }

    public void changeDefaultLanguage(String language) throws Exception {
        clickElement(eleRegionalSettingsTab, "Personal Settings Regional Settings tab");
        clickElement(eleOpenCombox, "Combobox Open");
        pickItem("//div[@id=\"select2-drop\"]//ul[@id=\"select2-results-1\"]/li/div", language);
        clickElement(eleButSaveNClose, "Save and close Personal Settings");
    }


}
