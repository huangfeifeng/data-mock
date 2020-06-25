package com.person.hff.mockdata.annotation.define;

import com.person.hff.mockdata.annotation.data.AbstractGenerator;
import lombok.Data;

@Data
public class DataItem {

    private String fieldType;

    private String fieldName;

    private String columnName;

    private String value;

    private AbstractGenerator generator;
}
