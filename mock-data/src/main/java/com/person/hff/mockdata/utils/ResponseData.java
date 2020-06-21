package com.person.hff.mockdata.utils;

import lombok.Data;

@Data
public class ResponseData {

    private String code = "00000";

    private Object data;

    private String msg = "Success";
}
