package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("brandcontrast")
public class Brandcontrast {

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
    @DataValue(columnName = "Per")
    private BigDecimal Per;
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
