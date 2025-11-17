package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void initializeDriver(){
        ConfigReader.loadConfig();
        String browser = ConfigReader.get("browser");
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(ConfigReader.get("baseURL"));
    }

    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }


}
