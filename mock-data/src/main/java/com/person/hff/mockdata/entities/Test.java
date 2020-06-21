package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("test")
public class Test {

    /**
    * 
    */
    @DataValue(columnName = "Lon")
    private BigDecimal Lon;
    /**
    * 
    */
    @DataValue(columnName = "Lat")
    private BigDecimal Lat;
    /**
    * 
    */
    @DataValue(columnName = "time")
    private Date time;
    /**
    * 
    */
    @DataValue(columnName = "pihao")
    private String pihao;
    /**
    * 
    */
    @DataValue(columnName = "name")
    private String name;


}
