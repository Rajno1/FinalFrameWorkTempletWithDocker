package com.issi.constants;

import com.issi.enums.ConfigProperties;
import com.issi.utils.PropertyUtils;

/**
 * Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files
 *
 * @see com.issi.utils.PropertyUtils
 */
public final class FrameWorkConstants {
    /**
     * Private constructor to avoid external instantiation
     */
    private FrameWorkConstants() {
    }

    private static final String MAINRESOURCEPATH = System.getProperty("user.dir") + "/src/main/resources";
    private static final String TESTRESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CONFIGFILEPATH = TESTRESOURCESPATH + "/config/config.properties";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/Extent-test-output/";
    private static final String RUNMANAGERSHEET = "RunManager";
    private static final String ITERATIONDATASHEET = "DATA";
    private static final String EXCELPATH = TESTRESOURCESPATH + "/TestData/testdata.xlsx";
    private static final String TESTFAILUREREPORTPATH = System.getProperty("user.dir") + "/Extent-test-output/failure_index.html";
    private static final String SPARKCONFIGFILEPATH = MAINRESOURCEPATH + "/spark-config.xml";
    private static final int EXPLICITWAIT = 10;


    /**
     * getRunMangerSheet
     * @return Runmanger sheet name from excel
     */
    public static String getRunManagerSheet() {
        return RUNMANAGERSHEET;
    }

    /**
     * getIterationdataSheet
     * @return data sheet name from excel
     */
    public static String getIterationDataSheet() {
        return ITERATIONDATASHEET;
    }

    /**
     * Empty extent report file path
     */
    private static String extentReportFilePath = "";


    /**
     * getExtentReportFile Path
     * @return Extent Report path where the index.html file will be generated.
     */
    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    /**
     * createReportPath
     * @return If Override reports value in the property file is no,then the timestamp will be appended
     */
    private static String createReportPath() {
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "index.html";
        }
    }

    /**
     * getTestFailurePath
     * @return  failure Extent Report path where the failureindex.html file will be generated.
     */
    public static String getTestFailurePath() {
        return TESTFAILUREREPORTPATH;
    }

    /**
     * getSparkConfigFilePath
     * @return spark config file path where the spark-config.xml is present in the framework
     */
    public static String getSparkConfigFilePath() {
        return SPARKCONFIGFILEPATH;
    }

    /**
     * getConfigFilePath
     * @return config.property file path present in the framework
     */
    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    /**
     * getExplicitwait
     * @return explicit wait time
     */
    public static int getEXPLICITWAIT() {
        return EXPLICITWAIT;
    }

    /**
     * getExcelPath
     * @return excel file path
     */
    public static String getExcelPath() {
        return EXCELPATH;
    }

}
