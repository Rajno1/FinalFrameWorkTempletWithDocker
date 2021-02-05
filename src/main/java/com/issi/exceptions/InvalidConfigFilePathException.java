package com.issi.exceptions;

/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 */
public class InvalidConfigFilePathException extends FrameWorkExceptions{
    /**
     *
     * @param message Pass the message that needs to be appended to the stacktrace
     */
    public InvalidConfigFilePathException(String message) {
        super(message);
    }

    /**
     *
     * @param message message Details about the exception or custom message
     * @param cause cause Pass the enriched stacktrace or customised stacktrace
     */
    public InvalidConfigFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
