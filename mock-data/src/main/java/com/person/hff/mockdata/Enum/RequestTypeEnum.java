package com.person.hff.mockdata.Enum;

public enum RequestTypeEnum {
    GET("get"), POST("post"), PUT("put"), DELETE("delete");

    private String type;

    private RequestTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
