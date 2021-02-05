package com.issi.utils;

import com.issi.constants.FrameWorkConstants;
import com.issi.enums.ConfigProperties;
import com.issi.exceptions.ReadPropertyFileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * Users can prefer to use json instead of property file based on their requirement.
 */
public final class PropertyUtils {

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    /**
     * Private constructor to avoid external instantiation
     */
    private PropertyUtils() {
    }

    static {
        // Here we are fetching all the values from property file
        try (FileInputStream file = new FileInputStream(FrameWorkConstants.getConfigFilePath())){
            property.load(file);
            for (Map.Entry<Object,Object> entry: property.entrySet()){  // we are iterating property file
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
                // in above line we are adding property file to the HashMap at line num 18 and for value we are avoiding white spaces using 'trim()'
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // it will terminate the program gracefully in satic block if exception raised
        }
    }

    /**
     * Receives the {@link com.issi.enums.ConfigProperties},converts to lowercase , return the corresponding value
     * for the key from the HashMap
     *
     * @param key To be fetched from property file
     * @return corresponding value for the requested key if found else {@link com.issi.exceptions.ReadPropertyFileException}
     */

    public static String getValue(ConfigProperties key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
                throw new ReadPropertyFileException("Property name '" + key + "' is not found,please check config.property file");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

   }
