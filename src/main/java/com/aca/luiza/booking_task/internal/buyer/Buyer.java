package com.aca.luiza.booking_task.internal.buyer;

import com.aca.luiza.booking_task.lib.clone.CustomCloneable;

public class Buyer extends CustomCloneable {
    private long _id;
    private long ticketCount;

    public long get_id() {
        return _id;
    }



    public void set_id(long _id) {
        this._id = _id;
    }

    public long getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(long ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "_id=" + _id +
                ", ticketCount=" + ticketCount +
                '}';
    }
}
