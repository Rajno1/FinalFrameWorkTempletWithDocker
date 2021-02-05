package com.issi.exceptions;

/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 */
public class ReadPropertyFileException extends FrameWorkExceptions{
    /**
     * ReadPropertyFileException with message
     *
     * Pass the message that needs to be appended to the stacktrace
     * @param message Details about the exception or custom message
     */
    public ReadPropertyFileException(String message) {
        super(message);
    }

    /**
     * ReadPropertyFileException with message and cause
     *
     * @param message Details about the exception or custom message
     * @param cause Pass the enriched stacktrace or customised stacktrace
     */
    public ReadPropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
