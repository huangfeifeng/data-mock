package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("islandwidesurvey")
public class Islandwidesurvey {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "PeopleCount")
    private BigDecimal PeopleCount;
    /**
    * 
    */
    @DataValue(columnName = "CarCount")
    private BigDecimal CarCount;
    /**
    * 
    */
    @DataValue(columnName = "DayInput")
    private BigDecimal DayInput;
    /**
    * 
    */
    @DataValue(columnName = "SurplusPark")
    private BigDecimal SurplusPark;
    /**
    * 
    */
    @DataValue(columnName = "MonthTourist")
    private BigDecimal MonthTourist;
    /**
    * 
    */
    @DataValue(columnName = "UsePark")
    private BigDecimal UsePark;
    /**
    * 
    */
    @DataValue(columnName = "YearTourist")
    private BigDecimal YearTourist;
    /**
    * 
    */
    @DataValue(columnName = "OperatingCount")
    private BigDecimal OperatingCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
