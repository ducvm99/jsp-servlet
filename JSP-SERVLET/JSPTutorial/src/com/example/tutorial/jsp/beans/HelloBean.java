package com.example.tutorial.jsp.beans;

public class HelloBean {
    private String name;

    // Bắt buộc phải có cấu tử không tham số.
    public HelloBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHello() {
        if (name == null) {
            return "Hello every body";
        }
        return "Hello " + name;
    }
}
