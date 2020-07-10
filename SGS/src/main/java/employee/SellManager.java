package employee;

import employee.functionality.Employee;
import employee.functionality.Management;
import items.concepts.Gadget;
import items.functionality.Video;
import items.functionality.Voice;
import items.models.*;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class SellManager implements Management, Employee {
    private int soldAMD = 0;
    private int stockAMD = 0;
    private List<Gadget> gadgets;
    private List<Gadget> nonWorkingGadget = new ArrayList<>();
    private Logger logger = Logger.getLogger("tradeLog");
    private String pathTradings = "resources\\output\\trading.csv";
    private String pathInStock = "resources\\output\\inStock.csv";
    private String pathNonWorking = "resources\\output\\nonWorkingGadgets.csv";
    private String pathByType = "resources\\output\\filteredGadgetsByType.csv";

    public SellManager(List<Gadget> gadgets) {
        this.gadgets = gadgets;
        calculateStockAMD();
    }

    private void calculateStockAMD() {
        for (Gadget gadget : this.gadgets) {
            this.stockAMD += gadget.getPrice() * gadget.getCount();
        }
    }

    @Override
    public ArrayList<Gadget> getListOfItems() {
        ArrayList<Gadget> gadgetsList = new ArrayList<>();

        for (Gadget gadget : this.gadgets) {
            gadgetsList.add(gadget);
        }

        return gadgetsList;
    }

    public ArrayList<Gadget> getListOfItemsVideoGadgets() {
        ArrayList<Gadget> gadgetVideo = new ArrayList<>();

        for (Gadget gadget : gadgets) {
            if (gadget instanceof Video) {
                gadgetVideo.add(gadget);
            }
        }

        return gadgetVideo;
    }

    public ArrayList<Gadget> getListOfItemsRecordGadgets() {
        ArrayList<Gadget> gadgetRecord = new ArrayList<>();

        for (Gadget gadget : gadgets) {
            if (gadget instanceof Voice) {
                gadgetRecord.add(gadget);
            }
        }

        return gadgetRecord;
    }

    @Override
    public void sellItem(String name, Integer count) {
        FileHandler tradeLog = null;
        try {
            tradeLog = new FileHandler(pathTradings);
        } catch (IOException e) {
            Logger logger = Logger.getLogger("Errors");
            FileHandler errorsLog = null;
            try {
                errorsLog = new FileHandler("resources\\errors\\errors.log", true);
                logger.addHandler(errorsLog);
                logger.severe("Incorrect path for trading");
            }
            catch (IOException e1){
                e1.printStackTrace();
            }
        }
        logger.addHandler(tradeLog);
        for (Gadget gadget : gadgets) {
            if (gadget.getName().equals(name)) {
                if (gadget.getCount() >= count) {
                    soldAMD += count * gadget.getPrice();
                    gadget.setCount(gadget.getCount() - count);
                    stockAMD -= gadget.getPrice() * count;
                    logger.info(gadget.toString());
                    return;
                } else {
                    Logger logger = Logger.getLogger("Errors");
                    FileHandler errorsLog = null;
                    try {
                        errorsLog = new FileHandler("resources\\errors\\errors.log", true);
                        logger.addHandler(errorsLog);
                        logger.severe("Sorry. There are only %d items.\n" + gadget.getCount());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void sellItem(String name) {
        sellItem(name, 1);
    }

    public void addItem(Object gadgetObject) {
        Pair<Boolean, Integer> isGadgetExistVar = isGadgetExist(gadgetObject);
        if (isGadgetExistVar.getKey()) {
            Integer tempCount = gadgets.get(isGadgetExistVar.getValue()).getCount();
            gadgets.get(isGadgetExistVar.getValue()).setCount(tempCount + ((Gadget)gadgetObject).getCount());
            stockAMD += gadgets.get(isGadgetExistVar.getValue()).getPrice() * tempCount;
        } else {
            gadgets.add((Gadget) gadgetObject);
            stockAMD += ((Gadget) gadgetObject).getPrice() * ((Gadget) gadgetObject).getCount();
        }
    }

    private Pair<Boolean, Integer> isGadgetExist(Object gadgetObject) {
        Pair<Boolean, Integer> retVal;
        int index = -1;
        for (Gadget gadget : gadgets) {
            index++;
            if (gadget.equals(gadgetObject)) {
                retVal = new Pair<>(Boolean.TRUE, index);
                return retVal;
            }
        }
        retVal = new Pair<>(Boolean.FALSE, index);
        return retVal;
    }

    @Override
    public void changePrice(Object gadgetObject, Integer price) {
        for (Gadget gadget : gadgets) {
            if (gadget.getClass().equals(gadgetObject.getClass())) {
                if (price < 0) {
                    Logger logger = Logger.getLogger("Errors");
                    FileHandler errorsLog = null;
                    try {
                        errorsLog = new FileHandler("resources\\errors\\errors.log", true);
                        logger.addHandler(errorsLog);
                        logger.severe("Incorrect price. Price should be non-negative");
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                stockAMD += gadget.getCount() * (price - gadget.getPrice());

            }
        }
    }

    public void turnOn() {
        int workCount = 0;
        int removeCount = 0;
        int index;

        for (Gadget gadget : gadgets) {
            try {
                this.nonWorkingGadget.add((Gadget)gadget.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
             }
        }

        for (Gadget gadget : gadgets) {
            for (int i = 0; i < gadget.getCount(); ++i) {
                if (gadget.turnOn()) {
                    workCount++; 
                }
            }
            if (workCount == gadget.getCount()) {
                nonWorkingGadget.remove(gadget);
                removeCount++;
            } else if (workCount < gadget.getCount()) {
                index = gadgets.indexOf(gadget);
                nonWorkingGadget.get(index - removeCount).setCount(gadget.getCount() - workCount);
                gadget.setCount(workCount);
            }
            workCount = 0;
        }

        this.printListOfNonWorkingGadgets();
    }

    public void addFromFile(Class... classes) {
        for (Class cl : classes) {
            try {
                if (PenRecord.class == cl) {
                    if(PenRecord.initFromFile() != null)
                        gadgets.addAll(PenRecord.initFromFile());
                }

                if (PenVideo.class == cl) {
                    if (PenVideo.initFromFile() != null)
                        gadgets.addAll(PenVideo.initFromFile());
                }

                if (USBFlashRecord.class == cl) {
                    if(USBFlashRecord.initFromFile() != null)
                        gadgets.addAll(USBFlashRecord.initFromFile());
                }
                if (USBFlashVideo.class == cl) {
                    if(USBFlashVideo.initFromFile() != null)
                        gadgets.addAll(USBFlashVideo.initFromFile());
                }

                if (Watch.class == cl) {
                    if(Watch.initFromFile() != null)
                        gadgets.addAll(Watch.initFromFile());
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private void printListOfNonWorkingGadgets() {
        for (Gadget gadget : nonWorkingGadget) {
                gadget.print(pathNonWorking);
        }
    }

    public void printListOfGadgets() {
        for (Gadget gadget : gadgets) {
            System.out.println(gadget.toString());
        }
    }

    @Override
    public int getStockAMD() {
        return stockAMD;
    }

    @Override
    public int getSoldAMD() {
        return soldAMD;
    }

    @Override
    public void removeItem(Object gadgetObject) {
        gadgets.remove((Gadget)gadgetObject);
    }
}
