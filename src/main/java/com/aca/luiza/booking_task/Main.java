package com.aca.luiza.booking_task;

import com.aca.luiza.booking_task.internal.buyer.TicketBuyingImpl;
import com.aca.luiza.booking_task.lib.json.Read;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Read tickets = new Read("src/main/java/com/aca/luiza/booking_task/resources/tickets.json");
        Read buyers = new Read("src/main/java/com/aca/luiza/booking_task/resources/buyers.json");

        try {
            tickets.open();
            buyers.open();
            Object ticketData = tickets.readFromFile();
            Object buyerData = buyers.readFromFile();

            List<JSONObject> ticketList = (List<JSONObject>) ticketData;
            List<JSONObject> buyerList = (List<JSONObject>) buyerData;
            TicketBuyingImpl impl = new TicketBuyingImpl(ticketList, buyerList);
            impl.buyingTicket();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
