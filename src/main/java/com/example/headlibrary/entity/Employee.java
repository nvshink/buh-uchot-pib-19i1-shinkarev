package com.example.headlibrary.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String department;

    private String post;

    private String contact;

    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private Date dateEmployment;

    public Employee(int id, String name, String department, String post, String contact, Date dateEmployment) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.post = post;
        this.contact = contact;
        this.dateEmployment = dateEmployment;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDateEmployment() {
        return dateEmployment;
    }

    public void setDateEmployment(Date date_employment) {
        this.dateEmployment = date_employment;
    }
}
