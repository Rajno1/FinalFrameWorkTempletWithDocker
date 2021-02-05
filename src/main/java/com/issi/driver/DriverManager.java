package com.issi.driver;

import org.openqa.selenium.WebDriver;

/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 */
public final class DriverManager {
    /**
     * Private constructor to avoid external instantiation
     */
    private DriverManager() {
    }

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    /**
     *  Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
     *
     * @return {@link org.openqa.selenium.WebDriver} instance
     */
    public static WebDriver getDriver() {
        return dr.get();
    }

    /**
     * Set the WebDriver instance to thread local variable
     *
     * @param driverref {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p>
     * 	TODO Disallow null assignment and call unload method instead. public access modifier can be changed to
     * 	 default
     */
    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    /**
     * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
     *  It is much safer than assigning null value to ThreadLocal variable.
     *
     * TODO public access modifier can be changed to
	 * default
     */
    public static void unload(){
        dr.remove();
    }

}
