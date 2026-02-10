package com.demo.comentoStatistic.domain;

import java.time.LocalDate;

public class LoginRecord {

    private LocalDate loginDate;

    public LoginRecord(LocalDate loginDate) {
        this.loginDate = loginDate;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }
}
