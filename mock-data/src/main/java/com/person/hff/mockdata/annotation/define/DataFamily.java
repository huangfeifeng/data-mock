package com.person.hff.mockdata.annotation.define;

import lombok.Data;

import java.util.List;

@Data
public class DataFamily {

    private String tableName;

    private Class clazz;

    private ValueStrategy valueStrategy;

    private List<DataItem> dataItemList;
}
