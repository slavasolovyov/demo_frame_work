package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


import static com.codeborne.selenide.Selenide.*;

public class Navigation extends SelenideControl{

    private SelenideElement loginField = $("#username");
    private SelenideElement submitButton = $("#login-submit");
    private SelenideElement jiraButton = $x("//*[text()='Jira Software']");
    private SelenideElement appSwitch = $x("//span[@aria-label='Appswitcher Icon']");
    private SelenideElement linkToAtlassian = $x("//*[@data-testid='section-title__link']");
    private SelenideElement userDropdownIcon = $x("//*[@data-testid='nav__profile-menu-trigger']");
    private SelenideElement logoutDropdownButton = $x("//span[text()='Log out']");
    private SelenideElement logoutbutton = $("#logout-submit");
    private SelenideElement octaLogin = $("#okta-signin-username");
    private SelenideElement octaPass = $("#okta-signin-password");
    private SelenideElement octaSubmit = $("#okta-signin-submit");
    private SelenideElement octaQuest = $(".password-with-toggle");
    private SelenideElement octaVerify = $(".button-primary");
    private SelenideElement jiraNavigationPanDashboard = $x("//span[text()='Dashboards']");
    private SelenideElement dashboardButton = $x("//*[text()='Dashboards']");
    private ElementsCollection listOfDashboards = $$x("//a[contains(@href,'https://revvy-modeln.atlassian." +
            "net/secure/Dashboard.jspa?selectPageId=')]");


    public void navigateToApp(){
        openUrl("https://id.atlassian.com/login");
    }

    public void navigateToJira(){
        selClick(jiraButton);
        waitForUrlContains("https://revvy-modeln.atlassian.net/secure/BrowseProjects.jspa?=&selectedProjectType=software");
        selWaitUntil(jiraNavigationPanDashboard);
    }

    public void navigateDashboard(String dashboardName){
        selClick(dashboardButton);
        List<WebElement> list = new ArrayList<>(listOfDashboards);
        for (WebElement element: list){
            if (element.getText().equals(dashboardName)){
                selClick((SelenideElement)element);
                break;
            }
        }
    }

}

