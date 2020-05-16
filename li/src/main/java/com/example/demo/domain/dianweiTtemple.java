package com.example.demo.domain;

import java.util.Date;

public class dianweiTtemple {
    private String id;

    private String name;

    private String type;

    private String q1;

    private String q2;

    private String q3;

    private String q4;

    private String q5;

    private String q6;

    private String q7;

    private String q8;

    public dianweiTtemple(String id, String name, String type, String q1, String q2, String q3, String q4, String q5, String q6, String q7, String q8) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
    }

    public dianweiTtemple() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1 == null ? null : q1.trim();
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2 == null ? null : q2.trim();
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3 == null ? null : q3.trim();
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4 == null ? null : q4.trim();
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5 == null ? null : q5.trim();
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6 == null ? null : q6.trim();
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7 == null ? null : q7.trim();
    }

    public String getQ8() {
        return q8;
    }

    public void setQ8(String q8) {
        this.q8 = q8 == null ? null : q8.trim();
    }


}