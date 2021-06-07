package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagers {

    private WebDriver driver;

    private WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public WebDriver getDriver() {
        if(driver == null) {
            driver = createDriver();
        }
        return driver;
    }

}
