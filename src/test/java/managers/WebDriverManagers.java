package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ExternalConfiguration;

public class WebDriverManagers {

    ExternalConfiguration externalConfiguration;

    private WebDriver driver;

    private WebDriver createDriver() {
        externalConfiguration = new ExternalConfiguration();
        switch (externalConfiguration.getExternalProperty("browser")) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }

    public WebDriver getDriver() {
        if(driver == null) {
            driver = createDriver();
        }
        return driver;
    }

}
