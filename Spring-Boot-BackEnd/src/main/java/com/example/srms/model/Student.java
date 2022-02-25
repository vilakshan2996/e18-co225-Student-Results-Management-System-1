package com.example.srms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String user_name;

    @Column(name = "name")
    private String name;
    @Column(name = "batch_no")
    private int batch_no;
    @Column(name = "reg_no")
    private int reg_no;
    @Column(name = "password")
    private String password;

    public Student() {

    }

    public Student(String user_name, String name, int batch_no, int reg_no, String password) {
        this.user_name = user_name;
        this.name = name;
        this.batch_no = batch_no;
        this.reg_no = reg_no;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(int batch_no) {
        this.batch_no = batch_no;
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student [batch_no=" + batch_no + ", name=" + name + ", reg_no=" + reg_no + ", user_name=" + user_name
                + "]";
    }

}
