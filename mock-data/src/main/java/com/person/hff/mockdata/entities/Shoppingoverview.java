package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("shoppingoverview")
public class Shoppingoverview {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "RealTourist")
    private BigDecimal RealTourist;
    /**
    * 
    */
    @DataValue(columnName = "QuaBusCount")
    private BigDecimal QuaBusCount;
    /**
    * 
    */
    @DataValue(columnName = "DayTourist")
    private BigDecimal DayTourist;
    /**
    * 
    */
    @DataValue(columnName = "PassRate")
    private BigDecimal PassRate;
    /**
    * 
    */
    @DataValue(columnName = "BusCount")
    private BigDecimal BusCount;
    /**
    * 
    */
    @DataValue(columnName = "RentalRate")
    private BigDecimal RentalRate;
    /**
    * 
    */
    @DataValue(columnName = "CooperBus")
    private BigDecimal CooperBus;
    /**
    * 
    */
    @DataValue(columnName = "ComplaintRate")
    private BigDecimal ComplaintRate;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
