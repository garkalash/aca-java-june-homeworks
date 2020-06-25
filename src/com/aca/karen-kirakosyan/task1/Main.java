import enums.RecordType;
import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<RecordType> recordTypesForFirstPen = new ArrayList<>();
        recordTypesForFirstPen.add(RecordType.MP4);
        recordTypesForFirstPen.add(RecordType.VGA);
        Device pen1 = new Pen(recordTypesForFirstPen, 2, 5, 20000);

        List<RecordType> recordTypesForSecondPen = new ArrayList<>();
        recordTypesForSecondPen.add(RecordType.MP3);
        Device pen2 = new Pen(recordTypesForSecondPen, 4, 8, 30000);


        List<RecordType> recordTypesForFirstUsbFlash = new ArrayList<>();
        recordTypesForFirstUsbFlash.add(RecordType.MP4);
        recordTypesForFirstUsbFlash.add(RecordType.VGA);
        Device usbFlash1 = new UsbFlash(recordTypesForFirstUsbFlash, 0, 3, 15000);


        List<RecordType> recordTypesForFirstWatch = new ArrayList<>();
        recordTypesForFirstWatch.add(RecordType.MP3);
        recordTypesForFirstWatch.add(RecordType.MP4);
        recordTypesForFirstUsbFlash.add(RecordType.HD);
        Device watch1 = new Watch(recordTypesForFirstWatch, 4, 9, 25000);


        Map<Device, Integer> deviceQuantities = new HashMap<>();
        deviceQuantities.put(pen1, 3);
        deviceQuantities.put(pen2, 5);
        deviceQuantities.put(usbFlash1, 4);
        deviceQuantities.put(watch1, 2);

        Manager manager = new Manager(deviceQuantities);


        manager.sellItem(pen1);
        manager.getLeftItemsAmount();
        manager.getSoldItemsAmount();
        manager.changePrice(pen1, 10000);
        manager.getLeftItemsAmount();
        manager.changePrice(watch1, 30000);
        manager.getLeftItemsAmount();

        List<Device> hdDevices = manager.getDevicesByRecordType(RecordType.VGA);


        System.out.println(hdDevices.toString());

    }
}
