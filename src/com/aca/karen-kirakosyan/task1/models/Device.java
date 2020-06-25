package models;

import enums.RecordType;

import java.util.List;

public abstract class Device {
    protected List<RecordType> recordTypes;
    protected int memorySize;
    protected int hours;
    protected int price;

    public Device(List<RecordType> recordTypes, int memorySize, int hours, int price) {
        this.recordTypes = recordTypes;
        this.memorySize = memorySize;
        this.hours = hours;
        this.price = price;
    }

    public List<RecordType> getRecordTypes() {
        return recordTypes;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getHours() {
        return hours;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Device type is " + getClass().getSimpleName() +
                " recordTypes=" + recordTypes +
                ", memorySize=" + memorySize  + " GB " +
                ", hours=" + hours  + " hours " +
                ", price=" + price  + " AMD" +
                '}' + "\n";
    }
}
