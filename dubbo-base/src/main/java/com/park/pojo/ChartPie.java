package com.park.pojo;

import java.io.Serializable;

public class ChartPie implements Serializable {
    private double value;

    private String name;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
