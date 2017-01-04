package com.scala.qa.contentmanager.Tests.SmokeTestSuite;

import com.scala.qa.contentmanager.Base.PageBase;
import com.scala.qa.contentmanager.Base.TestBaseSetup;
import com.scala.qa.contentmanager.PageObjects.Content.Media;
import com.scala.qa.contentmanager.PageObjects.Content.Template;
import com.scala.qa.contentmanager.PageObjects.LeftNavMenu;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by kpatel on 11/29/2016.
 */
public class test_ContentTemplate extends TestBaseSetup{
    private Template template;

    @BeforeTest
    public void testSetup() {
        PageBase basePage = new PageBase(getDriver());
        template = new Template(getDriver());
    }


    @Test(description = "Opens a template and its tabs")
    public void test_OpenTemplate() throws Exception {
        System.out.println("Open Template test...");
        template.clickTemplateMenu();
        template.openTemplate("AutoTemplate.scz");
        template.clickTemplateTabs();
    }
}

