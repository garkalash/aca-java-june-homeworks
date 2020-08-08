package com.aca.files.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author: garik
 * @created: 8/8/2020, 9:08 AM
 */
public class Car {
    private String model;

    @SerializedName("horsePower")
    private Integer hp;

    private Integer carYear;
    private List<String> defects;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public List<String> getDefects() {
        return defects;
    }

    public void setDefects(List<String> defects) {
        this.defects = defects;
    }
}
