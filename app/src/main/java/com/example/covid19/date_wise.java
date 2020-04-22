package com.example.covid19;

public class date_wise {
    private String date;
    private String dailyconfirmed;
    private String dailydeceased;
    private String dailyrecovered;
    private String totalconfirmed;
    private String totaldeceased;
    private String totalrecovered;


    public date_wise(String date, String dailyconfirmed, String dailydeceased, String dailyrecovered, String totalconfirmed, String totaldeceased, String totalrecovered) {
        this.date = date;
        this.dailyconfirmed = dailyconfirmed;
        this.dailydeceased = dailydeceased;
        this.dailyrecovered = dailyrecovered;
        this.totalconfirmed = totalconfirmed;
        this.totaldeceased = totaldeceased;
        this.totalrecovered = totalrecovered;
    }

    public String getDate() {
        return date;
    }

    public String getDailyconfirmed() {
        return dailyconfirmed;
    }

    public String getDailydeceased() {
        return dailydeceased;
    }

    public String getDailyrecovered() {
        return dailyrecovered;
    }

    public String getTotalconfirmed() {
        return totalconfirmed;
    }

    public String getTotaldeceased() {
        return totaldeceased;
    }

    public String getTotalrecovered() {
        return totalrecovered;
    }
}
