package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.NumberUtil;

public class DefaultLongGenerator extends AbstractGenerator implements LongGenerator {

    @Override
    public Long generate(String type) {
        return NumberUtil.randomLong(1000000);
    }
}
