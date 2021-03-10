package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends SelenideControl{

    private SelenideElement loginField = $("#username");
    private SelenideElement submitButton = $("#login-submit");
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

    public void loginAtlassian(String atlassianLogin, String login, String pass, String secret){
        selSendKeysValue(loginField, atlassianLogin);
        selClick(submitButton);
        waitForUrlContains("https://modeln.okta.com/login/login.htm?");
        selSendKeysValue(octaLogin, login);
        selSendKeysValue(octaPass, pass);
        selClick(octaSubmit);
        selSendKeysValue(octaQuest, secret);
        selClick(octaVerify);
        waitForUrlContains("https://start.atlassian.com/");
    }
    public void logout(){
        selClick(appSwitch);
        selClick(linkToAtlassian);
        selClick(userDropdownIcon);
        selClick(logoutDropdownButton);
        selClick(logoutbutton);
        selWaitUntil(loginField);
    }

}
