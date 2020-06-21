package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("parkingsurvey")
public class Parkingsurvey {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "UsePark")
    private BigDecimal UsePark;
    /**
    * 
    */
    @DataValue(columnName = "SurplusPark")
    private BigDecimal SurplusPark;
    /**
    * 
    */
    @DataValue(columnName = "UseChargePark")
    private BigDecimal UseChargePark;
    /**
    * 
    */
    @DataValue(columnName = "SurplusChargePark")
    private BigDecimal SurplusChargePark;
    /**
    * 
    */
    @DataValue(columnName = "DayParkCount")
    private BigDecimal DayParkCount;
    /**
    * 
    */
    @DataValue(columnName = "YearParkCount")
    private BigDecimal YearParkCount;
    /**
    * 
    */
    @DataValue(columnName = "DayMoney")
    private BigDecimal DayMoney;
    /**
    * 
    */
    @DataValue(columnName = "MonthMoney")
    private BigDecimal MonthMoney;
    /**
    * 
    */
    @DataValue(columnName = "AvgTime")
    private BigDecimal AvgTime;
    /**
    * 
    */
    @DataValue(columnName = "UseRate")
    private BigDecimal UseRate;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
