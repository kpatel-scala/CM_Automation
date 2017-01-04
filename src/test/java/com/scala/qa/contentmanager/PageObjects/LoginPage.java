package com.scala.qa.contentmanager.PageObjects;

/**
 * Created by kpatel on 11/18/2016.
 */


import com.scala.qa.contentmanager.Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends PageBase {

    private WebDriver driver;

    @FindBy(name = "username") private WebElement userName;
    @FindBy(name = "password") private WebElement password;
    @FindBy(className = "signIn") private WebElement signIn;


    public LoginPage(WebDriver driver) throws Exception{
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void Login(String userID, String Pwd) throws Exception {
       try {
           enterUserID(userID);
           enterPassword(Pwd);
           clickSignIn();
       } catch (Exception exc) {}
    }


    public void enterUserID(String uname) throws Exception{
        enterText(userName, uname, "Entering Username");
    }

    public void enterPassword(String Pwd) throws Exception{
        enterText(password, Pwd, "Entering Password");
    }

    public void clickSignIn() throws Exception {
        clickButton(signIn, "Log into CM");
    }
}


