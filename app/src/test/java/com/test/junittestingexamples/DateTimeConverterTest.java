package com.test.junittestingexamples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Date time converter test")
class DateTimeConverterTest
{
    @Nested
    class TodayTests
    {
        @Test
        @DisplayName("convert string with today keyword correctly ")
        void convertTodayStringConrrectly()
        {
            LocalDate today = LocalDate.of(2019,8,18);
            LocalDateTime result = DateTimeConverter.convertToDateTimeFromString("today 2:00 pm", today);
            assertEquals(result,LocalDateTime.of(2019,8,18,14,0),()->"Failed to convert today string to expected date time passed was "+today);
        }

        @Test
        @DisplayName("convert string with today keyword correctly regardless of case")
        void convertTodayStringConrectlyCaseInsensitive()
        {
            LocalDate today = LocalDate.of(2019,8,18);
            LocalDateTime result = DateTimeConverter.convertToDateTimeFromString("ToDay 2:00 pm", today);
            assertEquals(result,LocalDateTime.of(2019,8,18,14,0),()->"Failed to convert today string to expected date time passed was "+today);
        }
    }


    @Test
    @DisplayName("convert expected date time pattern in string correctly")
    void convertTodayPatternToDateTime()
    {
        LocalDateTime result = DateTimeConverter.convertToDateTimeFromString("8/19/2019 2:00 pm", LocalDate.of(2019,8,18));
        assertEquals(result,LocalDateTime.of(2019,8,19,14,0));
    }

    @Test
    @DisplayName("Throws run time exception")
    void throwsExceptionIfIncorrectPatternProvided()
    {
        Throwable error =assertThrows(RuntimeException.class,()-> DateTimeConverter.convertToDateTimeFromString("today 100:00 pm", LocalDate.of(2019,8,18)));
        assertEquals("Unable to create date time from [TODAY 100:00 PM], please enter with formant [M/d/yyyy h:mm a]",error.getMessage());
    }
}