package com.issi.tests;

import com.issi.annotations.FrameWorkAnnotation;
import com.issi.enums.BrowserType;
import com.issi.enums.CategoryType;
import com.issi.enums.ConfigProperties;
import com.issi.pages.PSMSHomePage;
import com.issi.pages.PSMSLoginPage;
import com.issi.reports.ExtentReport;
import com.issi.utils.PropertyUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Contains the tests related to PSMS Login page.
 */
public final class LoginPageTest extends BaseTest {
    /**
     * Private constructor to avoid external instantiation
     */
    private LoginPageTest() {
    }

    /**
     * Test Name mentioned here should match the column name "testname" in excel sheet.This is mandatory to run this
     * test. Otherwise it will be ignored.
     * The match has to be there in both of the RUNMANAGER and TESTDATA sheet
     * Set the authors who have the created the test which will be logged to the reports
     * Set the category which this particular test case belongs to
     *
     */
    @Test
    @FrameWorkAnnotation(browser = {BrowserType.CHROME},author = {"Rajasekhar"},category = {CategoryType.FUNCTIONAL})
    public static void loginTest() {
        ExtentReport.createExtentTest("Login test");
        String title = new PSMSLoginPage()
                .enterUserName(PropertyUtils.getValue(ConfigProperties.USERNAME))
                .enterPassword(PropertyUtils.getValue(ConfigProperties.PASSWORD))
                .clickLogin()
                .getPage_Title();

        Assertions.assertThat(title)
                .isEqualTo("PSMS");
    }

    @Test
    @FrameWorkAnnotation(browser = {BrowserType.CHROME},author = {"Rajasekhar"},category = {CategoryType.FUNCTIONAL})
    public static void logoutTest() {
        ExtentReport.createExtentTest("Logout test");
        String title = new PSMSHomePage()
                .cickUserActions()
                .clickLogOut()
                .getPage_Title();

        Assertions.assertThat(title)
                .isEqualTo("PSMS");
    }
}
