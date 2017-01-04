package com.scala.qa.contentmanager.PageObjects;

import com.scala.qa.contentmanager.Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kpatel on 11/27/2016.
 */
public class RightNavMenu extends PageBase {

    @FindBy(xpath = "//nav/ul[@class=\"right\"]/li[1]/a") private WebElement eleSystemMenu;
    @FindBy(className = "userSettings") private WebElement eleAdminMenu;


    public RightNavMenu(WebDriver driver){
        super();
    }

    public void clickSystemMenu() throws Exception {
        clickElement(eleSystemMenu,"System Menu");
    }

    public void clickAdminMenu() throws Exception {
        clickElement(eleAdminMenu,"User Settings");
    }
}

