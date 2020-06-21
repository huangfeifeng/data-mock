package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("cardistinguish")
public class Cardistinguish {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "CarNumber")
    private String CarNumber;
    /**
    * 
    */
    @DataValue(columnName = "CarImage")
    private String CarImage;
    /**
    * 
    */
    @DataValue(columnName = "Position")
    private String Position;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
