package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("dayhotelreservation")
public class Dayhotelreservation {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "CheckIn")
    private BigDecimal CheckIn;
    /**
    * 
    */
    @DataValue(columnName = "Reserve")
    private BigDecimal Reserve;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
