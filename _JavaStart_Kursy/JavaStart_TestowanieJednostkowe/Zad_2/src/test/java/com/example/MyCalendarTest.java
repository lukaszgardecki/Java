package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTest {
    private MyCalendar myCalendar;

    @BeforeEach
    public void init() {
        myCalendar = new MyCalendar();
    }

    @ParameterizedTest(name = "{0}-{1} -> {2}")
    @CsvSource({
            "2018, 6, 30",
            "2018, 7, 31",
            "2018, 8, 31",
            "2018, 2, 28",
            "2016, 2, 29",
            "2010, 2, 28",
            "2100, 2, 28",
            "2000, 2, 29",
    })
    public void test(int year, int month, int days) {
        int result = myCalendar.getDayCount(year, month);
        assertEquals(days, result);
    }


//    @DisplayName("2018-06 -> 30")
//    @Test
//    public void shouldGet30For2018June() {
//        int result = myCalendar.getDayCount(2018, 6);
//        //then
//        assertEquals(30, result);
//    }
//
//    @DisplayName("2018-07 -> 31")
//    @Test
//    public void shouldGet31For2018July() {
//        int result = myCalendar.getDayCount(2018, 7);
//        //then
//        assertEquals(31, result);
//    }
//
//    @DisplayName("2018-08 -> 31")
//    @Test
//    public void shouldGet31For2018August() {
//        int result = myCalendar.getDayCount(2018, 8);
//        //then
//        assertEquals(31, result);
//    }
//
//    @DisplayName("2018-02 -> 28")
//    @Test
//    public void shouldGet28For2018February() {
//        int result = myCalendar.getDayCount(2018, 2);
//        //then
//        assertEquals(28, result);
//    }
//
//    @DisplayName("2016-02 -> 29")
//    @Test
//    public void shouldGet29For2016February() {
//        int result = myCalendar.getDayCount(2016, 2);
//        //then
//        assertEquals(29, result);
//    }
//
//    @DisplayName("2010-02 -> 28")
//    @Test
//    public void shouldGet28For2010February() {
//        int result = myCalendar.getDayCount(2010, 2);
//        //then
//        assertEquals(28, result);
//    }
//
//    @DisplayName("2100-02 -> 28")
//    @Test
//    public void shouldGet28For2100June() {
//        int result = myCalendar.getDayCount(2100, 2);
//        //then
//        assertEquals(28, result);
//    }
//
//    @DisplayName("2000-02 -> 29")
//    @Test
//    public void shouldGet29For2000June() {
//        int result = myCalendar.getDayCount(2000, 2);
//        //then
//        assertEquals(29, result);
//    }
}