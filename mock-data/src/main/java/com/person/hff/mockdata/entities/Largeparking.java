package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("largeparking")
public class Largeparking {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Occupancy")
    private BigDecimal Occupancy;
    /**
    * 
    */
    @DataValue(columnName = "Free")
    private BigDecimal Free;
    /**
    * 
    */
    @DataValue(columnName = "OccPer")
    private BigDecimal OccPer;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
