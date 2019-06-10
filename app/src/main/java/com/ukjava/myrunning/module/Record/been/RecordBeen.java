package com.ukjava.myrunning.module.Record.been;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecordBeen implements Serializable {
    public List<stp> getStps() {
        return stps;
    }

    public void setStps(List<RecordBeen.stp> stps) {
        this.stps = stps;
    }

    private List<stp> stps;

    public class stp{
    private int id;
    private String name;
    private String step;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getStep() {
        return step;

    }
    }
}
