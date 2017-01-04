package com.scala.qa.contentmanager.PageObjects.Admin;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.RightNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kpatel on 11/23/2016.
 */
public class Logout extends PageBase{

    private WebDriver driver;
    private RightNavMenu rightNav;

    @FindBy (xpath = "//a[@href=\"#logout\"]") protected WebElement eleLogout;

    public Logout(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Logout() throws Exception {
        rightNav = new RightNavMenu(driver);
        rightNav.clickAdminMenu();
        clickElement(eleLogout, "User Logout");
    }

}
