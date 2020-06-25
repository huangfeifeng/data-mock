package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.NumberUtil;

public class DefaultIntegerGenerator extends AbstractGenerator implements IntegerGenerator {

    @Override
    public Integer generate(String type) {
        return NumberUtil.random(100);
    }
}
