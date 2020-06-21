package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("runningspeed")
public class Runningspeed {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Speed")
    private BigDecimal Speed;
    /**
    * 
    */
    @DataValue(columnName = "Type")
    private String Type;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
