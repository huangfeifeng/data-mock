package com.person.hff.mockdata.annotation.define;

import com.person.hff.mockdata.annotation.data.ValueStrategy;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DataFamily {

    private String tableName;

    private Class clazz;

    private ValueStrategy valueStrategy;

    private Map<String, DataItem> dataItemMap;
}
