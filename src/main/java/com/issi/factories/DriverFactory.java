package com.issi.factories;

import com.issi.driver.DriverManager;
import com.issi.enums.ConfigProperties;
import com.issi.reports.ExtentLogger;
import com.issi.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;
        String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME);
                //cap.setPlatform(Platform.MAC); // it will run on MAC platform
              //  cap.setPlatform(Platform.LINUX); // it will run on LINUX platfrom
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                // WebDriverManager.chromedriver().clearResolutionCache().setup()
            }

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.FIREFOX);
               // cap.setPlatform(Platform.valueOf("MAC")); // it will run on MAC platform
                //  cap.setPlatform(Platform.LINUX); // it will run on LINUX platfrom
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(options);
                // WebDriverManager.chromedriver().clearResolutionCache().setup()
            }
        } else if (browser.equalsIgnoreCase("ie")) {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            ieOptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.IE);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

            } else {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(ieOptions);
                // WebDriverManager.chromedriver().clearResolutionCache().setup()
            }
        }
        return driver;
    }
}
