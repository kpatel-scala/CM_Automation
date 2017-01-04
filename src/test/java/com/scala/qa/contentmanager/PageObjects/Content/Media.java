package com.scala.qa.contentmanager.PageObjects.Content;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.misc.CEFormatException;
import sun.reflect.annotation.EnumConstantNotPresentExceptionProxy;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Time;

/**
 * Created by kpatel on 11/22/2016.
 */
public class Media extends PageBase {

    private LeftNavMenu leftNav;

    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#media\"]") private WebElement eleMediaMenu;
    @FindBy(className = "fileChooser") private WebElement eleSendFile;
    @FindBy(linkText = "AutoMessage") private WebElement eleMsgMedia;
    @FindBy (linkText = "AutoImage.jpg") private WebElement eleImageMedia;
    @FindBy (linkText = "AutoVideo.mp4") private WebElement eleVideoMedia;
    @FindBy (id = "search") private WebElement eleSearchMedia;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"metadata\"]") private WebElement eleMetadataTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"mediaInfo\"]") private WebElement eleMediaInfoTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"advanced\"]") private WebElement eleAdvancedTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"approval\"]") private WebElement eleApprovalTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"preview\"]") private WebElement elePreviewTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"editor\"]") private WebElement eleMsgPreviewTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div[2]/dl/dt[@data-tabgroup=\"broadcastPriority\"]") private WebElement eleBroadcastPriorityTab;
    @FindBy(xpath = "//div[@class=\"column middle box\"]//ul[@class=\"menu newItem\"]/li/a") private WebElement eleBtnNew;
    @FindBy(xpath = "//div[@class=\"column middle box\"]//ul[@class=\"menu newItem\"]/descendant::button[@data-action=\"uploadMedia\"]") private WebElement eleBtnMediaUpload;
    @FindBy(xpath = "//div[@class=\"column middle box\"]//ul[@class=\"menu newItem\"]/descendant::button[@data-action=\"newMessage\"]") private WebElement eleBtnNewMsg;
    @FindBy(xpath = "//div[@class=\"column middle box\"]//ul[@class=\"menu newItem\"]/descendant::button[@data-action=\"newHtml\"]") private WebElement eleBtnNewHtml;
    @FindBy(xpath = "//section[@class=\"content\"]/descendant::div[@class=\"fileChooser\"]/button[@class=\"add\"]") private WebElement eleBtnpopupAdd;
    @FindBy(xpath = "//footer/div[@class=\"actions\"]/button[@class=\"button-primary save\"]") private WebElement eleBtnUpload;


    public Media(WebDriver driver) {
        super();
    }

    public void clickMediaMenu() throws Exception {
        leftNav = new LeftNavMenu(driver);
        leftNav.clickContentMenu();
//        Assert.assertTrue(isDisplayed("media"));
        clickElement(eleMediaMenu, "Media menu");
    }

    public void openMedia(String mediaName) throws Exception {
        clickMediaMenu();
        clickElement(driver.findElement(By.linkText(mediaName)),"Open Media");
    }

    public boolean clickMediaTabs() throws Exception {
        try {
            clickElement(elePropertiesTab, "Image Properties tab");
            clickElement(eleMetadataTab, "Image Metadata tab");
            clickElement(eleMediaInfoTab, "Image MediaInfo tab");
            clickElement(eleAdvancedTab, "Image Advanced tab");
            clickElement(eleApprovalTab, "Image Approval tab");
            clickElement(elePreviewTab, "Image Preview tab");
            clickElement(eleBroadcastPriorityTab, "Image Broadcast Priority tab");
            return true;
        }catch(Exception e){ return false;}
    }

    public boolean clickMsgMediaTabs() throws Exception {
        try {
            clickElement(elePropertiesTab, "Image Properties tab");
            clickElement(eleMetadataTab, "Image Metadata tab");
            clickElement(eleMediaInfoTab, "Image MediaInfo tab");
            clickElement(eleApprovalTab, "Image Approval tab");
            clickElement(eleMsgPreviewTab, "Image Preview tab");
            return true;
        }catch (Exception e){ return false; }
    }

    public boolean uploadMedia(String mediaName, String browser) throws Exception {

        clickMediaMenu();
        clickElement(eleBtnNew, "Click New Button");
        clickElement(eleBtnMediaUpload, "Upload Media");
        clickElement(eleBtnpopupAdd, "Add button");


        StringSelection mediapath = new StringSelection("");
        String workingDir = System.getProperty("user.dir");
        String media = "";
        media = workingDir +"\\TestData\\" + mediaName;
        mediapath = new StringSelection(media);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(mediapath, null);;


        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        if(browser.equals("chrome")) {
            clickElement(eleBtnUpload, "upload Media");
        }

        Thread.sleep(5000);

        return isDisplayed(driver.findElement(By.linkText(mediaName)));

    }

    public boolean isNotDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "media":
                leftNav.clickContentMenu();
                return isNotDisplayed(eleMediaMenu);
            case "mediaupload":
                clickMediaMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNav = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "media":
                leftNav.clickContentMenu();
                return isDisplayed(eleMediaMenu);
            case "mediaupload":
                clickMediaMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}

