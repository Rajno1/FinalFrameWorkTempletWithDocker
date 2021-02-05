package com.issi.driver;

import com.issi.annotations.FrameWorkAnnotation;
import com.issi.constants.FrameWorkConstants;
import com.issi.enums.CategoryType;
import com.issi.enums.ConfigProperties;
import com.issi.exceptions.BrowserInvokationFailedException;
import com.issi.factories.DriverFactory;
import com.issi.reports.ExtentLogger;
import com.issi.reports.ExtentReport;
import com.issi.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static com.issi.reports.ExtentLogger.pass;


/**
 *
 * Driver class is responsible for invoking and closing the browsers.
 * <p>
 *It is also responsible for setting the driver variable to DriverManager, which handles the thread safety for the webdriver instance.
 *
 * @see DriverManager
 * @see com.issi.tests.BaseTest
 */
public final class Driver {
    /*
     *  private constructor to avoid external instantiation
     */
    private Driver() {
    }

    /**
     *Gets the browser value and initialise the browser based on that
     *
     * @param browser - browser value will be passed form {@link com.issi.tests.BaseTest}. Values can be chrome,firefox
     */
    public static void initDriver(String browser) {
        ExtentReport.createExtentTest("Driver initiate");
        if (Objects.isNull(DriverManager.getDriver())) {
            final String DRIVERLAUNCHMESSAGE = "" + browser + " driver was started successfully";
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser)); //  if it is local you can invoke the browser in this way
                pass(DRIVERLAUNCHMESSAGE);
            } catch (MalformedURLException e) {
            throw new BrowserInvokationFailedException("Browser Invocation was failed");
            }
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
            ExtentLogger.pass("Entered url as : " + PropertyUtils.getValue(ConfigProperties.URL));
        }

    }

    /**
     *
     */
    /**
     * Terminates the browser instance. Sets the threadlocal to default value, i.e null.
     *
     */
    public static void quiteDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            ExtentLogger.pass(" " + PropertyUtils.getValue(ConfigProperties.BROWSER) + " driver was closed");
            DriverManager.unload();
        }

    }
}
