package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("breaktype")
public class Breaktype {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Type")
    private String Type;
    /**
    * 
    */
    @DataValue(columnName = "Count")
    private BigDecimal Count;
    /**
    * 
    */
    @DataValue(columnName = "Attribution")
    private String Attribution;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
