package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("buildcourse")
public class Buildcourse {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Year")
    private String Year;
    /**
    * 
    */
    @DataValue(columnName = "Content")
    private String Content;
    /**
    * 
    */
    @DataValue(columnName = "ImgUrl")
    private String ImgUrl;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
