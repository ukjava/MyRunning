package com.ukjava.myrunning.module.check.been;

import java.io.Serializable;

public class CheckUserBeen implements Serializable {
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    private String flag;
}
