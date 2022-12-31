package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Date;

public class MyCalendar {

//    int getDayCount(int year, int month) {
//        switch (month) {
//            case 1, 3, 5, 7, 8, 10, 12 -> {
//                return 31;
//            }
//            case 4, 6, 9, 11 -> {
//                return 30;
//            }
//        }
//        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? 29 : 28;
//    }

    int getDayCount(int year, int month) {
        return YearMonth.of(year, month).lengthOfMonth();
    }
}
