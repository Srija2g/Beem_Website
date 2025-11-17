package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    private WebDriver driver;
    private WebDriverWait wait;

    public Utils(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        waitForVisible(locator).click();
    }

    public void type(By locator, String text){
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }


}
