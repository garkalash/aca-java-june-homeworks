package com.aca.luiza.booking_task.internal.transaction;

import com.aca.luiza.booking_task.lib.clone.CustomCloneable;
import org.json.simple.JSONObject;

public class Transaction extends CustomCloneable {
    private int provider;
    private float price;
    private int sellerPoint;
    private int buyerId;
    private String ticketId;
    private int ticketIndex;
    private String txnId;

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSellerPoint() {
        return sellerPoint;
    }

    public void setSellerPoint(int sellerPoint) {
        this.sellerPoint = sellerPoint;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketIndex() {
        return ticketIndex;
    }

    public void setTicketIndex(int ticketIndex) {
        this.ticketIndex = ticketIndex;
    }


    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("provider", getProvider());
        jsonObject.put("buyerId", getBuyerId());
        jsonObject.put("txnId", getTxnId());
        jsonObject.put("ticketId", getTicketId());
        jsonObject.put("ticketIndex", getTicketIndex());
        jsonObject.put("sellerPoint", getSellerPoint());
        jsonObject.put("price", getPrice());
        return jsonObject;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "provider=" + provider +
                ", price=" + price +
                ", sellerPoint=" + sellerPoint +
                ", buyerId=" + buyerId +
                ", ticketId=" + ticketId +
                ", ticketIndex=" + ticketIndex +
                ", txnId='" + txnId + '\'' +
                '}';
    }
}
