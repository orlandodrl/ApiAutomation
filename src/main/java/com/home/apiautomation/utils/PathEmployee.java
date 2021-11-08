package com.home.apiautomation.utils;

public enum PathEmployee {

    CONSULT_ALL_EMPLOYEES("/employees"),
    CONSULT_EMPLOYEE("/employee"),
    CREATE_EMPLOYEE("/create"),
    DELETE_EMPLOYEE("/delete");

    private String path;

    PathEmployee(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
