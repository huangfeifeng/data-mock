package com.person.hff.mockdata.annotation.parse;

import com.person.hff.mockdata.annotation.data.ValueStrategy;
import com.person.hff.mockdata.annotation.define.DataFamily;
import com.person.hff.mockdata.annotation.define.DataItem;
import com.person.hff.mockdata.entities.Alarm;
import com.person.hff.mockdata.generator.ConnectionUtil;
import com.person.hff.mockdata.utils.ClassScanner;
import com.person.hff.mockdata.utils.Constant;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataFamilyGenerator {

    public static void main(String[] args) {
        String packagePath = "com.person.hff.mockdata.entities";
        Set<Class> classes = ClassScanner.getClasses(packagePath);
        for (Class clazz : classes) {
            if(Alarm.class == clazz) {
                DataFamily dataFamily = DataFamilyParser.parse(clazz);
                Map<String, Object> dataMap = generateDataMap(dataFamily);
                System.out.println(dataMap);
                String tableName = dataFamily.getTableName();
                insertToDB(dataMap, tableName);
            }
        }
    }

    public static Object generate(DataFamily dataFamily) {
        Class clazz = dataFamily.getClazz();
        ValueStrategy valueStrategy = dataFamily.getValueStrategy();


        Field[] declaredFields = clazz.getDeclaredFields();
        Object instance = null;
        try {
            instance = clazz.newInstance();

            for (Field f : declaredFields) {
                String fieldTypeName = f.getType().getSimpleName();

                Object v = generateRandom(valueStrategy, fieldTypeName);

                f.setAccessible(true);
                f.set(instance, v);
            }
            //System.out.println(instance);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return instance;
    }

    public static Map<String, Object> generateDataMap(DataFamily dataFamily) {
        Class clazz = dataFamily.getClazz();
        ValueStrategy valueStrategy = dataFamily.getValueStrategy();
        Map<String, DataItem> dataItemMap = dataFamily.getDataItemMap();

        Field[] declaredFields = clazz.getDeclaredFields();
        Map<String, Object> dataMap = new HashMap<>();

        for (Field f : declaredFields) {
            String fieldTypeName = f.getType().getSimpleName();
            String fieldName = f.getName();

            Object v = generateRandom(valueStrategy, fieldTypeName);

            DataItem dataItem = dataItemMap.get(fieldName);
            if(v instanceof Date) {
                Date date = (Date)v;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                v = simpleDateFormat.format(date);
            }
            dataMap.put(dataItem.getColumnName(), v);

        }

        return dataMap;
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
                values.append(Constant.APOSTROPHES.replace("${value}", entry.getValue().toString()));
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
}
