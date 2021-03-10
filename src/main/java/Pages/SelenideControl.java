package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;

public class SelenideControl {

    protected void openUrl(String url){
        Selenide.open(url);
    }

    protected String getText(SelenideElement locator){
        return locator.getText();
    }

    protected SelenideElement selSendKeysText(SelenideElement locator, String value){
        locator.waitUntil(visible, 20000);
        locator.setValue(value);
        return locator.shouldHave(exactText(value));
    }

    protected SelenideElement selSendKeysValue(SelenideElement locator, String value){
        locator.waitUntil(visible, 20000);
        locator.setValue(value);
        return locator.shouldHave(exactValue(value));
    }

    protected void selClick(SelenideElement locator){
        locator.waitUntil(visible, 20000);
        locator.click();
    }

    protected void selClear(SelenideElement locator){
        locator.waitUntil(visible, 20000);
        locator.clear();
    }

    protected void selHover(SelenideElement locator){
        locator.hover();
    }

    protected boolean selIsDisplayed(SelenideElement locator){
        return locator.isDisplayed();
    }

    protected SelenideElement selWaitUntil(SelenideElement locator){
        return locator.waitUntil(visible, 20000);
    }

    protected void refresh(){
        Selenide.refresh();
    }

    protected WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    protected void waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), 20);
        wait.until(ExpectedConditions.urlContains(urlChunk));
    }
}
