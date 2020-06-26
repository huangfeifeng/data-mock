package com.person.hff.mockdata.repository;

import com.person.hff.mockdata.annotation.define.DataFamily;
import com.person.hff.mockdata.annotation.define.DataItem;
import com.person.hff.mockdata.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
            if(!Constant.ID.equals(key.toLowerCase())) {
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
        final Map<String, DataItem> dataItemMap = dataFamily.getDataItemMap();
        StringBuffer sb = new StringBuffer();
        Object[] params = null;
        sb.append("Select * From ").append(tableName);

        if(data != null && data.size() > 0) {
            Map<String, Object> dataMap = data.get(0);

            if(dataMap != null && dataMap.size() > 0) {
                StringBuffer whereBuffer = new StringBuffer();
                Set<Map.Entry<String, Object>> entrySet = dataMap.entrySet();
                int size = dataMap.size();
                params = new Object[size];
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
            }
        }

        System.out.println(sb);

        List<Object> list = jdbcTemplate.query(sb.toString(), params, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {

                Map<String, Object> resultMap = new HashMap<>();

                Set<Map.Entry<String, DataItem>> entries = dataItemMap.entrySet();
                for (Map.Entry<String, DataItem> entry : entries) {
                    DataItem dataItem = entry.getValue();
                    String fieldName = dataItem.getFieldName();
                    String columnName = dataItem.getColumnName();
                    String fieldType = dataItem.getFieldType();
                    if(StringUtils.isEmpty(columnName)) {
                        columnName = fieldName;
                    }
                    Object v = null;
                    switch(fieldType) {
                        case "String": v = resultSet.getString(columnName); break;
                        case "Integer": v = resultSet.getInt(columnName); break;
                        case "Long": v = resultSet.getLong(columnName); break;
                        case "Date": v = resultSet.getDate(columnName); break;
                        case "BigDecimal": v = resultSet.getBigDecimal(columnName); break;
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
