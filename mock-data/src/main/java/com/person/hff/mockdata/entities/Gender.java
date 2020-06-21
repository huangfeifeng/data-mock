package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("gender")
public class Gender {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "WomenCount")
    private BigDecimal WomenCount;
    /**
    * 
    */
    @DataValue(columnName = "MenCount")
    private BigDecimal MenCount;
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
