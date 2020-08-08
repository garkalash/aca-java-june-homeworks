package com.aca.files.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author: garik
 * @created" 8/8/2020, 9:08 AM
 */
public class User {
    @SerializedName("first")
    private String name;
    private String last;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
