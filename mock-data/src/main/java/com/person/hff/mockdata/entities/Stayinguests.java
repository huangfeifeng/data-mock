package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("stayinguests")
public class Stayinguests {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "StayInCount")
    private BigDecimal StayInCount;
    /**
    * 
    */
    @DataValue(columnName = "Percent")
    private BigDecimal Percent;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
