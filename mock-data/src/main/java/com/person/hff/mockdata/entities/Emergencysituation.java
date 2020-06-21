package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("emergencysituation")
public class Emergencysituation {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "BeOnDutyCount")
    private String BeOnDutyCount;
    /**
    * 
    */
    @DataValue(columnName = "AlarmCount")
    private String AlarmCount;
    /**
    * 
    */
    @DataValue(columnName = "HandleCount")
    private String HandleCount;
    /**
    * 
    */
    @DataValue(columnName = "EmergencyArea")
    private String EmergencyArea;
    /**
    * 
    */
    @DataValue(columnName = "PeopleCount")
    private String PeopleCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
