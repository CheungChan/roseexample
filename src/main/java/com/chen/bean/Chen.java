package com.chen.bean;


public class Chen {
    private String chen1;
    private String chen2;

    public String getChen1() {
        return chen1;
    }

    public void setChen1(String chen1) {
        this.chen1 = chen1;
    }

    public String getChen2() {
        return chen2;
    }

    public void setChen2(String chen2) {
        this.chen2 = chen2;
    }
    @Override
    public String toString() {
        return "Chen{" +
                "chen1='" + chen1 + '\'' +
                ", chen2='" + chen2 + '\'' +
                '}';
    }
}
