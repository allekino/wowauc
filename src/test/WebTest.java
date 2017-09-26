import browser.BrowserManager;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by death on 7/9/2017.
 */
public class WebTest {

    String item;
    String url = "https://eu.battle.net/wow/en/vault/character/auction/browse?n=&filterId=5%2C122&minLvl=-1&maxLvl=-1&qual=1&start=0&end=20&sort=bid&reverse=false";
    String url2 = "https://eu.battle.net/wow/en/vault/character/auction/browse?n=" + item + "&filterId=5%2C122&minLvl=-1&maxLvl=-1&qual=1&start=0&end=20&sort=bid&reverse=false";

    @Test
    public void web() {
        WebDriver driver = new BrowserManager().startDriver();
        WebDriverRunner.setWebDriver(driver);
        open(url);
        Set<Cookie> cookieSet = driver.manage().getCookies();
        login();


    }

    private void login() {
    }
}
