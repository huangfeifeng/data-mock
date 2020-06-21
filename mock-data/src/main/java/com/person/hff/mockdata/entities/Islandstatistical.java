package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("islandstatistical")
public class Islandstatistical {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "PersonCount")
    private BigDecimal PersonCount;
    /**
    * 
    */
    @DataValue(columnName = "CarCount")
    private BigDecimal CarCount;
    /**
    * 
    */
    @DataValue(columnName = "WebCount")
    private BigDecimal WebCount;
    /**
    * 
    */
    @DataValue(columnName = "AppCount")
    private BigDecimal AppCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;
    /**
    * 
    */
    @DataValue(columnName = "PlayTime")
    private Date PlayTime;


}
