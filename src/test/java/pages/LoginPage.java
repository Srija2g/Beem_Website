package pages;

import base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseClass {
    WebDriver driver;

    By loginBtn = By.xpath("//span[text()= 'Sign Up or Log In']");
    By helloText = By.xpath("//h2[text()= 'Hello']");
    By phoneFieldHelloPage = By.xpath("//input[@id = 'phone']");
    By sendVerificationCode = By.xpath("//span[text() = 'Send verification code']");
    By enterCredentialsErrorMessage = By.xpath("//div[text() =\"Hmm, something doesn't seem right. We'll work on this, check back later.\"]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginButtonClickable(){
       // driver.findElement(LoginBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(helloText));
        System.out.println("Redirecting to correct page");

    }

    public void loginWithoutCredentials() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(helloText));
        driver.findElement(sendVerificationCode).click();
     //   Thread.sleep(5000);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(enterCredentialsErrorMessage));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

}
