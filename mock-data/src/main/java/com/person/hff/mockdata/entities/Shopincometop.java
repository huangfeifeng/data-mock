package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("shopincometop")
public class Shopincometop {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "ShopName")
    private String ShopName;
    /**
    * 
    */
    @DataValue(columnName = "ShopIconUrl")
    private String ShopIconUrl;
    /**
    * 
    */
    @DataValue(columnName = "Count")
    private BigDecimal Count;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
