package com.scala.qa.contentmanager.Tests.RegressionSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Admin.Logout;
import com.scala.qa.contentmanager.PageObjects.LoginPage;
import com.scala.qa.contentmanager.PageObjects.System.UserProfile;
import com.scala.qa.contentmanager.PageObjects.System.Workgroups;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 12/5/2016.
 */
public class test_UserCreation extends TestBaseSetup{
    private WebDriver driver;

    private UserProfile userProfile;
    private Logout logout;
    private LoginPage loginPage;


    @BeforeTest
    public void testSetup() throws Exception {
        PageBase basePage = new PageBase(getDriver());
        userProfile = new UserProfile(getDriver());
        loginPage = new LoginPage(getDriver());
        logout = new Logout(getDriver());

    }


    @Test(priority = 1)
    public void test_CreateNewAdminUser() throws Exception{
        userProfile.clickUserProfileMenu();
        userProfile.createNewUser("AutoAdmin", "scala123", "Test", "test@scala.com", "administrator");
        logout.Logout();
        loginPage.Login("AutoAdmin", "scala123");
    }

    @Test(priority = 2)
    public void test_CreateNewMsgEditorUser() throws Exception{
        userProfile.clickUserProfileMenu();
        userProfile.createNewUser("AutoMsgEditor", "scala123", "Test", "test@scala.com", "messageeditor");
    }

    @Test(priority = 3)
    public void test_CreateNewMsgManagerUser() throws Exception{
        userProfile.clickUserProfileMenu();
        userProfile.createNewUser("AutoMsgManager", "scala123", "Test", "test@scala.com", "messagemanager");
    }

    @Test(priority = 4)
    public void test_CreateNewNtManagerUser() throws Exception{
        userProfile.clickUserProfileMenu();
        userProfile.createNewUser("AutoNTManager", "scala123", "Test", "test@scala.com", "networkmanager");
    }

    @Test(priority = 5)
    public void test_CreateNewScheduleManagerUser() throws Exception{
        userProfile.clickUserProfileMenu();
        userProfile.createNewUser("AutoScheduleManager", "scala123", "Test", "test@scala.com", "schedulemanager");
    }

    @Test(priority = 6)
    public void test_CreateNewViewerUser() throws Exception{
        userProfile.clickUserProfileMenu();
        userProfile.createNewUser("AutoViewer", "scala123", "Test", "test@scala.com", "viewer");
    }

    @Test(priority = 7)
    public void test_CreateNewGraphicDUser() throws Exception{
        userProfile.clickUserProfileMenu();
        userProfile.createNewUser("AutoGraphicDesigner", "scala123", "Test", "test@scala.com", "graphicdesigner");
    }

}
