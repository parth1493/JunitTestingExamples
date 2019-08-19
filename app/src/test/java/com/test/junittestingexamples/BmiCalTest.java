package com.test.junittestingexamples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BmiCalTest
{
    @Test
    @DisplayName("calculate BMI to two places correctly via inches and pounds")
    void calculateCorrectly() {
        assertEquals(19.2, BmiCal.calBmi(69, 130));
        assertEquals(21.52, BmiCal.calBmi(70, 150));
    }
}