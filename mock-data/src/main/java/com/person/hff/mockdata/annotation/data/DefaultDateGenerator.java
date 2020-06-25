package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.DateUtil;

import java.util.Date;

public class DefaultDateGenerator extends AbstractGenerator implements DateGenerator {
    @Override
    public Date generate(String type) {
        return DateUtil.nowDate();
    }
}
