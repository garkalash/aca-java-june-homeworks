package com.aca.naresilanyan.jsonHomework;

import java.math.BigDecimal;

public class Employee {
    private String _id;
    private Integer index;
    private Double balance;
    private Double salary;
    private Integer age;
    private String email;
    private String phone;
    private String birthdate;
    private String section;



    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthday) {
        this.birthdate = birthday;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + _id + '\'' +
                ", index=" + index +
                ", balance=" + balance +
                ", salary=" + salary +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthdate + '\'' +
                ", section='" + section + '\'' +
                '}';
    }


}
