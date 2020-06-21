package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("parkingdetailed")
public class Parkingdetailed {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "ParkTime")
    private String ParkTime;
    /**
    * 
    */
    @DataValue(columnName = "Position")
    private String Position;
    /**
    * 
    */
    @DataValue(columnName = "CarNumber")
    private String CarNumber;
    /**
    * 
    */
    @DataValue(columnName = "Money")
    private BigDecimal Money;
    /**
    * 
    */
    @DataValue(columnName = "State")
    private String State;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
