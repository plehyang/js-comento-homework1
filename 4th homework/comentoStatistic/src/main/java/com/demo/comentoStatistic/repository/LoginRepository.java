package com.demo.comentoStatistic.repository;

import com.demo.comentoStatistic.domain.LoginRecord;
import java.util.List;

public interface LoginRepository {
    List<LoginRecord> findByYearMonth(String yearMonth);
}
