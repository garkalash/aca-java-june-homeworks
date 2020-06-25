import enums.RecordType;
import models.Device;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {
    private Map<Device, Integer> devices;
    private int soldItemsAmount;
    private int leftItemsAmount;

    public Manager(Map<Device, Integer> devices) {
        this.devices = devices;
        soldItemsAmount = 0;
        leftItemsAmount = allItemsAmount();
    }

    public void sellItem(Device device){
        int count = devices.get(device);
        soldItemsAmount += device.getPrice();
        leftItemsAmount -= device.getPrice();
        count--;
        devices.replace(device, count);

    }

    public int getSoldItemsAmount(){
        System.out.println("Sold items amount is " + soldItemsAmount + " AMD");

        return soldItemsAmount;
    }

    public int getLeftItemsAmount(){
        System.out.println("In stock you have " + leftItemsAmount + " AMD");
        return leftItemsAmount;
    }

    public void changePrice(Device device, int newPrice){
        device.setPrice(newPrice);
        leftItemsAmount = allItemsAmount();

    }

    public List<Device> getDevicesByRecordType(RecordType type){
        List<Device> deviceList = allDevicesList();
        List<Device> newDeviceList = new ArrayList<>();

        for (Device device : deviceList){
            if(device.getRecordTypes().contains(type))
                newDeviceList.add(device);
        }
        return newDeviceList;
    }

    private int allItemsAmount(){
        int amount = 0;
        for (Map.Entry<Device, Integer> entry : devices.entrySet()){
            Device device = entry.getKey();
            int count = entry.getValue();

            amount += count * device.getPrice();
        }

        return amount;
    }

    private List<Device> allDevicesList(){
        List<Device> deviceList = new ArrayList<>();
        for (Map.Entry<Device, Integer> entry : devices.entrySet()){
            Device device = entry.getKey();
            deviceList.add(device);
        }
        return deviceList;
    }






}
