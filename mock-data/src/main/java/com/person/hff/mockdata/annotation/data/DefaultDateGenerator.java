package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.DateUtil;

import java.util.Date;

public class DefaultDateGenerator implements DateGenerator {
    @Override
    public Date generate() {
        return DateUtil.nowDate();
    }
}
