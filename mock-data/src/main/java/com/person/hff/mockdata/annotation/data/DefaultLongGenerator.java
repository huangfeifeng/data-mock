package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.NumberUtil;

public class DefaultLongGenerator implements LongGenerator {

    @Override
    public Long generate() {
        return NumberUtil.randomLong(1000000);
    }
}
