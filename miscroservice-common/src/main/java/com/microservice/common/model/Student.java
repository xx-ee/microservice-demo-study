package com.microservice.common.model;

import javax.persistence.*;

@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String sid;

    private String name;

    private String sex;

    private String score;

    /**
     * @return sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(String score) {
        this.score = score;
    }
}