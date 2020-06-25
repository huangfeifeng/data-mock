package com.person.hff.mockdata.annotation.data;

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
        return integerGenerator.generate(null);
    }

    @Override
    public Long generateLong() {
        return longGenerator.generate(null);
    }

    @Override
    public BigDecimal generateBigDecimal() {
        return bigDecimalGenerator.generate(null);
    }

    @Override
    public Date generateDate() {
        return dateGenerator.generate(null);
    }

    @Override
    public String generateString() {
        return stringGenerator.generate(null);
    }
}
