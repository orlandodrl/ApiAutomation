package com.home.apiautomation.exceptions;

public enum ExceptionMessages {

    UNEXPECTED_RESPONSE_CODE("The response code obtained is not the expected code"),
    UNEXPECTED_MESSAGE("The message in the response obtained is not the expected message"),
    UNEXPECTED_STRUCTURE("The response structure obtained is not the expected structure");

    private String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
