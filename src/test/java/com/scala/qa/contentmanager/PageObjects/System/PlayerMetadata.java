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
public class PlayerMetadata  extends PageBase {
    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#playermetadata\"]") private WebElement elePlayerMetadata;
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

    public PlayerMetadata(WebDriver driver){
        super();
    }

    public void clickPlayerMetadataMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(elePlayerMetadata, "PlayerMetadata Landing page");
    }


    public boolean createPlayerMetadata(String PMName) throws Exception {
        try{
            clickPlayerMetadataMenu();
            clickElement(eleBtnNew, "click New button Player Metadata");
            enterText(eleTxtMMName, PMName, "enter the Player metadata name");
            clickElement(eleComboXDataType, "click combo data type ");
            clickElement(elePopUpInt, "select int data type");
            clickElement(eleComboXValueType, "click combo value type");
            clickElement(elePopUpSAny, "Select any value type");
            clickElement(eleBtnSave, "Click save button Player metadata");
            return true;
        }catch (Exception e){return false;}
    }

    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "player metadata":
                rightNav.clickSystemMenu();
                return isNotDisplayed(elePlayerMetadata);
            case "new":
                clickPlayerMetadataMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "player metadata":
                rightNav.clickSystemMenu();
                return isDisplayed(elePlayerMetadata);
            case "new":
                clickPlayerMetadataMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}
