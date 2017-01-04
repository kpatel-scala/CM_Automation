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
public class MediaMetadata  extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#mediametadata\"]") private WebElement eleMediaMetadata;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;
    @FindBy(xpath = "//div[@class=\"newMetadata\"]//section[@class=\"content\"]//li[@class=\"name\"]//input[@data-property=\"name\"]") private WebElement eleTxtMMName;
    @FindBy(xpath = "//div[@class=\"newMetadata\"]//div[@class=\"modal\"]//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnSave;

    @FindBy(xpath = "//div[@class=\"newMetadata\"]//section[@class=\"content\"]//div[@class=\"typesContainer\"]//li[@class=\"datatype\"]//div[@class=\"current\"]/span") private  WebElement eleComboXDataType;
    @FindBy(xpath = "//div[@class=\"newMetadata\"]//section[@class=\"content\"]//div[@class=\"typesContainer\"]//li[@class=\"valueType\"]//div[@class=\"current\"]/span") private  WebElement eleComboXValueType;
    @FindBy(xpath = "html/body/ul/li[@data-id=\"STRING\"]") private WebElement elePopUpString;
    @FindBy(xpath = "html/body/ul/li[@data-id=\"INTEGER\"]") private WebElement elePopUpInt;
    @FindBy(xpath = "html/body/ul/li[@data-id=\"BOOLEAN\"]") private WebElement elePopUpBoolean;
    @FindBy(xpath = "html/body/ul/li[@data-id=\"ANY\"]") private WebElement elePopUpSAny;
    @FindBy(xpath = "html/body/ul/li[@data-id=\"PICKLIST\"]") private WebElement elePopUpPicklist;


//div[@class="newMetadata"]//section[@class="content"]//div[@class="typesContainer"]//li[@class="datatype"]//div[class="current"]/span


    public MediaMetadata(WebDriver driver){
        super();
    }

    public void clickMediaMetadataMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleMediaMetadata, "MediaMetadata Landing page");
    }


    public boolean createMediaMetadata(String mmName) throws Exception {
        try{
            clickMediaMetadataMenu();
            clickElement(eleBtnNew, "click New button Media Metadata");
            enterText(eleTxtMMName, mmName, "enter the media metadata name");
            clickElement(eleComboXDataType, "click combo data type ");
            clickElement(elePopUpInt, "select int data type");
            clickElement(eleComboXValueType, "click combo value type");
            clickElement(elePopUpSAny, "Select any value type");
            clickElement(eleBtnSave, "Click save button Media metadata");
            return true;
        }catch (Exception e){return false;}
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "media metadata":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleMediaMetadata);
            case "new":
                clickMediaMetadataMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "media metadata":
                rightNav.clickSystemMenu();
                return isDisplayed(eleMediaMetadata);
            case "new":
                clickMediaMetadataMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}