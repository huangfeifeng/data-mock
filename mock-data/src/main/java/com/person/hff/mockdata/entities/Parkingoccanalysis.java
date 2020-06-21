package com.person.hff.mockdata.entities;

import lombok.Data;
import com.person.hff.mockdata.annotation.NormalData;
import com.person.hff.mockdata.annotation.DataValue;


import java.math.BigDecimal;
import java.util.Date;

@Data
@NormalData("parkingoccanalysis")
public class Parkingoccanalysis {

    /**
    * 
    */
    @DataValue(columnName = "ID")
    private Integer ID;
    /**
    * 
    */
    @DataValue(columnName = "UniqueID")
    private String UniqueID;
    /**
    * 
    */
    @DataValue(columnName = "Area")
    private String Area;
    /**
    * 
    */
    @DataValue(columnName = "ParkingNumber")
    private String ParkingNumber;
    /**
    * 
    */
    @DataValue(columnName = "Status")
    private String Status;
    /**
    * 
    */
    @DataValue(columnName = "ImgUrl")
    private String ImgUrl;
    /**
    * 
    */
    @DataValue(columnName = "CarNumber")
    private String CarNumber;
    /**
    * 
    */
    @DataValue(columnName = "Time")
    private Date Time;


}
