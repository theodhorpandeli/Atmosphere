package com.example.theodhor.airchecker.Connection;

/**
 * Created by Dori on 4/15/2016.
 */
public class ErrorEvent {
    private Integer errorCode;
    private String errorMessage;

    public ErrorEvent(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
