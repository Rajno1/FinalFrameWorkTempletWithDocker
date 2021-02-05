package com.issi.annotations;

import com.issi.enums.BrowserType;
import com.issi.enums.CategoryType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and
 * category details to the extent report.<p>
 *
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 *
 * @see com.issi.enums.CategoryType
 */

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE})
@Documented
public @interface FrameWorkAnnotation {
    /**
     * Store the authors who created the tests in String[]
     * Mandatory to enter at least a value
     *
     * @return author
     */
    public String[] author();  // if you don't give 'default' it will become like a 'mandatory' element/parameter
   // public String[] author() default {};
    /**
     * Stores the category in form of Enum Array. Include the possible values in {@link com.issi.enums.CategoryType}
     *
     * @return category
     */
    public CategoryType[] category();  //Here CategoryType is enum class name

    public BrowserType[] browser() default {}; //Here BrowserType is enum class name

 }
