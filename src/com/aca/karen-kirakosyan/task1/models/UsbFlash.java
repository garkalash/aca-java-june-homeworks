package models;

import enums.RecordType;

import java.util.List;

public class UsbFlash extends Device{

    public UsbFlash(List<RecordType> recordTypes, int memorySize, int hours, int price) {
        super(recordTypes, memorySize, hours, price);
    }
}
