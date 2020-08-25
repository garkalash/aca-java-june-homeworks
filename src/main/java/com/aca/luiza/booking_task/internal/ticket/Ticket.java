package com.aca.luiza.booking_task.internal.ticket;

import com.aca.luiza.booking_task.lib.clone.CustomCloneable;

import java.util.ArrayList;
import java.util.List;

public class Ticket extends CustomCloneable {
    private int id;
    private String _id;
    private String genre;
    private float price;
    private long ticketCount;
    private long year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(long ticketCount) {
        this.ticketCount = ticketCount;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", _id='" + _id + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", ticketCount=" + ticketCount +
                ", year=" + year +
                '}';
    }
}
