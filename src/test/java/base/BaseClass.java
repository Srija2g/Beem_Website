package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;

    public static void initializeDriver(){
        prop = new Properties();
        try{
            FileInputStream file = new FileInputStream("src/main/resources/Config.properties");
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String browser = prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(prop.getProperty("baseURL"));
    }

    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }


}
