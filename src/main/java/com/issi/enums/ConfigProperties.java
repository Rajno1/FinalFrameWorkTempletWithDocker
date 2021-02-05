package com.issi.enums;

/**
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 *
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.
 * @see com.issi.utils.PropertyUtils
 */
public enum ConfigProperties  {
    BROWSER,
    URL,
    USERNAME,
    PASSWORD,
    OVERRIDEREPORTS,
    PASSEDSTEPSCREENSHOT,
    FAILEDSTEPSCREENSHOT,
    SKIPPEDSTEPSCREENSHOT,
    RUNMODE,
    RETRYFAILEDTESTS
}
