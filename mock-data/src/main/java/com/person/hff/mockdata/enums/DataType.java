package com.person.hff.mockdata.enums;

public enum DataType {
    INTEGER("Integer"), LONG("Long"), DATE("Date"), BIGDECIMAL("BigDecimal"), STRING("String");


    private String type;

    private DataType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
