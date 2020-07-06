package com.aca.files.model;

public class Order {
    private String id;
    private int price;
    private String soldDate;
    private User buyer;
    private User seller;
    private Car car;

    public Order(String id, int price, String soldDate, User buyer, User seller, Car car) {
        this.id = id;
        this.price = price;
        this.soldDate = soldDate;
        this.buyer = buyer;
        this.seller = seller;
        this.car = car;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
