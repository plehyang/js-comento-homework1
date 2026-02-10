package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.repository.LoginRepository;
import com.demo.comentoStatistic.domain.LoginRecord;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private HolidayService holidayService; // 공공API 또는 DB에서 휴일 조회

    public Map<String, Integer> getLoginCountExcludingHolidays(String yearMonth) {
        // 1. 해당 월 로그인 데이터 조회
        List<LoginRecord> logins = loginRepository.findByYearMonth(yearMonth);

        // 2. 휴일 목록 조회
        Set<LocalDate> holidays = holidayService.getHolidays(yearMonth);

        // 3. 휴일 제외 집계
        Map<String, Integer> result = new HashMap<>();
        logins.stream()
              .filter(login -> !holidays.contains(login.getLoginDate()))
              .collect(Collectors.groupingBy(
                  login -> login.getLoginDate().toString(),
                  Collectors.summingInt(l -> 1)
              ))
              .forEach(result::put);

        return result;
    }
}
