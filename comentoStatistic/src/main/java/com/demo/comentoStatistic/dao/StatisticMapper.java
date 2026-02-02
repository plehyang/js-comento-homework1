package com.demo.comentoStatistic.dao;

@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);

}
