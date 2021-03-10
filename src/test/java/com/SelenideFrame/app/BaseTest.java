package com.SelenideFrame.app;

import app.App;
import Utils.*;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected App app;
    protected ProperiesReader reader;
    protected Log log;

    @BeforeClass
    public void setUp(){
        Driver.initDriver();
        app = new App();
        reader = new ProperiesReader();
        log = new Log();

    }
    @AfterClass
    public void tearDown(){
        Driver.close();
    }
}
