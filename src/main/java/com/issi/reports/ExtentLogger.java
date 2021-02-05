package com.issi.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.issi.enums.ConfigProperties;
import com.issi.utils.PropertyUtils;
import com.issi.utils.ScreenshotUtils;

/**
 * Used for logging the events in the extent report.
 * <p>
 * Encapsulates the unnecessary methods from users
 * @see ExtentReport
 * @see ExtentManager
 */
public final class ExtentLogger {
    /**
     * Private constructor to avoid external instantiation
     */
    private ExtentLogger() {
    }

    /**
     * Logs pass event in the extent report
     *
     * @param message custom message that needs to be logged
     */
    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }


    /**
     * Logs fail event in the extent report
     *
     * @param message custom message that needs to be logged
     */
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }

    /**
     * Logs skip event in the extent report
     *
     * @param message custom message that needs to be logged
     */
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }


    /**
     * Logs pass event in the extent report based on user input in property file
     *
     * @param message custom message that needs to be logged
     * @param isScreenshotneeded appends screenshot when true ,ignore otherwise
     */
    public static void pass(String message, boolean isScreenshotneeded){
        if (PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
        && isScreenshotneeded){
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
           // pass(message);
            ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message,ExtentColor.GREEN));
        }
    }

    /**
     * Logs fail event in the extent report based on user input in property file
     *
     * @param message custom message that needs to be logged
     * @param isScreenshotneeded appends screenshot when true ,ignore otherwise
     */
    public static void fail(String message,boolean isScreenshotneeded){
        if (PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotneeded){
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
           // fail(message);
            ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message,ExtentColor.RED));
        }
    }
    /**
     * Logs skip event in the extent report based on user input in property file
     *
     * @param message custom message that needs to be logged
     * @param isScreenshotneeded appends screenshot when true ,ignore otherwise
     */

    public static void skip(String message,boolean isScreenshotneeded){
        if (PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotneeded){
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
           // skip(message);
            ExtentManager.getExtentTest().skip(MarkupHelper.createLabel(message,ExtentColor.AMBER));
        }
    }

}
