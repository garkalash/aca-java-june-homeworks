package com.aca.arminearzumanyan.homeworks.items.gadget;

import com.aca.arminearzumanyan.homeworks.exceptions.FileFormatException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class DataConverter {

    private static final Logger logger = Logger.getGlobal();

    private ArrayList<String> takeFileContent() {
        String productFilePath = "files/Product.CSV";
        ArrayList<String> productProperties = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Paths.get(productFilePath).toFile()))) {
            logger.info("Enter into try");
            String line = br.readLine();
            while (line != null) {
                productProperties.add(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            logger.severe("An error occurred." + ex.getMessage());
            ex.printStackTrace();
        }
        return productProperties;
    }

    public Map<Integer, Gadget> generateGadgetInstanceList() {
        Map<Integer, Gadget> allItems = new HashMap<>();
        ArrayList<String> productsProperty = takeFileContent();

        List<Class<? extends Gadget>> classList = new ArrayList<>();
        classList.add(PenAudioRecorder.class);
        classList.add(PenVideoRecorder.class);
        classList.add(UsbAudioRecorder.class);
        classList.add(UsbVideoRecorder.class);
        classList.add(Watch.class);

        for (int i = 0; i < productsProperty.size(); i++) {
            String[] gadgetProperty = productsProperty.get(i).split(",");
            if (gadgetProperty.length >= 5) {
                String name = gadgetProperty[1];
                int count = Integer.parseInt(gadgetProperty[2]);
                int price = Integer.parseInt(gadgetProperty[3]);
                int recDuration = Integer.parseInt(gadgetProperty[4]);
                Integer code = Integer.parseInt(gadgetProperty[0]);
                int memoryInGb = 0;
                if (gadgetProperty.length == 6) {
                    memoryInGb = Integer.parseInt(gadgetProperty[5]);
                }
                for (Class<? extends Gadget> aClass : classList) {
                    if (name.equals(aClass.getSimpleName())) {
                        Gadget gadget = null;
                        if (memoryInGb == 0) {
                            Class[] constructorParameters = new Class[]{String.class, int.class, int.class};
                            try {
                                gadget = aClass.getConstructor(constructorParameters).newInstance(name, price, recDuration);
                            } catch (ReflectiveOperationException ex) {
                                logger.severe("An error occurred." + ex.getMessage());
                                ex.printStackTrace();
                            }
                            gadget.setCount(count);
                            gadget.setCode(code);
                            allItems.put(code, gadget);
                            break;
                        } else {
                            Class[] parameters = new Class[]{String.class, int.class, int.class, int.class};
                            try {
                                gadget = aClass.getConstructor(parameters).newInstance(name, price, recDuration, memoryInGb);
                            } catch (ReflectiveOperationException ex) {
                                logger.severe("An error occurred." + ex.getMessage());
                                ex.printStackTrace();
                            }
                            gadget.setCount(count);
                            gadget.setCode(code);
                            allItems.put(code, gadget);
                            break;
                        }
                    }
                }
            } else {
                throw new FileFormatException();
            }
        }
        return allItems;
    }
}
