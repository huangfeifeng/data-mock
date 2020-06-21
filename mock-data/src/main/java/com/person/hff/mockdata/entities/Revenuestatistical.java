package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("revenuestatistical")
public class Revenuestatistical {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "TotalRevenue")
    private BigDecimal TotalRevenue;
    /**
    * 
    */
    @DataValue(columnName = "ComparedSame")
    private BigDecimal ComparedSame;
    /**
    * 
    */
    @DataValue(columnName = "Sequential")
    private BigDecimal Sequential;
    /**
    * 
    */
    @DataValue(columnName = "TotalShop")
    private BigDecimal TotalShop;
    /**
    * 
    */
    @DataValue(columnName = "TotalArea")
    private BigDecimal TotalArea;
    /**
    * 
    */
    @DataValue(columnName = "PlayTime")
    private Date PlayTime;


}
