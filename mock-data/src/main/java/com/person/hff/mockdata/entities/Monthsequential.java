package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("monthsequential")
public class Monthsequential {

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
    @DataValue(columnName = "Month")
    private String Month;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
