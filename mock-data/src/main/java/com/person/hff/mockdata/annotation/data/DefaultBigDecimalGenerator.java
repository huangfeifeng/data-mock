package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.utils.NumberUtil;

import java.math.BigDecimal;

public class DefaultBigDecimalGenerator extends AbstractGenerator implements BigDecimalGenerator {

    @Override
    public BigDecimal generate(String type) {
        return NumberUtil.randomBigDecimal(10000);
    }

    public static void main(String[] args) {
        AbstractGenerator defaultBigDecimalGenerator = new DefaultBigDecimalGenerator();
        Object generate = defaultBigDecimalGenerator.generate(null);
        System.out.println(generate);
    }
}
