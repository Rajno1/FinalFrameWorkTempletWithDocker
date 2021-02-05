package com.issi.tests;

import com.issi.docker.DockerManager;
import com.issi.driver.Driver;
import com.issi.enums.ConfigProperties;
import com.issi.utils.PropertyUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Map;

/**
 * Acts as a parent class for all the test classes in this framework.
 * All the test classes needs to extend this class. This class is responsible for invoking and terminating
 * browser under test.
 */
public class BaseTest {
    protected BaseTest() {
    }

    /**
     * Invokes a new browser instance and loads the respective URL.
     *
     * @param data Have all the data feeded to the corresponding test method from data provider.In our case,it is
     * a hashmap containing all the values from the excel sheet.
     */

    @BeforeMethod
    protected void setUp() {
        Driver.initDriver(PropertyUtils.getValue(ConfigProperties.BROWSER));
        LoginPageTest.loginTest();
    }

    /**
     * Terminates the browser instance
     *
     */
    @AfterMethod
    protected void tearDown() {
        LoginPageTest.logoutTest();
        Driver.quiteDriver();
    }


}
