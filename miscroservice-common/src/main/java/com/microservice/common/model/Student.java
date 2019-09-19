package com.microservice.common.model;

import javax.persistence.*;

@Table(name = "student")
public class Student {
    /**
     * 主键
     */
    @Id
    @Column(name = "stu_no")
    @GeneratedValue(generator = "JDBC")
    private String stuNo;

    /**
     * 学生姓名
     */
    @Column(name = "stu_name")
    private String stuName;

    /**
     * 学生所在班级
     */
    @Column(name = "stu_class")
    private String stuClass;

    /**
     * 来源数据库
     */
    @Column(name = "db_source")
    private String dbSource;

    /**
     * 获取主键
     *
     * @return stu_no - 主键
     */
    public String getStuNo() {
        return stuNo;
    }

    /**
     * 设置主键
     *
     * @param stuNo 主键
     */
    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    /**
     * 获取学生姓名
     *
     * @return stu_name - 学生姓名
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * 设置学生姓名
     *
     * @param stuName 学生姓名
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * 获取学生所在班级
     *
     * @return stu_class - 学生所在班级
     */
    public String getStuClass() {
        return stuClass;
    }

    /**
     * 设置学生所在班级
     *
     * @param stuClass 学生所在班级
     */
    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    /**
     * 获取来源数据库
     *
     * @return db_source - 来源数据库
     */
    public String getDbSource() {
        return dbSource;
    }

    /**
     * 设置来源数据库
     *
     * @param dbSource 来源数据库
     */
    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}