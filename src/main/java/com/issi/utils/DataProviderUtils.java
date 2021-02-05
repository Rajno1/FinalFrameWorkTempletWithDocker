package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Holds the data provider for all the test cases in the framework.
 */
public final class DataProviderUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private DataProviderUtils() {
    }

    private static List<Map<String,String>> list = new ArrayList<>();

    /**
     * Acts as a data provider for all the test cases.
     * Parallel=true indicates that each of the iteration will be ran in parallel.
     *
     * @param method {@link java.lang.reflect.Method} holds the information about the testcases at runtime
     * @return Object[] containing the List. Each index of the list contains HashMap and each of them
     * contains the test data needed to run the iterations.
     *
     *
     * @see com.issi.listeners.AnnotationTransformer
     */
    @DataProvider(parallel = false)
    public static Object[] getData(Method method){
        String testname = method.getName(); // this will give me the method name , which is calling this dataprovider
        if (list.isEmpty()){
            list= ExcelUtils.getTestDetails(FrameWorkConstants.getIterationDataSheet());
        }

        List<Map<String,String>> smallList = new ArrayList<>(); // this will have only details about test method that is calling this dataprovider

        for (int i=0;i<list.size();i++){
            if (list.get(i).get("testname").equalsIgnoreCase(testname) &&
                list.get(i).get("execute").equalsIgnoreCase("yes")){
                    smallList.add(list.get(i)); //if it satisfy above two condition then we are adding Map here.
                }
            }
        return smallList.toArray(); // converting list to object array
    }
}
