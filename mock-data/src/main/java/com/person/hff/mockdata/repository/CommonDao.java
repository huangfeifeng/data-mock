package com.person.hff.mockdata.repository;

import com.person.hff.mockdata.annotation.define.DataFamily;
import com.person.hff.mockdata.annotation.define.DataItem;
import com.person.hff.mockdata.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class CommonDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void insert(String tableName, List<Map<String, Object>> dataList) {

        StringBuffer batchSql = new StringBuffer();
        for(int i=0; i<dataList.size(); i++) {
            Map<String, Object> dataMap = dataList.get(i);
            String sql = buildInsertSql(tableName, dataMap);

            batchSql.append(sql);
        }

        System.out.println(batchSql);
        jdbcTemplate.execute(batchSql.toString());
    }

    private String buildInsertSql(String tableName, Map<String,Object> dataMap) {
        StringBuffer sb = new StringBuffer();
        sb.append("Insert Into ").append(tableName);
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

        sb.append(fields).append(" values ").append(values).append(";");

        return sb.toString();
    }

    public void delete(String tableName, List<String> data) {
        StringBuffer sb = new StringBuffer();
        sb.append("Delete From ").append(tableName).append(" Where id IN");

        sb.append("(");
        for(int i=0; i<data.size(); i++) {
            sb.append(data.get(i));
            if(i != data.size() - 1) {
                sb.append(",");
            }
        }

        sb.append(")");


        System.out.println(sb);
        jdbcTemplate.execute(sb.toString());
    }

    public void update(String tableName, List<Map<String, Object>> data) {
        StringBuffer batchSql = new StringBuffer();
        for(int i=0; i<data.size(); i++) {
            Map<String, Object> dataMap = data.get(i);
            String sql = buildUpdateSql(tableName, dataMap);
            batchSql.append(sql);
        }

        System.out.println(batchSql);
        jdbcTemplate.execute(batchSql.toString());

    }

    private String buildUpdateSql(String tableName, Map<String,Object> dataMap) {
        StringBuffer sb = new StringBuffer();
        sb.append("Update ").append(tableName);
        StringBuffer setBuffer = new StringBuffer();
        StringBuffer whereBuffer = new StringBuffer();
        Set<Map.Entry<String, Object>> entrySet = dataMap.entrySet();
        int size = dataMap.size();
        int index = 0;
        setBuffer.append(" Set ");
        whereBuffer.append(" Where ");
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            index ++;
            if(!"id".equals(key)) {
                setBuffer.append(key).append("=").append(Constant.APOSTROPHES.replace("${value}", entry.getValue().toString()));
                if(index < size) {
                    setBuffer.append(",");
                }
            } else {
                whereBuffer.append(key).append("=").append(Constant.APOSTROPHES.replace("${value}", entry.getValue().toString()));
            }
        }

        sb.append(setBuffer).append(whereBuffer).append(";");

        return sb.toString();
    }

    public List<Object> select(String tableName, List<Map<String, Object>> data, DataFamily dataFamily) {

        //final Class clazz = dataFamily.getClazz();
        final List<DataItem> dataItemList = dataFamily.getDataItemList();

        Map<String, Object> dataMap = data.get(0);

        StringBuffer sb = new StringBuffer();
        sb.append("Select * From ").append(tableName);
        StringBuffer whereBuffer = new StringBuffer();
        Set<Map.Entry<String, Object>> entrySet = dataMap.entrySet();
        int size = dataMap.size();
        Object[] params = new Object[size];
        int index = 0;
        whereBuffer.append(" Where ");
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            params[index] = entry.getValue();
            index ++;
            whereBuffer.append(key).append("=").append(Constant.SQL_PLACEHOLDER);
            if(index < size) {
                whereBuffer.append(" And ");
            }
        }
        sb.append(whereBuffer);

        System.out.println(sb);

        List<Object> list = jdbcTemplate.query(sb.toString(), params, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Map<String, Object> resultMap = new HashMap<>();
                for(int index=0; index<dataItemList.size(); index++) {
                    DataItem dataItem = dataItemList.get(index);
                    String fieldName = dataItem.getFieldName();
                    String fieldType = dataItem.getFieldType();
                    Object v = null;
                    switch(fieldType) {
                        case "String": v = resultSet.getString(fieldName); break;
                        case "Integer": v = resultSet.getInt(fieldName); break;
                        case "Long": v = resultSet.getLong(fieldName); break;
                        case "Date": v = resultSet.getDate(fieldName); break;
                        case "BigDecimal": v = resultSet.getBigDecimal(fieldName); break;
                    }
                    if(v != null) {
                        resultMap.put(fieldName, v);
                    }

                }
                System.out.println(resultSet);
                return resultMap;
            }
        });

        return list;
    }
}
