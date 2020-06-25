package com.person.hff.mockdata.annotation.data.custom;

import com.person.hff.mockdata.annotation.data.ValueStrategy;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class CustomValueStrategy implements ValueStrategy {
    @Override
    public Integer generateInteger() {
        return 100;
    }

    @Override
    public Long generateLong() {
        return 1000L;
    }

    @Override
    public BigDecimal generateBigDecimal() {
        return BigDecimal.ONE;
    }

    @Override
    public Date generateDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    @Override
    public String generateString() {
        return "张三";
    }
}
