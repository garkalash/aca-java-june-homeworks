package com.aca.luiza.booking_task.internal.buyer;

import com.aca.luiza.booking_task.internal.ticket.Ticket;
import com.aca.luiza.booking_task.internal.transaction.Transaction;
import com.aca.luiza.booking_task.lib.clone.CustomCloneable;
import com.aca.luiza.booking_task.lib.json.Write;
import com.aca.luiza.booking_task.lib.string.RandomString;
import com.aca.luiza.booking_task.internal.buyer.Buyer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;
import java.util.concurrent.*;

public class TicketBuyingImpl {
    private final HashMap<String, ArrayList<Ticket>> ticketsByGenre;
    private final List<Buyer> buyers;
    private final JSONArray transactions;
    private final int limit = 5;
    private int count = 0;
    private final RandomString randomString;
    private final CustomCloneable cloneable;

    public TicketBuyingImpl(List<JSONObject> ticketList, List<JSONObject> buyerList) {
        ticketsByGenre = new HashMap<>();
        buyers = new ArrayList<>();
        transactions = new JSONArray();

        setBuyer(buyerList);
        setTicket(ticketList);

        cloneable = new CustomCloneable();
        randomString = new RandomString(10);
    }

    private void setTicket(List<JSONObject> ticketsList) {
        int index = 0;
        for (JSONObject ticket : ticketsList) {
            Ticket swap = new Ticket();

            String _id = (String) ticket.get("_id");
            String genre = (String) ticket.get("genre");
            float price = Float.parseFloat((String) ticket.get("price"));
            long ticketCount = (long) ticket.get("ticketCount");
            long year = (long) ticket.get("year");

            swap.set_id(_id);
            swap.setGenre(genre);
            swap.setPrice(price);
            swap.setTicketCount(ticketCount);
            swap.setYear(year);

            ticketsByGenre.computeIfAbsent(genre, k -> new ArrayList<Ticket>());
            if (swap.getGenre().equals(genre)) {
                for (int i = 0; i <= ticketCount; i++) {
                    try {
                        Ticket clone = (Ticket) swap.copy();
                        clone.setId(index);
                        ticketsByGenre.get(genre).add(clone);
                        index++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void setBuyer(List<JSONObject> buyersList) {
        for (JSONObject buyer : buyersList) {
            Buyer swap = new Buyer();

            long _id = (long) buyer.get("_id");
            long ticketCount = (long) buyer.get("ticketCount");
            swap.set_id(_id);
            swap.setTicketCount(ticketCount);

            buyers.add(swap);
        }
    }

    public synchronized void buyingTicket() {
        ExecutorService service = Executors.newFixedThreadPool(2);

        List<Ticket> tempListForFirstSellerPoint = new ArrayList<>();
        List<Ticket> tempListForSecondSellerPoint = new ArrayList<>();

        // Get a set of the entries
        Set set = ticketsByGenre.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry<String, Ticket> me = (Map.Entry<String, Ticket>) i.next();
            String key = me.getKey();
            List<Ticket> val = (List<Ticket>) me.getValue();
            int firstPart = val.size() / 2;
//            int secondPart = val.size() - firstPart;
            List<Ticket> firstList = val.subList(0, firstPart);
            List<Ticket> secondList = val.subList(firstPart, val.size());
            tempListForFirstSellerPoint.addAll(firstList);
            tempListForSecondSellerPoint.addAll(secondList);
        }

        Future<Boolean> s1 = service.submit(() -> provider(1, cloneable.cloneList(tempListForFirstSellerPoint)));
        Future<Boolean> s2 = service.submit(() -> provider(2, cloneable.cloneList(tempListForSecondSellerPoint)));

        service.shutdown();

        Write writeTransactions = new Write("src/main/java/com/aca/luiza/booking_task/resources/transactions.json");
        try {
            s1.get();
            s2.get();
            writeTransactions.open();
            writeTransactions.writeToFile(transactions.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean provider(int index, List<Ticket> ticketList) {
        int firstPart = ticketList.size() / 2;
        List<Ticket> firstList = ticketList.subList(0, firstPart);
        List<Ticket> secondList = ticketList.subList(firstPart, ticketList.size());
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Boolean> s1 = service.submit(() -> sellerPoints(index, 1, cloneable.cloneList(firstList)));
        Future<Boolean> s2 = service.submit(() -> sellerPoints(index, 2, cloneable.cloneList(secondList)));

        service.shutdown();

        try {
            s1.get();
            s2.get();
        } catch (Exception ignored) {}
        return true;
    }

    private boolean sellerPoints(int prov, int selp, List<Ticket> ticketList) {
        Iterator buyerIterator = buyers.iterator();
        Iterator ticketIterator = ticketList.iterator();
        while (buyerIterator.hasNext()) {
            Buyer buyer = (Buyer) buyerIterator.next();
            while (ticketIterator.hasNext()) {
                if (buyer.getTicketCount() > limit - 1) {
                    System.out.printf("You have crossed your ticket limit (%s) \n", buyer.getTicketCount());
                    break;
                } else {
                    Ticket ticket = (Ticket) ticketIterator.next();
                    ticketIterator.remove();
                    buyer.setTicketCount(buyer.getTicketCount() + 1);

                    this.transaction(prov, selp, buyer, ticket);
                }
            }
        }
        return true;
    }

    private void transaction(int prov, int selp, Buyer buyer, Ticket ticket) {
        Transaction txn = new Transaction();
        txn.setBuyerId((int) buyer.get_id());
        txn.setPrice(ticket.getPrice());
        txn.setProvider(prov);
        txn.setSellerPoint(selp);
        txn.setTicketIndex(ticket.getId());
        txn.setTicketId(ticket.get_id());
        txn.setTxnId(randomString.nextString());

        transactions.add(txn.toJSON());
    }
}
