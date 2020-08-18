package com.aca.armine.multithreading;

public class Transaction {
    Seller seller;
    String genre;
    Integer count;

    public Transaction(Seller seller, String genre, Integer count) {
        this.seller = seller;
        this.genre = genre;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "seller: " + seller.getSellerName() +
                ", company: " + seller.getCompany().getName() +
                ", genre: " + genre +
                ", count: " + count +
                "}" ;
    }
}
