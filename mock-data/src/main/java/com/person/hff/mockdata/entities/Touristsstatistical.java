package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("touristsstatistical")
public class Touristsstatistical {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "TotalCount")
    private BigDecimal TotalCount;
    /**
    * 
    */
    @DataValue(columnName = "InCount")
    private BigDecimal InCount;
    /**
    * 
    */
    @DataValue(columnName = "OutCount")
    private BigDecimal OutCount;
    /**
    * 
    */
    @DataValue(columnName = "MonthCount")
    private BigDecimal MonthCount;
    /**
    * 
    */
    @DataValue(columnName = "YearCount")
    private BigDecimal YearCount;
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
