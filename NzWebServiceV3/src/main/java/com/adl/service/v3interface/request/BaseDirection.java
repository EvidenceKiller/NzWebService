package com.adl.service.v3interface.request;

public enum BaseDirection {
    ASC("ASC"),
    DESC("DESC");

    private String value;

    BaseDirection(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
