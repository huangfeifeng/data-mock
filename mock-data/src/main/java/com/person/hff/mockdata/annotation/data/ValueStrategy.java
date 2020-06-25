package com.person.hff.mockdata.annotation.data;

import java.math.BigDecimal;
import java.util.Date;

public interface ValueStrategy {
    public Integer generateInteger();

    public Long generateLong();

    public BigDecimal generateBigDecimal();

    public Date generateDate();

    public String generateString();
}
