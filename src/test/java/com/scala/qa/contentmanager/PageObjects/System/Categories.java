package com.scala.qa.contentmanager.PageObjects.System;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by kpatel on 11/28/2016.
 */
public class Categories extends PageBase{

    private RightNavMenu rightNav;

    @FindBy(xpath = "//nav/ul[@class=\"right\"]//li[@class=\"right\"]/descendant::a[@href=\"#category\"]") private WebElement eleCategories;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"actionPanel\"]/button[@class=\"newItem\"]") private WebElement eleBtnNew;
    @FindBy(xpath = "//div[@class=\"newItem\"]//div[@class=\"modal\"]//div[@class=\"formContainer\"]//input[@data-property=\"name\"]") private WebElement eleTxtCatName;
    @FindBy(xpath = "//div[@class=\"newItem\"]//div[@class=\"modal\"]//footer//button[@class=\"button-primary save\"]") private WebElement eleBtnSave;



    public Categories(WebDriver driver){
        super();
    }

    public void clickCategoriesMenu() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickSystemMenu();
        clickElement(eleCategories, "Categories Landing page");
    }

    public boolean createNewCategory(String catName) throws Exception {
        try {
            clickCategoriesMenu();
            clickElement(eleBtnNew, "Click new category button");
            enterText(eleTxtCatName, catName, "Enter the category name");
            clickElement(eleBtnSave, "Save category");
            return true;
        }catch (Exception e){return false;}
    }


    public boolean isNotDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()) {
            case "categories":
                rightNav.clickSystemMenu();
                return isNotDisplayed(eleCategories);
            case "new":
                clickCategoriesMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        rightNav = new RightNavMenu(driver);
        switch(name.toLowerCase()){
            case "categories":
                rightNav.clickSystemMenu();
                return isDisplayed(eleCategories);
            case "new":
                clickCategoriesMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }
}
