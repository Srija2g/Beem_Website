package pages;

import base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Utils;

public class LoginPage extends BaseClass {
    WebDriver driver;
    private Utils utils;

    By loginBtn = By.xpath("//span[text()= 'Sign Up or Log In']");
    By helloText = By.xpath("//h2[text()= 'Hello']");
    By phoneFieldHelloPage = By.xpath("//input[@id = 'phone']");
    By sendVerificationCode = By.xpath("//span[text() = 'Send verification code']");
    By enterCredentialsErrorMessage = By.xpath("//div[text() =\"Hmm, something doesn't seem right. We'll work on this, check back later.\"]");
    By enterSecreteCodeHeading = By.xpath("//h2[text()= 'Enter the s*cr*t code']");
    By codeDigit2 = By.xpath("//input[@aria-label = 'Digit 2']");
    By codeDigit1 = By.xpath("//input[@aria-label = 'Please enter verification code. Digit 1']");
    By codeDigit3 = By.xpath("//input[@aria-label = 'Digit 3']");
    By codeDigit4 = By.xpath("//input[@aria-label = 'Digit 4']");
    By welcomeBackHomeScreen = By.xpath("//p[text() = 'Welcome back']");
    By helloUserHomeScreen = By.xpath("//h2[starts-with(text(), 'Hello,')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    public void loginButtonClickable(){
        utils.click(loginBtn);
        utils.waitForVisible(helloText);
        System.out.println("Redirecting to correct page");

    }

    public void loginWithoutCredentials(){
        utils.click(loginBtn);
        utils.waitForVisible(helloText);
        driver.findElement(sendVerificationCode).click();
        WebElement errorMessage = utils.waitForVisible(enterCredentialsErrorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void loginWithValidCredentials(){
        utils.click(loginBtn);
        utils.waitForVisible(helloText);
        utils.type(phoneFieldHelloPage, ConfigReader.get("phoneNumber"));
        utils.click(sendVerificationCode);
        utils.waitForVisible(enterSecreteCodeHeading);

        utils.type(codeDigit1, ConfigReader.get("digit_1"));
        utils.type(codeDigit2, ConfigReader.get("digit_2"));
        utils.type(codeDigit3, ConfigReader.get("digit_3"));
        utils.type(codeDigit4, ConfigReader.get("digit_4"));

        WebElement welcomeBack = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBackHomeScreen));
        Assert.assertTrue(welcomeBack.isDisplayed());


    }

}
