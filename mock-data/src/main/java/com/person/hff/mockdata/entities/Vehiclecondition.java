package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("vehiclecondition")
public class Vehiclecondition {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Name")
    private String Name;
    /**
    * 
    */
    @DataValue(columnName = "Speed")
    private BigDecimal Speed;
    /**
    * 
    */
    @DataValue(columnName = "Driver")
    private String Driver;
    /**
    * 
    */
    @DataValue(columnName = "DriverTime")
    private String DriverTime;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
