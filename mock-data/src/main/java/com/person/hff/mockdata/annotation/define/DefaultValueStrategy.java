package com.person.hff.mockdata.annotation.define;

import com.person.hff.mockdata.annotation.data.*;

import java.math.BigDecimal;
import java.util.Date;

public class DefaultValueStrategy implements ValueStrategy {
    private IntegerGenerator integerGenerator = new DefaultIntegerGenerator();

    private LongGenerator longGenerator = new DefaultLongGenerator();

    private BigDecimalGenerator bigDecimalGenerator = new DefaultBigDecimalGenerator();

    private DateGenerator dateGenerator = new DefaultDateGenerator();

    private StringGenerator stringGenerator = new DefaultStringGenerator();

    @Override
    public Integer generateInteger() {
        return integerGenerator.generate();
    }

    @Override
    public Long generateLong() {
        return longGenerator.generate();
    }

    @Override
    public BigDecimal generateBigDecimal() {
        return bigDecimalGenerator.generate();
    }

    @Override
    public Date generateDate() {
        return dateGenerator.generate();
    }

    @Override
    public String generateString() {
        return stringGenerator.generate();
    }
}
