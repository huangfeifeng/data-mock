package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("scenarioinfo")
public class Scenarioinfo {

    /**
    * 
    */
    @DataValue(columnName = "Key")
    private String Key;
    /**
    * 
    */
    @DataValue(columnName = "Value")
    private String Value;


}
