package com.aca.armine.multithreading;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class Seller extends Thread {
    private TicketProviderCompany company;
    private Semaphore sem;
    private Buyer buyer;
    private String sellerName;
    static CopyOnWriteArrayList<String> transactions= new CopyOnWriteArrayList<>();


    public Seller(String name,TicketProviderCompany company, Semaphore sem, Buyer buyer) {
        this.sellerName = name;
        this.buyer = buyer;
        this.company = company;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            Integer newCount = company.getFilms().get(buyer.getGenre()) - buyer.getCount();
            company.getFilms().replace(buyer.getGenre(), newCount);
            transactions.add(new Transaction(this, buyer.getGenre(),buyer.getCount()).toString());
            System.out.println(transactions.toString());
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }

    public TicketProviderCompany getCompany() {
        return company;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public String getSellerName() {
        return sellerName;
    }
}
