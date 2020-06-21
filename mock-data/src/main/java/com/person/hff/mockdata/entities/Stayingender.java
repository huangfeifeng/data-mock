package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("stayingender")
public class Stayingender {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "MenCount")
    private BigDecimal MenCount;
    /**
    * 
    */
    @DataValue(columnName = "WomenCount")
    private BigDecimal WomenCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
