package com.issi.listeners;

import com.issi.enums.ConfigProperties;
import com.issi.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * <p> Implements {@link IRetryAnalyzer}.
 * <p> Helps in rerunning the failed tests.
 */
public class RetryFailedTests implements IRetryAnalyzer {

    private int count =0;
    private int maxretries =1;

    /**
     * Return true when needs to be retried and false otherwise.
     * Maximum will retry for one time.
     * Retry will happen if user desires to and set the value in the property file
     */
    @Override
    public boolean retry(ITestResult result) {
        boolean value=false;
        if(PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("Yes")) {
             value = count < maxretries;
            count++;
        }
        return value;
    }
}
