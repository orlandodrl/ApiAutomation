package com.home.apiautomation.exceptions;

public class CommonException extends AssertionError {

    public CommonException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
