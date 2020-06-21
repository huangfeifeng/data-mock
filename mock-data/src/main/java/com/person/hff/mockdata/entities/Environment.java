package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("environment")
public class Environment {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "AirIndex")
    private BigDecimal AirIndex;
    /**
    * 
    */
    @DataValue(columnName = "Humidity")
    private BigDecimal Humidity;
    /**
    * 
    */
    @DataValue(columnName = "WaveHeight")
    private BigDecimal WaveHeight;
    /**
    * 
    */
    @DataValue(columnName = "WaterLevel")
    private BigDecimal WaterLevel;
    /**
    * 
    */
    @DataValue(columnName = "Temperature")
    private BigDecimal Temperature;
    /**
    * 
    */
    @DataValue(columnName = "Greening")
    private BigDecimal Greening;
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
