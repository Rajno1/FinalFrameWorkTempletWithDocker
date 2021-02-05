package com.issi.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.issi.constants.FrameWorkConstants;
import com.issi.enums.BrowserType;
import com.issi.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal
 * variable for providing thread safety.
 *
 * @see com.issi.listeners.listenerClass
 * @see com.issi.annotations.FrameWorkAnnotation
 */
public final class ExtentReport {
    private static ExtentReports extent;
    private static ExtentSparkReporter spark;

    /**
     * Private constructor to avoid external instantiation
     */
    private  ExtentReport() {
    }

    /**
     * Set the initial configuration for the Extent Reports and decides the report generation path.
     */
    public static void initReport(){
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath()).viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.TEST,
                            ViewName.LOG,
                            ViewName.EXCEPTION,
                            ViewName.DEVICE,
                            ViewName.AUTHOR,
                            ViewName.CATEGORY,
                            ViewName.DASHBOARD
                    })
                    .apply();
            try {
                spark.loadXMLConfig(new File(FrameWorkConstants.getSparkConfigFilePath())); // configured 'spark-config.xml' file
            } catch (IOException e) {
                e.printStackTrace();
            }
            extent.setSystemInfo("os", "Window10");
            extent.attachReporter(spark);
        }
    }

    /**
     * Flushing the reports ensures extent logs are reflected properly.
     * Opens the report in the default desktop browser.
     * Sets the ThreadLocal variable to default value
     */
    public static void flushReports(){
        if (Objects.nonNull(extent)) {
            try {
                extent.flush();
                ExtentManager.unload();
                Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
                //  SendEmailWithAttachment.mailTheReport();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
     *
     * @param testcasename Test Name that needs to be reflected in the report
     */
    public static void createExtentTest(String testcasename){
        ExtentTest test = extent.createTest(testcasename, "Started working on " + testcasename + "");
       ExtentManager.setExtentTest(test);
    }

    /**
     * Logs the authors details in the authors view in the extent report.
     * Gives an clear idea of Authors Vs Percentage success metrics
     *
     * @param authors Authors who created a particular test case
     */
    public static void addAuthors(String [] authors){
        for (String tempA: authors){
            ExtentManager.getExtentTest().assignAuthor(tempA);
        }
    }

    /**
     * Adds the category a particular test case belongs to.
     * Gives an clear idea of Group Vs Percentage success metrics.
     *
     * @param categories category a particular test case belongs to.
     */
    public static void addCategories(CategoryType[] categories){
        for (CategoryType tempC: categories){
            ExtentManager.getExtentTest().assignCategory(tempC.toString());
        }
    }

    public static void addBrowser(BrowserType[] browser){
        for (BrowserType tempB: browser){
            ExtentManager.getExtentTest().assignDevice(tempB.toString());
        }
    }
}
