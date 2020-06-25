package com.person.hff.mockdata.annotation.data;

import com.person.hff.mockdata.enums.DataType;

import java.util.HashMap;
import java.util.Map;

public class DefaultGenerator extends AbstractGenerator {

    private final static Map<String, AbstractGenerator> generatorMap = new HashMap<>();

    static {
        generatorMap.put(DataType.STRING.getType(), new DefaultStringGenerator());
        generatorMap.put(DataType.INTEGER.getType(), new DefaultIntegerGenerator());
        generatorMap.put(DataType.LONG.getType(), new DefaultLongGenerator());
        generatorMap.put(DataType.DATE.getType(), new DefaultDateGenerator());
        generatorMap.put(DataType.BIGDECIMAL.getType(), new DefaultBigDecimalGenerator());
    }

    @Override
    public Object generate(String type) {
        return generatorMap.get(type).generate(type);
    }

    private static DefaultGenerator instance = new DefaultGenerator();

    private DefaultGenerator() {}

    public static DefaultGenerator getInstance() {
        return instance;
    }
}
