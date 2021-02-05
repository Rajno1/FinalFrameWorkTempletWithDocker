package com.issi.listeners;

import com.issi.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements {@link org.testng.IAnnotationTransformer} to leverage certain functionality like updating the annotations of test
 * methods at runtime.
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * Helps in setting the dataprovider, dataprovider class and retry analyser annotation to all the test methods
     * at run time.
     * This Annotation Transformer will be called each time when your test method is called
     */

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderUtils.class);
      //  annotation.setRetryAnalyzer(RetryFailedTests.class);  // to retry failed tests

    }
}
