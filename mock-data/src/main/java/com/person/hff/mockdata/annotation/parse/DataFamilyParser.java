package com.person.hff.mockdata.annotation.parse;

import com.person.hff.mockdata.annotation.DataValue;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.data.AbstractGenerator;
import com.person.hff.mockdata.annotation.data.DefaultGenerator;
import com.person.hff.mockdata.annotation.define.DataFamily;
import com.person.hff.mockdata.annotation.define.DataItem;
import com.person.hff.mockdata.annotation.data.DefaultValueStrategy;
import com.person.hff.mockdata.annotation.data.ValueStrategy;
import com.person.hff.mockdata.utils.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;

@Slf4j
public class DataFamilyParser {



    public static void main(String[] args) {
        String packagePath =  "com.person.hff.mockdata.entities";
        Set<Class> classes = ClassScanner.getClasses(packagePath);
        for (Class clazz : classes) {
            //System.out.println(clazz);
            DataFamilyParser.parse(clazz);
        }


        //DataFamilyParser.parse(Alarm.class);
    }

    public static DataFamily parse(Class clazz) {
        DataFamily dataFamily = null;
        boolean exist = clazz.isAnnotationPresent(NormalData.class);
        if (exist) {
            NormalData normalData = (NormalData) clazz.getAnnotation(NormalData.class);

            dataFamily = new DataFamily();
            dataFamily.setClazz(clazz);
            String value = normalData.value();
            dataFamily.setTableName(value);

            Class<? extends ValueStrategy> valueStrategyClass = normalData.valueStrategy();
            ValueStrategy valueStrategy = new DefaultValueStrategy();
            try {
                valueStrategy = valueStrategyClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            dataFamily.setValueStrategy(valueStrategy);

            Field[] declaredFields = clazz.getDeclaredFields();

            //System.out.println(value);
            //System.out.println(Arrays.asList(declaredFields));

            Map<String, DataItem> dataItemMap = new HashMap<>();
            dataFamily.setDataItemMap(dataItemMap);

            for (Field f : declaredFields) {
                DataItem dataItem = new DataItem();
                String fieldTypeName = f.getType().getSimpleName();
                String fieldName = f.getName();
                dataItem.setFieldName(fieldName);
                dataItem.setFieldType(fieldTypeName);

                dataItemMap.put(fieldName, dataItem);

                boolean annotationPresent = f.isAnnotationPresent(DataValue.class);
                if(annotationPresent) {
                    DataValue dataValue = f.getAnnotation(DataValue.class);
                    String dataStr = dataValue.value();
                    dataItem.setValue(dataStr);
                    dataItem.setColumnName(dataValue.columnName());
                    Class<? extends AbstractGenerator> generatorClass = dataValue.generator();
                    AbstractGenerator generator = new DefaultGenerator();
                    try {
                        generator = generatorClass.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    dataItem.setGenerator(generator);
                }
            }
            System.out.println(dataFamily);

        }
        return dataFamily;
    }


}
