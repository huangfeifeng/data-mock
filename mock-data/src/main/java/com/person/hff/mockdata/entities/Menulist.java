package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("menulist")
public class Menulist {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Name")
    private String Name;
    /**
    * 
    */
    @DataValue(columnName = "MName")
    private String MName;


}
