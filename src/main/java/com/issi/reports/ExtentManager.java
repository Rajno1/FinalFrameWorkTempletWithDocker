package com.issi.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 *
 * @see com.issi.driver.Driver
 */
public final class ExtentManager {
    /**
     * Private constructor to avoid external instantiation
     */
    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    /**
     * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
     *
     * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
     */
    static ExtentTest getExtentTest()  { //default --> it can be accessed with in the package
        return extTest.get();
    }

    /**
     * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
     *
     * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
     * TODO Disallow null assignment and call unload method instead.
     */
    static void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

    /**
     * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
     * It is much safer than assigning null value to ThreadLocal variable.
     */
    public static void unload() {
        extTest.remove();
    }

}
