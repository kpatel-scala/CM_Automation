package com.scala.qa.contentmanager.PageObjects.System;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
//import org.apache.tools.ant.filters.LineContains;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/28/2016.
 */
public class UserProfile extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#user\"]") private WebElement eleUserProfile;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;
    @FindBy(xpath = "//li[@class=\"username\"]//input[@data-property=\"username\"]") private WebElement eleInputUserName;
    @FindBy(xpath = "//section[@class=\"content\"]//div[@class=\"formContainer\"]//li[@class=\"password\"]//input[@data-property=\"password\"]") private WebElement eleInputPassword;
    @FindBy(xpath = "//section[@class=\"content\"]//div[@class=\"formContainer\"]//li[@class=\"confirmPassword\"]//input[@data-property=\"confirmPassword\"]") private WebElement eleInputConfirmPwd;
    @FindBy(xpath = "//li[@class=\"firstname\"]//input[@data-property=\"firstname\"]") private WebElement eleInputFName;
    @FindBy(xpath = "//li[@class=\"lastname\"]//input[@data-property=\"lastname\"]") private WebElement eleInputLName;
    @FindBy(xpath = "//li[@class=\"emailaddress\"]//input[@data-property=\"emailaddress\"]") private WebElement eleInputEmail;




    @FindBy(xpath = "//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li[@data-value=\"22\"]/input[@type=\"checkbox\"]") private WebElement eleChkBoxAdmin;
    @FindBy(xpath = "//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li[@data-value=\"28\"]/input[@type=\"checkbox\"]") private WebElement eleChkBoxGraphicD;
    @FindBy(xpath = "//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li[@data-value=\"27\"]/input[@type=\"checkbox\"]") private WebElement eleChkBoxMsgEditor;
    @FindBy(xpath = "//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li[@data-value=\"26\"]/input[@type=\"checkbox\"]") private WebElement eleChkBoxMsgManager;
    @FindBy(xpath = "//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li[@data-value=\"29\"]/input[@type=\"checkbox\"]") private WebElement eleChkBoxNTManager;
    @FindBy(xpath = "//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li[@data-value=\"25\"]/input[@type=\"checkbox\"]") private WebElement eleChkBoxScheduleManager;
    @FindBy(xpath = "//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li[@data-value=\"24\"]/input[@type=\"checkbox\"]") private WebElement eleChkBoxViewer;


    @FindBy(xpath = "//footer/div[@class=\"actions\"]/button[@class=\"button-primary save\"]") private WebElement eleBtnSave;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"personalInformation\"]") private WebElement elePersonalInfoTab;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"workgroup\"]") private WebElement eleWorkgroupTab;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"regionalSettings\"]") private WebElement eleRegionalSettingTab;
    @FindBy(xpath = "//div[@class=\"detail box user\"]//dt[@data-tabgroup=\"miscellaneousSettings\"]") private WebElement eleMiscTab;
    @FindBy(xpath = "//div[@class=\"main\"]/descendant::button[@class=\"button-primary saveAndClose\"]") private WebElement eleBtnSaveNClose;



    public UserProfile(WebDriver driver){
        super();
    }

    public void clickUserProfileMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleUserProfile, "UserProfile Landing page");
    }


    public boolean createNewUser(String userName, String pwd, String lastName, String eMail, String role) throws Exception {
        try {
            clickUserProfileMenu();
            clickElement(eleBtnNew, "New User button");
            enterText(eleInputUserName, userName, "Enter new users info - UserName");
            enterText(eleInputPassword, pwd, "Enter new users info - Password");
            enterText(eleInputConfirmPwd, pwd, "Enter new users info - ConfirmPassword");
            enterText(eleInputFName, userName, "Enter new users info - FirstName");
            enterText(eleInputLName, lastName, "Enter new users info - LastName");
            enterText(eleInputEmail, eMail, "Enter new users info - Email");

            pickItem("//div[@class=\"inlineEdit multiSelect\"]//ul[@class=\"options\"]/li", role);

            clickElement(eleBtnSave, "Save New User window");

            return true;
        }catch (Exception e){return false;}
    }

    public void selectWG(String userName, String wgName) throws Exception {
//        clickElement(driver.findElement(By.linkText(userName)),"Open User Profile");
        String pathtoWG = "//dd[@class=\"workgroup\"]//ul[@class=\"basic hierarchical\"]/descendant::span[text()=\"" + wgName +"\"]";
        clickElement(eleWorkgroupTab, "Open workgroup tab");
        clickElement(driver.findElement(By.xpath(pathtoWG)), "Select workgroup");
        clickElement(eleBtnSaveNClose, "Save User Profile");
    }

    public boolean openUser(String userProfile) throws Exception {
        clickUserProfileMenu();
        try {
            clickElement(driver.findElement(By.linkText(userProfile)), "Open a user profile");
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public boolean clickUserProfileTabs() throws Exception {
        try {
            clickElement(elePersonalInfoTab, "Click on personal info tab");
            clickElement(eleWorkgroupTab, "Click on workgroup tab");
            clickElement(eleRegionalSettingTab, "Click on Regional settings taB");
            clickElement(eleMiscTab, "Click on Miscellaneous tab");
            return true;
        }catch (Exception e){ return false;}
    }


    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "user profile":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleUserProfile);
            case "new":
                clickUserProfileMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "user profile":
                rightNav.clickSystemMenu();
                return isDisplayed(eleUserProfile);
            case "new":
                clickUserProfileMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }

}
