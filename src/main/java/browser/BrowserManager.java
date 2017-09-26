package browser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * Created by death on 7/8/2017.
 */
public class BrowserManager {
    public WebDriver startDriver() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("core/chromedriver.exe").getFile());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
