package com.scala.qa.contentmanager.PageObjects.Content;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by kpatel on 11/27/2016.
 */
public class Template extends PageBase{

    private LeftNavMenu leftNavMenu;

    @FindBy(xpath = "//nav/ul[@class=\"left\"]/descendant::a[@href=\"#template\"]") private WebElement eleTemplateMenu;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div/dl/dt[@data-tabgroup=\"properties\"]") private WebElement elePropertiesTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div/dl/dt[@data-tabgroup=\"templateInfo\"]") private WebElement eleTemplateInfoTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div/dl/dt[@data-tabgroup=\"administration\"]") private WebElement eleTemplateAdminTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div/dl/dt[@data-tabgroup=\"advanced\"]") private WebElement eleTemplateHistoryTab;
    @FindBy(xpath = "//div[@class=\"detail box\"]/div/dl/dt[@data-tabgroup=\"preview\"]") private WebElement elePreviewTab;
    @FindBy(xpath = "//div[@class=\"column middle box\"]/descendant::button[@class=\"upload\"]") private WebElement eleBtnNew;
    @FindBy(xpath = "//section[@class=\"content\"]/descendant::div[@class=\"fileChooser\"]/button[@class=\"add\"]") private WebElement eleBtnpopupAdd;
    @FindBy(xpath = "//footer/div[@class=\"actions\"]/button[@class=\"button-primary save\"]") private WebElement eleBtnUpload;
    @FindBy(xpath = "//div[@class=\"main\"]//div[@class=\"column middle box\"]/descendant::button[@class=\"newMessage conceal\"]") private WebElement eleBtnNewMsg;
    @FindBy(xpath = "//div[@class=\"formContainer\"]//li[@class=\"name\"]//input[@data-property=\"name\"]") private WebElement eleNewMsgName;
    @FindBy(xpath = "//footer/div/button[@class=\"button-primary save\"]") private WebElement eleBtnNxt;
    @FindBy(xpath = "//div[@class=\"templateFieldsForm\"]/descendant::footer/div/button[@class=\"button-primary save\"]") private WebElement eleBtnCreate;

    public Template(WebDriver driver){
        super();
    }

    public void clickTemplateMenu() throws Exception {
        leftNavMenu = new LeftNavMenu(driver);
        leftNavMenu.clickContentMenu();
        Assert.assertTrue(isDisplayed("Template"));
        clickElement(eleTemplateMenu, "Template menu");
    }

    public void openTemplate(String templateName) throws Exception {
        clickTemplateMenu();
        clickElement(driver.findElement(By.linkText(templateName)), "Open Template");
    }

    public void clickTemplateTabs() throws Exception {
        clickElement(elePropertiesTab, "Template Properties tab");
        clickElement(eleTemplateInfoTab, "Template Info tab");
        clickElement(eleTemplateAdminTab, "Template Administration tab");
        clickElement(eleTemplateHistoryTab, "Template History tab");
        clickElement(elePreviewTab, "Template Preview tab");
    }

    public boolean uploadTemplate(String templateName) throws Exception {
        clickTemplateMenu();
        clickElement(eleBtnNew, "Click New Button");
        clickElement(eleBtnpopupAdd, "Add button");


        StringSelection templatePath = new StringSelection("");
        String workingDir = System.getProperty("user.dir");
        String template = workingDir +"\\TestData\\" + templateName;
        templatePath = new StringSelection(template);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(templatePath, null);;
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
        clickElement(eleBtnUpload, "upload Media");

        Thread.sleep(4000);

        return isDisplayed(driver.findElement(By.linkText("AutoTemplate.scb")));

    }

    public boolean CreateMsgfromTemplateLanding(String templateName, String msgName){
        try{
            clickTemplateMenu();
            WebElement template = driver.findElement(By.linkText(templateName));
            template.findElement(By.xpath("..")).click();
            clickElement(eleBtnNewMsg, "new Message from Template landing");
            enterText(eleNewMsgName, msgName, "Enter a name for the new msg");
            clickElement(eleBtnNxt, "Click Next");
            clickElement(eleBtnCreate, "Click Create");
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean isNotDisplayed(String name) throws Exception {
        leftNavMenu = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "template":
                leftNavMenu.clickContentMenu();
                return isNotDisplayed(eleTemplateMenu);
            case "templateupload":
                clickTemplateMenu();
                return isNotDisplayed(eleBtnNew);
        }
        return false;
    }

    public boolean isDisplayed(String name) throws Exception {
        leftNavMenu = new LeftNavMenu(driver);
        switch(name.toLowerCase()){
            case "template":
                leftNavMenu.clickContentMenu();
                return isDisplayed(eleTemplateMenu);
            case "templateupload":
                clickTemplateMenu();
                return isDisplayed(eleBtnNew);
        }
        return false;
    }

}
