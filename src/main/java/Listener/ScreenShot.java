package Listener;


import Utils.Driver;
import Utils.Log;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.screenshot;

public class ScreenShot implements ITestListener {
    private static final Path path = Paths.get("C:\\Users\\vsolovyev\\Projects\\Test-frame\\target\\allure-result");
    Log logger = new Log();

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        getScreenshot();
        writeScreenshotToFile((TakesScreenshot) Driver.currentdriver(),path);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
//        getSceenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
    @Attachment(value = "Page screenshot" , type = "image/png")
    private byte[] writeScreenshotToFile(TakesScreenshot driver, Path screenshot) {
        try (OutputStream screenshotStream = Files.newOutputStream(screenshot)) {
            byte[] bytes = driver.getScreenshotAs(OutputType.BYTES);
            screenshotStream.write(bytes);
            screenshotStream.close();
            return bytes;
        } catch (IOException e) {
            logger.info("Unable to write " + screenshot);
        } catch (WebDriverException e) {
            logger.info("Unable to take screenshot.");
        }
        return null;
    }
}
