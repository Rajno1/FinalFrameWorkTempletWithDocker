package com.issi.exceptions;

public class BrowserInvokationFailedException extends FrameWorkExceptions{
    public BrowserInvokationFailedException(String message) {
        super(message);
    }

    public BrowserInvokationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
