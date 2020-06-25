package com.person.hff.mockdata.service;

import com.person.hff.mockdata.enums.RequestTypeEnum;
import com.person.hff.mockdata.annotation.define.DataFamily;
import com.person.hff.mockdata.annotation.parse.DataFamilyParser;
import com.person.hff.mockdata.repository.CommonDao;
import com.person.hff.mockdata.utils.ClassScanner;
import com.person.hff.mockdata.utils.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class CommonService {

    public static final Map<String, DataFamily> dataFamilyMap = new HashMap<>();

    @Value("${entities.package.path}")
    private String entitiesPackagePath;

    @Autowired
    private CommonDao commonDao;

    public ResponseData doService(String tableName, Map<String,Object> map) {
        ResponseData responseData = new ResponseData();

        DataFamily dataFamily = dataFamilyMap.get(tableName);
        log.info("tableName : {}, 获取到dataFamily: {}", tableName, dataFamily);
        if(null != dataFamily) {
            String requestType = (String) map.get("requestType");
            List data = (List) map.get("data");

            log.info("requestType: {}, data: {}", requestType, data);

            if(RequestTypeEnum.POST.getType().equals(requestType)) {
                commonDao.insert(tableName, data);
            } else if(RequestTypeEnum.GET.getType().equals(requestType)) {
                List<Object> dataList = commonDao.select(tableName, data, dataFamily);
                responseData.setData(dataList);
            } else if(RequestTypeEnum.PUT.getType().equals(requestType)) {
                commonDao.update(tableName, data);

            } else if(RequestTypeEnum.DELETE.getType().equals(requestType)) {
                commonDao.delete(tableName, data);
            } else {
                log.error("不支持请求类型：{}", requestType);
            }

        }
        return responseData;
    }

    @PostConstruct
    public void parse() {
        log.info("entitiesPackagePath : {}", entitiesPackagePath);
        //String packagePath =  "com.person.hff.mockdata.entities";
        Set<Class> classes = ClassScanner.getClasses(entitiesPackagePath);

        for (Class clazz: classes) {
            DataFamily dataFamily = DataFamilyParser.parse(clazz);
            if(null != dataFamily) {
                dataFamilyMap.put(dataFamily.getTableName(), dataFamily);
            }
        }
    }


}
