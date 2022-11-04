package TestBase;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    Properties properties;
    public WebDriver driver;

    public WebDriver initializeDriver(){

        try {
            FileInputStream fileInputStream = new FileInputStream(".\\TestData\\config.properties");
            Assert.notNull(fileInputStream, "config file is not loaded");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Exception =" + e.getMessage());
        }
        try {
            String url = properties.getProperty("URL");
            Assert.notNull(url, "url is not loaded");
            String browser = properties.getProperty("Browser");
            switch (browser) {

                case "CHROME":
                    ChromeOptions options = new ChromeOptions();
                    System.out.println(options);
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    options.merge(capabilities);
                    //options.setCapability("browserName", "chrome");
                    //options.setCapability("platformName", "Windows 10");
                    options.addArguments("start-maximized");
                    //options.addArguments("incognito");
                    //options.addArguments("headless");
                    options.addArguments("disable-extensions");
                    options.addArguments("disable-notifications");
                    options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automaton"));
                    capabilities.setAcceptInsecureCerts(true);
                    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                    if (driver==null) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(options);
                        // WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.38:4444"),options);
                        driver.get(url);
                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        return driver;
                    }

            }

        } catch (Exception e) {
            System.out.println("Exception =" + e.getMessage());
        }
    return driver;
    }
}
