package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void loadConfig(){
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/Config.properties");
            prop = new Properties();
            prop.load(fis);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String get(String key){
        return prop.getProperty(key);
    }
}
