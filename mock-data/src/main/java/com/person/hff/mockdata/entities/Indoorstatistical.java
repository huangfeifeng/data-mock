package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("indoorstatistical")
public class Indoorstatistical {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "RealCount")
    private BigDecimal RealCount;
    /**
    * 
    */
    @DataValue(columnName = "DayCount")
    private BigDecimal DayCount;
    /**
    * 
    */
    @DataValue(columnName = "StayHour")
    private BigDecimal StayHour;
    /**
    * 
    */
    @DataValue(columnName = "AlarmCount")
    private BigDecimal AlarmCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
