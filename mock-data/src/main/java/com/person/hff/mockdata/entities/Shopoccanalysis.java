package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("shopoccanalysis")
public class Shopoccanalysis {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "UniqueID")
    private String UniqueID;
    /**
    * 
    */
    @DataValue(columnName = "Floor")
    private String Floor;
    /**
    * 
    */
    @DataValue(columnName = "Room")
    private String Room;
    /**
    * 
    */
    @DataValue(columnName = "Status")
    private String Status;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
