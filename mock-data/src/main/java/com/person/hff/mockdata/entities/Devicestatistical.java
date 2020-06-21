package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("devicestatistical")
public class Devicestatistical {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "DeviceCount")
    private BigDecimal DeviceCount;
    /**
    * 
    */
    @DataValue(columnName = "BreakCount")
    private BigDecimal BreakCount;
    /**
    * 
    */
    @DataValue(columnName = "Attribution")
    private String Attribution;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
