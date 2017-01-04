package com.scala.qa.contentmanager.Base;

/**
 * Created by kpatel on 11/18/2016.
 */

import com.scala.qa.contentmanager.Utilities.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class PageBase {

    protected static WebDriver driver;
    private static final long default_timeoutInSeconds = 30;

    @FindBy(id = "search") private WebElement eleSearchField;


    Utilities util = new Utilities();

    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PageBase(){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterURL(String URL) throws Exception{
        try{
            driver.get(URL);
        }catch (Exception e){
            util.captureScreenshot(driver, URL);
        }
    }

    public void enterText(WebElement element, String value, String elementName) throws Exception {

        try {
            WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            element.clear();
            element.sendKeys(value);
        } catch (Exception exc) {
            util.captureScreenshot(driver, elementName);
        }
    }

    public void clickButton(WebElement element, String elementName) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception exc) {
            exc.printStackTrace();
            util.captureScreenshot(driver, elementName);
        }
    }


    public void waitForPagetoLoad(){
        WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("main")));
    }

    public boolean clickElement(WebElement element, String elementName) throws Exception{
        try{
//            if(isDisplayed(element)) {
                WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                Thread.sleep(1500);
                waitForPagetoLoad();
 //               return true;
//            }
            return false;
        }catch (NoSuchElementException exc){
            exc.printStackTrace();
            util.captureScreenshot(driver, elementName);
            return false;
        }
    }


    public boolean isNotDisplayed(WebElement element){
        try{
            waitForPagetoLoad();
            Assert.assertEquals(element.getSize(), 0);
            return true;
        }catch(AssertionError e) { return false; }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            waitForPagetoLoad();
            Assert.assertEquals(element.getSize(), 0);
            return false;
        } catch (AssertionError e) { return true; }
    }

    public void pickItem(String path, String ItemName){
        List<WebElement> mediaList= driver.findElements(By.xpath(path));
        for(int idx=0 ; idx <= mediaList.size()-1; idx++) {
            if (mediaList.get(idx).getText().contains(ItemName)) {
                mediaList.get(idx).click();
                break;
            }
        }
    }




/* ================= Methods Not Used ==========================
    public void search(String element, String elementName) throws Exception{
        enterText(eleSearchField, element, elementName);
        eleSearchField.sendKeys(Keys.RETURN);
        eleSearchField.sendKeys(Keys.F5);
        Thread.sleep(500);
    }

    public void clickTab(WebElement element, String elementName) throws Exception{
        try{
            WebDriverWait wait = new WebDriverWait(driver, default_timeoutInSeconds, 500);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }catch (Exception exc){
            exc.printSt/ackTrace();
            util.captureScreenshot(driver, elementName);
        }
    }
*/


}
