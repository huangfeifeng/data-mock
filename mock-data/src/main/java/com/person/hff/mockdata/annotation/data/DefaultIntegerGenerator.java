package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.NumberUtil;

public class DefaultIntegerGenerator implements IntegerGenerator {

    @Override
    public Integer generate() {
        return NumberUtil.random(100);
    }
}
