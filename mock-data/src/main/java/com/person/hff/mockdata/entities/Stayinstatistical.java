package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("stayinstatistical")
public class Stayinstatistical {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "YearCount")
    private BigDecimal YearCount;
    /**
    * 
    */
    @DataValue(columnName = "DayCount")
    private BigDecimal DayCount;
    /**
    * 
    */
    @DataValue(columnName = "MonthCount")
    private BigDecimal MonthCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
