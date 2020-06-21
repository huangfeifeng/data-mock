package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("soe平面")
public class Soe平面 {

    /**
    * 
    */
    @DataValue(columnName = "id")
    private Integer id;
    /**
    * 
    */
    @DataValue(columnName = "x")
    private Integer x;
    /**
    * 
    */
    @DataValue(columnName = "y")
    private Integer y;
    /**
    * 
    */
    @DataValue(columnName = "z")
    private Integer z;
    /**
    * 
    */
    @DataValue(columnName = "name")
    private String name;


}
