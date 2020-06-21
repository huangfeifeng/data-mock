package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("peopleguarantee")
public class Peopleguarantee {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Post")
    private String Post;
    /**
    * 
    */
    @DataValue(columnName = "Name")
    private String Name;
    /**
    * 
    */
    @DataValue(columnName = "Phone")
    private String Phone;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
