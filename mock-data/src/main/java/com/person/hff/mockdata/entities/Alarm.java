package com.person.hff.mockdata.entities;

import com.person.hff.mockdata.annotation.define.CustomValueStrategy;
import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData(value = "alarm", valueStrategy = CustomValueStrategy.class)
public class Alarm {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "EventName", value = "发送到发斯蒂芬")
    private String EventName;
    /**
    * 
    */
    @DataValue(columnName = "EventID", value = "213456")
    private String EventID;
    /**
    * 
    */
    @DataValue(columnName = "EventDescribe", value = "assdfasdf")
    private String EventDescribe;
    /**
    * 
    */
    @DataValue(columnName = "Longitude")
    private BigDecimal Longitude;
    /**
    * 
    */
    @DataValue(columnName = "Latitude")
    private BigDecimal Latitude;
    /**
    * 
    */
    @DataValue(columnName = "Altitude")
    private BigDecimal Altitude;
    /**
    * 
    */
    @DataValue(columnName = "CameraList")
    private String CameraList;
    /**
    * 
    */
    @DataValue(columnName = "Count")
    private Integer Count;
    /**
    * 
    */
    @DataValue(columnName = "EventLevel")
    private String EventLevel;
    /**
    * 
    */
    @DataValue(columnName = "EventType")
    private String EventType;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
