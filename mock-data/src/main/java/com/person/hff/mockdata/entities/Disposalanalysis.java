package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("disposalanalysis")
public class Disposalanalysis {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Step")
    private String Step;
    /**
    * 
    */
    @DataValue(columnName = "Content")
    private String Content;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
