package com.example.liquidityview;

import com.google.firebase.database.DataSnapshot;

public class UserInformation {
    private String billdue;
    private String name;
    private String weeklybudget;
    private String weeklysavings;

    public UserInformation(){

    }
    public String getBilldue() {
        return billdue;
    }

    public void setBilldue(String billdue) {
        this.billdue = billdue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeeklybudget() {
        System.out.println(weeklybudget);
        return weeklybudget;

    }

    public void setWeeklybudget(String weeklybudget) {
        this.weeklybudget = weeklybudget;
    }

    public String getWeeklysavings() {
        return weeklysavings;
    }

    public void setWeeklysavings(String weeklysavings) {
        this.weeklysavings = weeklysavings;
    }
}
