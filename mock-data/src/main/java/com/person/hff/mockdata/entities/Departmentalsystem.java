package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("departmentalsystem")
public class Departmentalsystem {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "Department")
    private String Department;
    /**
    * 
    */
    @DataValue(columnName = "Contacts")
    private String Contacts;
    /**
    * 
    */
    @DataValue(columnName = "Phone")
    private String Phone;
    /**
    * 
    */
    @DataValue(columnName = "Post")
    private String Post;
    /**
    * 
    */
    @DataValue(columnName = "DepartmentCount")
    private BigDecimal DepartmentCount;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
