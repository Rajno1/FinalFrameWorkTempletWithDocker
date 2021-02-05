package com.issi.listeners;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.issi.annotations.FrameWorkAnnotation;
import com.issi.docker.DockerManager;
import com.issi.reports.EmailReport;
import com.issi.reports.ExtentLogger;
import com.issi.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

/**
 * Implements {@link org.testng.ITestListener} and {@link org.testng.ISuiteListener} to leverage the abstract methods
 * Mostly used to help in extent report generation
 */
public class listenerClass implements ITestListener, ISuiteListener {
    /**
     * onStart suite
     *
     * Initialise the reports with the file name
     * @param suite initiate Before suite task
     * @see com.issi.reports.ExtentReport
     */
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
       // DockerManager.startDockerGrid();
    }

    /**
     * onFinish suite
     *
     * Terminate the reports
     * @param suite will perform after suite task
     * @see com.issi.reports.ExtentReport
     */
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
       // EmailReport.mailTheReport();
        //DockerManager.stopDockerGrid();
    }

    /**
     * onTestStart
     *
     * Starts a test node for each testng test
     * @param result on test start
     * @see com.issi.reports.ExtentReport
     * @see com.issi.annotations.FrameWorkAnnotation
     */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createExtentTest(result.getMethod().getMethodName());          //creating node for extenttest and with reflection it will get method name automatically
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)
                .category());
        ExtentReport.addBrowser(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)
                .browser());

    }

    /**
     * onTestSuccess
     *
     * Marks the test as pass and logs it in the report
     * @param result on test success
     * @see com.issi.reports.ExtentLogger
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        //ExtentLogger.pass(MarkupHelper.createLabel(result.getMethod().getMethodName()+" is passed ",ExtentColor.GREEN),false);
       ExtentLogger.pass(result.getMethod().getMethodName() + " is passed ", false);
    }

    /**
     * onTestFailure
     *
     * Marks the test as fail ,append base64 screenshot and logs it in the report
     * @param result on test failure
     * @see com.issi.reports.ExtentLogger
     * @see com.issi.utils.ScreenshotUtils
     */
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " was failed miserably ",true);
        // if true screenshot will be attached
        ExtentLogger.fail(result.getThrowable().toString());
      //  ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    /**
     * Marks the test as skip and logs it in the report
     * @see com.issi.reports.ExtentLogger
     * @param result on test skip
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped ",false);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        /*

         */
    }

    @Override
    public void onStart(ITestContext context) {

        /*
        We are having just one test in our suite. So we dont have any special implementation as of now
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
        We are having just one test in our suite. So we dont have any special implementation as of now
         */
    }
}
