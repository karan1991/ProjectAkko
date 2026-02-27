package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By phoneInput = By.xpath("//*[@resource-id='phoneInput']");
    private By passwordInput = By.xpath("//*[@resource-id='passwordInput']");
    private By loginButton = By.xpath("//*[@resource-id='loginButton']");
    private By getStartedButton = By.xpath("//*[@content-desc='Get Started']");
    private By dontAllowButton = By.xpath("//*[@text=\"DON'T ALLOW\"]");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitForLoginScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
    }

    private void type(By locator, String text) {
        var element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        element.clear();
        element.sendKeys(text);
        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {}
    }

    public void enterPhone(String phone) {
        type(phoneInput, phone);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getStartedButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void handleBiometricPopupIfPresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(dontAllowButton)).click();
            System.out.println("Biometric popup dismissed.");
        } catch (Exception e) {
            System.out.println("No biometric popup appeared.");
        }
    }

    public void login(String phone, String password) {
        waitForLoginScreen();
        enterPhone(phone);
        enterPassword(password);
        clickLoginButton();
        handleBiometricPopupIfPresent();
        Assert.assertTrue(isLoginSuccessful(), "Login failed!");
    }
}