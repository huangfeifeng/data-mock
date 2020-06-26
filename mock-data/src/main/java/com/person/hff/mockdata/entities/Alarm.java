package com.person.hff.mockdata.entities;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("alarm")
public class Alarm {

    /**
    * 
    */
    
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    
    @DataValue(columnName = "EventName")
    private String EventName;
    /**
    * 
    */
    
    @DataValue(columnName = "EventID")
    private String EventID;
    /**
    * 
    */
    
    @DataValue(columnName = "EventDescribe")
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
    
    @DataValue(columnName = "EventState")
    private String EventState;
    /**
    * 
    */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DataValue(columnName = "AlarmTime")
    private Date AlarmTime;
    /**
    * 
    */
    
    @DataValue(columnName = "AlarmSource")
    private String AlarmSource;
    /**
    * 
    */
    
    @DataValue(columnName = "HtmlUrl")
    private String HtmlUrl;
    /**
    * 
    */
    
    @DataValue(columnName = "CameraList")
    private String CameraList;
    /**
    * 
    */
    
    @DataValue(columnName = "BrakeList")
    private String BrakeList;
    /**
    * 
    */
    
    @DataValue(columnName = "GuardList")
    private String GuardList;
    /**
    * 
    */
    
    @DataValue(columnName = "RadioList")
    private String RadioList;
    /**
    * 
    */
    
    @DataValue(columnName = "InfoList")
    private String InfoList;
    /**
    * 
    */
    
    @DataValue(columnName = "Count")
    private Integer Count;
    /**
    * 
    */
    
    @DataValue(columnName = "MapID")
    private String MapID;
    /**
    * 
    */
    
    @DataValue(columnName = "MapName")
    private String MapName;
    /**
    * 
    */
    
    @DataValue(columnName = "ExistencePoint")
    private String ExistencePoint;
    /**
    * 
    */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DataValue(columnName = "Time")
    private Date Time;


}
