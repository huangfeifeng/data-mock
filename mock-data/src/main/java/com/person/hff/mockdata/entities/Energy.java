package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("energy")
public class Energy {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "WaterConsumption")
    private BigDecimal WaterConsumption;
    /**
    * 
    */
    @DataValue(columnName = "ElecConsumption")
    private BigDecimal ElecConsumption;
    /**
    * 
    */
    @DataValue(columnName = "GasConsumption")
    private BigDecimal GasConsumption;
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
