package com.person.hff.mockdata.annotation.parse;

import com.person.hff.mockdata.annotation.DataValue;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.define.DataFamily;
import com.person.hff.mockdata.annotation.define.DataItem;
import com.person.hff.mockdata.annotation.define.DefaultValueStrategy;
import com.person.hff.mockdata.annotation.define.ValueStrategy;
import com.person.hff.mockdata.generator.ConnectionUtil;
import com.person.hff.mockdata.utils.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Slf4j
public class DataFamilyParser {

    public static final Map<String, DataFamily> map = new HashMap<>();

    public static void parse(Class clazz) {
        boolean exist = clazz.isAnnotationPresent(NormalData.class);
        if (exist) {
            NormalData normalData = (NormalData) clazz.getAnnotation(NormalData.class);

            DataFamily dataFamily = new DataFamily();

            String value = normalData.value();
            dataFamily.setTableName(value);
            dataFamily.setClazz(clazz);
            Class<? extends ValueStrategy> valueStrategyClass = normalData.valueStrategy();
            ValueStrategy valueStrategy = new DefaultValueStrategy();
            try {
                valueStrategy = valueStrategyClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

            dataFamily.setValueStrategy(valueStrategy);

            map.put(value, dataFamily);
            Field[] declaredFields = clazz.getDeclaredFields();

            System.out.println(value);
            System.out.println(Arrays.asList(declaredFields));
            Map<String, Object> dataMap = new HashMap<>();

            List<DataItem> dataItemList = new ArrayList<>();
            dataFamily.setDataItemList(dataItemList);
            for (Field f : declaredFields) {
                DataItem dataItem = new DataItem();
                dataItemList.add(dataItem);

                String fieldTypeName = f.getType().getSimpleName();
                String fieldName = f.getName();
                dataItem.setFieldName(fieldName);
                dataItem.setFieldType(fieldTypeName);

                boolean annotationPresent = f.isAnnotationPresent(DataValue.class);
                if(annotationPresent) {
                    DataValue dataValue = f.getAnnotation(DataValue.class);
                    String dataStr = dataValue.value();
                    dataItem.setValue(dataStr);

                    dataItem.setColumnName(dataValue.columnName());
                    if("".equals(dataStr)) {
                        Object objectValue = generateRandom(dataFamily.getValueStrategy(), fieldTypeName);
                        dataMap.put(fieldName, Constant.APOSTROPHES.replace("${value}", objectValue.toString()));
                    } else {
                        dataMap.put(fieldName, Constant.APOSTROPHES.replace("${value}", dataStr));
                    }
                }
            }
            System.out.println(dataMap);
            System.out.println(dataFamily);
            //insertToDB(dataMap, value);
            /*try {
                Object instance = clazz.newInstance();
                for (Field f : declaredFields) {
                    String fieldTypeName = f.getType().getSimpleName();
                    String fieldName = f.getName();

                    Object v = null;

                    switch(fieldTypeName) {
                        case "String": v = UUIDUtil.uuid(); break;
                        case "Integer": v = NumberUtil.random(100); break;
                        case "Long": v = NumberUtil.randomLong(100000); break;
                        case "Date": v = DateUtil.nowDate(); break;
                        case "BigDecimal": v = BigDecimal.ZERO; break;
                    }
                    f.setAccessible(true);
                    f.set(instance, v);
                }
                System.out.println(instance);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }*/



        }
    }

    private static Object generateRandom(ValueStrategy valueStrategy, String fieldTypeName) {
        Object value = null;
        switch (fieldTypeName) {
            case "String":
                value = valueStrategy.generateString();
                break;
            case "Integer":
                value = valueStrategy.generateInteger();
                break;
            case "Long":
                value = valueStrategy.generateLong();
                break;
            case "BigDecimal":
                value = valueStrategy.generateBigDecimal();
                break;
            case "Date":
                value = valueStrategy.generateDate();
                break;
        }

        return value;
    }

    private static void insertToDB(Map<String, Object> dataMap, String value) {
        StringBuffer sb = new StringBuffer();
        sb.append("Insert Into ").append(value);
        StringBuffer fields = new StringBuffer();
        StringBuffer values = new StringBuffer();
        Set<Map.Entry<String, Object>> entrySet = dataMap.entrySet();
        int size = dataMap.size();
        int index = 0;
        fields.append("(");
        values.append("(");
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            index ++;
            if(!"id".equals(key)) {
                fields.append(key);
                values.append(entry.getValue());
                if(index < size) {
                    fields.append(",");
                    values.append(",");
                }
            }
        }
        fields.append(")");
        values.append(")");

        sb.append(fields).append(" values ").append(values);
        System.out.println(sb);

        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null != connection) {
                ConnectionUtil.release(connection);
            }
        }
    }

    public static void main(String[] args) {
        String packagePath =  "com.person.hff.mockdata.entities";
        Set<Class> classes = ClassScanner.getClasses(packagePath);
        for (Class clazz : classes) {
            //System.out.println(clazz);
            DataFamilyParser.parse(clazz);
        }


        //DataFamilyParser.parse(Alarm.class);
    }

    public static DataFamily parseDataFamily(Class clazz) {
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

            List<DataItem> dataItemList = new ArrayList<>();
            dataFamily.setDataItemList(dataItemList);

            for (Field f : declaredFields) {
                DataItem dataItem = new DataItem();
                dataItemList.add(dataItem);

                String fieldTypeName = f.getType().getSimpleName();
                String fieldName = f.getName();
                dataItem.setFieldName(fieldName);
                dataItem.setFieldType(fieldTypeName);

                boolean annotationPresent = f.isAnnotationPresent(DataValue.class);
                if(annotationPresent) {
                    DataValue dataValue = f.getAnnotation(DataValue.class);
                    String dataStr = dataValue.value();
                    dataItem.setValue(dataStr);
                    dataItem.setColumnName(dataValue.columnName());
                }


            }
            System.out.println(dataFamily);

        }
        return dataFamily;
    }


}
