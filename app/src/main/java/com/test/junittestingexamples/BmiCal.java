package com.test.junittestingexamples;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BmiCal
{
    static double calBmi(Integer height, Integer weight) {
        Double bmi = (double) (weight * 703) / (height * height);
        return new BigDecimal(bmi).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
