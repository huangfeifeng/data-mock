package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.NumberUtil;

import java.math.BigDecimal;

public class DefaultBigDecimalGenerator implements BigDecimalGenerator {

    @Override
    public BigDecimal generate() {
        return NumberUtil.randomBigDecimal(10000);
    }
}
