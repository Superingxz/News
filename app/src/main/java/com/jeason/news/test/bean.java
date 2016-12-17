package com.jeason.news.test;

/**
 * Created by Administrator on 2016/12/17.
 */

public class bean {
    private String title1;
    private String titel2;

    public bean(String title1, String titel2) {
        this.title1 = title1;
        this.titel2 = titel2;
    }

    public bean() {
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitel2() {
        return titel2;
    }

    public void setTitel2(String titel2) {
        this.titel2 = titel2;
    }
}
