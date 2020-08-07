package com.aca.streams.employeesJson;

public class Employee {
    private String id;
    private Long index;
    private String balance;
    private String salary;
    private Long age;
    private String email;
    private String phone;
    private String birthDay;
    private String section;

    @Override
    public String toString() {
        return "\nEmployee{\n" +
                "id=" + id + '\n' +
                "index=" + index + '\n' +
                "balance=" + balance + '\n' +
                "salary=" + salary + '\n' +
                "age=" + age + '\n' +
                "email=" + email + '\n' +
                "phone=" + phone + '\n' +
                "birthDay=" + birthDay + '\n' +
                "section=" + section + '\n' +
                '}' + '\n';
    }

    public Employee(String id, Long index, String balance, String salary, Long age, String email, String phone,
                    String birthDay, String section) {
        this.id = id;
        this.index = index;
        this.balance = balance;
        this.salary = salary;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.section = section;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
