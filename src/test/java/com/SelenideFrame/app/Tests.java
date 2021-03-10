package com.SelenideFrame.app;
import Listener.ScreenShot;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenShot.class})
public class Tests extends BaseTest{

    @Test(description = "Get report")
    @Issue("123")
    @Severity(SeverityLevel.CRITICAL)
    public void baseTest(){
        app.navigation.navigateToApp();
        app.loginProcessor.loginAtlassian(reader.getAtlassianLogin(),reader.getOctaLogin(),reader.getOctaPassword()
                ,reader.getOctaSecret());
        app.navigation.navigateToJira();
        app.navigation.navigateDashboard(reader.getDashboardName());
        app.reportCollector.getReport();
//        screenshot("my_file_name");

    }

}
