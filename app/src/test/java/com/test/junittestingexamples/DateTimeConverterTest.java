package com.test.junittestingexamples;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeConverterTest
{
    @Test
    void convertTodayStringConrrectly()
    {
        LocalDateTime result = DateTimeConverter.convertToDateTimeFromString("today 2:00 pm", LocalDate.of(2019,8,18));
        assertEquals(result,LocalDateTime.of(2018,8,18,14,0));
    }

    @Test
    void convertTodayPatternToDateTime()
    {
        LocalDateTime result = DateTimeConverter.convertToDateTimeFromString("8/18/2019 2:00 pm", LocalDate.of(2019,8,18));
        assertEquals(result,LocalDateTime.of(2018,8,19,14,0));
    }

    @Test
    void throwsExceptionIfIncorrectPatternProvided()
    {
        Throwable error =assertThrows(RuntimeException.class,()-> DateTimeConverter.convertToDateTimeFromString("today 100:00 pm", LocalDate.of(2019,8,18)));
        assertEquals("Unable to create date tine from [TODAY 100:00 PM], please enter with formant [M/d/yyyy h:mm a]",error.getMessage());
    }
}