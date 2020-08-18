package com.aca.armine.multithreading;

import java.util.concurrent.*;

public class TicketsDemo {

    public static void main(String[] args) throws InterruptedException {
        JsonConverterFilm jsonConverterFilm = new JsonConverterFilm();
        ExecutorService ex = Executors.newScheduledThreadPool(2);
        Semaphore semaphore = new Semaphore(2);

        ConcurrentMap<String, Integer> films1 = jsonConverterFilm.readFromJson();
        ConcurrentMap<String, Integer> films2 = jsonConverterFilm.readFromJson();

        TicketProviderCompany company1 = new TicketProviderCompany("Company1",films1);
        TicketProviderCompany company2 = new TicketProviderCompany("Company2",films2);
        Seller seller1 = new Seller("seller1",company1,semaphore,new Buyer("action", 4));
        Seller seller2 = new Seller("seller2",company1, semaphore,new Buyer("comedy",3));
        Seller seller3 = new Seller("seller3",company2, semaphore,new Buyer("politicial",3));
        Seller seller4 = new Seller("seller4",company2, semaphore,new Buyer("drama", 6));

        ex.submit(seller1);
        ex.submit(seller2);
        ex.submit(seller3);
        ex.submit(seller4);
        ex.shutdown();
        ex.awaitTermination(10000,TimeUnit.MILLISECONDS);

        jsonConverterFilm.writeInJson1(Seller.transactions);


    }
}
