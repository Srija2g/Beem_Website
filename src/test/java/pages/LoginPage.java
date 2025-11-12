package pages;

import base.BaseClass;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseClass {
    WebDriver driver;

    By LoginBtn = By.xpath("//span[text()= 'Sign Up or Log In']");
    By helloText = By.xpath("//h2[text()= 'Hello']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginButtonClickable(){
       // driver.findElement(LoginBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(helloText));
        System.out.println("Redirecting to correct page");

    }

}
