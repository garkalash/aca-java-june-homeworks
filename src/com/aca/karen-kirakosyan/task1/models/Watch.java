package models;

import enums.RecordType;

import java.util.List;

public class Watch extends Device{

    public Watch(List<RecordType> recordTypes, int memorySize, int hours, int price) {
        super(recordTypes, memorySize, hours, price);
    }
}
