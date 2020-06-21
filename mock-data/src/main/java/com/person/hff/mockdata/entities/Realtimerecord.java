package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("realtimerecord")
public class Realtimerecord {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Date")
    private String Date;
    /**
    * 
    */
    @DataValue(columnName = "CarNumber")
    private String CarNumber;
    /**
    * 
    */
    @DataValue(columnName = "StartTime")
    private String StartTime;
    /**
    * 
    */
    @DataValue(columnName = "State")
    private String State;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
