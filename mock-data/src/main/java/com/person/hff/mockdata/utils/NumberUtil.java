package com.person.hff.mockdata.utils;

import java.math.BigDecimal;
import java.util.Random;

public class NumberUtil {
    private static Random random = new Random();
    public static Integer random(int max) {
        return random.nextInt(max);
    }

    public static Long randomLong(int max) {
        return Long.valueOf(random.nextInt(max));
    }

    public static BigDecimal randomBigDecimal(int max) {
       return BigDecimal.valueOf(random.nextDouble() * max);
    }
}
