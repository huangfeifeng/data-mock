package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("mouthstatistical")
public class Mouthstatistical {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Count")
    private BigDecimal Count;
    /**
    * 
    */
    @DataValue(columnName = "Day")
    private String Day;
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
    /**
    * 
    */
    @DataValue(columnName = "PlayTime")
    private Date PlayTime;


}
