package com.demo.comentoStatistic.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {

    public Set<LocalDate> getHolidays(String yearMonth) {
        return new HashSet<>();
    }
}
