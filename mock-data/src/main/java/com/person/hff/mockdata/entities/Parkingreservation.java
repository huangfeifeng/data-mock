package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("parkingreservation")
public class Parkingreservation {

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
    @DataValue(columnName = "Type")
    private String Type;
    /**
    * 
    */
    @DataValue(columnName = "Sort")
    private Integer Sort;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
