package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("daymarketingsituation")
public class Daymarketingsituation {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "WEBCount")
    private BigDecimal WEBCount;
    /**
    * 
    */
    @DataValue(columnName = "APPCount")
    private BigDecimal APPCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
