package com.person.hff.mockdata.controller;

import com.person.hff.mockdata.service.CommonService;
import com.person.hff.mockdata.utils.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/{tableName}", method = RequestMethod.POST)
    public ResponseData request(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map) {
        log.info("tableName : {}, map : {}", tableName, map);

        ResponseData responseData = commonService.doService(tableName, map);

        return responseData;
    }
}
