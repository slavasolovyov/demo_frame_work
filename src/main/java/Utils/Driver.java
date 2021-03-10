package Utils;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Driver {


    public static void initDriver() {

        // Get settings from command line

        TestConfig.initConfig();

        // Set settings for selenide browser

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;
        Configuration.timeout = 20000;
//        Configuration.reportsFolder = "target/";
//        ScreenShooter.captureSuccessfulTests = true;

        if(TestConfig.isHeadless()) {
            Configuration.headless = true;
        } else {
            Configuration.headless = false;
        }

        switch (TestConfig.browser)
        {
            case "chrome":
                Configuration.browser = Browsers.CHROME;
                break;
            case "firefox":
                Configuration.browser = Browsers.FIREFOX;
                break;
            default:
                Configuration.browser = Browsers.CHROME;
                break;
        }
    }

    public static WebDriver currentdriver(){
        return WebDriverRunner.getWebDriver();
    }

    public static void close(){
        currentdriver().close();
    }


    public static void wait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void deleteAllCookie(){
        currentdriver().manage().deleteAllCookies();
    }


}
