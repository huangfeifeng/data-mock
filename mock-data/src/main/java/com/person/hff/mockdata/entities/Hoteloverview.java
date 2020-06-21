package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("hoteloverview")
public class Hoteloverview {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "SubscribeCount")
    private BigDecimal SubscribeCount;
    /**
    * 
    */
    @DataValue(columnName = "CheckInCount")
    private BigDecimal CheckInCount;
    /**
    * 
    */
    @DataValue(columnName = "CheckOutCount")
    private BigDecimal CheckOutCount;
    /**
    * 
    */
    @DataValue(columnName = "FreeCount")
    private BigDecimal FreeCount;
    /**
    * 
    */
    @DataValue(columnName = "UseCount")
    private BigDecimal UseCount;
    /**
    * 
    */
    @DataValue(columnName = "OccupancyRate")
    private BigDecimal OccupancyRate;
    /**
    * 
    */
    @DataValue(columnName = "SatisfactionDegree")
    private BigDecimal SatisfactionDegree;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
