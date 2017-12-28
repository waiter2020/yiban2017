package com.yiban.demo.model;

import javax.persistence.*;

/**
 * Created by dalao on 17-12-26.
 */
@Entity
@Table(name = "dalao")
public class Dalao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int 序号;
    private String 部门;
    private String 职位;
    private String 姓名;
    private String 性别;
    private String 专业班级;
    private String 联系方式;
    public Dalao(){}

    public Dalao(int 序号,String 部门, String 职位, String 姓名, String 性别, String 专业班级, String 联系方式) {
        this.序号 = 序号;
        this.部门 = 部门;
        this.职位 = 职位;
        this.姓名 = 姓名;
        this.性别 = 性别;
        this.专业班级 = 专业班级;
        this.联系方式 = 联系方式;
    }
    public Dalao(String 部门, String 职位, String 姓名, String 性别, String 专业班级, String 联系方式) {
        this.部门 = 部门;
        this.职位 = 职位;
        this.姓名 = 姓名;
        this.性别 = 性别;
        this.专业班级 = 专业班级;
        this.联系方式 = 联系方式;
    }

    public int get序号() {
        return 序号;
    }

    public void set序号(int 序号) {
        this.序号 = 序号;
    }

    public String get部门() {
        return 部门;
    }

    public void set部门(String 部门) {
        this.部门 = 部门;
    }

    public String get职位() {
        return 职位;
    }

    public void set职位(String 职位) {
        this.职位 = 职位;
    }

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }

    public String get专业班级() {
        return 专业班级;
    }

    public void set专业班级(String 专业班级) {
        this.专业班级 = 专业班级;
    }

    public String get联系方式() {
        return 联系方式;
    }

    public void set联系方式(String 联系方式) {
        this.联系方式 = 联系方式;
    }
}
