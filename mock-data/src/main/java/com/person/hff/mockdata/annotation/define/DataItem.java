package com.person.hff.mockdata.annotation.define;

import lombok.Data;

@Data
public class DataItem {

    private String fieldType;

    private String fieldName;

    private String columnName;

    private String value;

    private Class generatorClass;
}
