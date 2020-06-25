package models;

import enums.RecordType;

import java.util.List;

public class Pen extends Device {

    public Pen(List<RecordType> recordTypes, int memorySize, int hours, int price) {
        super(recordTypes, memorySize, hours, price);
    }

}
