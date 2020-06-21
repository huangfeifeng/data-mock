package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("merchantsanalysis")
public class Merchantsanalysis {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "MerchantInPercent")
    private BigDecimal MerchantInPercent;
    /**
    * 
    */
    @DataValue(columnName = "MerchantCount")
    private BigDecimal MerchantCount;
    /**
    * 
    */
    @DataValue(columnName = "DeviceCount")
    private BigDecimal DeviceCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
