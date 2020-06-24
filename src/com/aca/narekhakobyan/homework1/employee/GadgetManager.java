package com.aca.narekhakobyan.homework1.employee;

import com.aca.narekhakobyan.homework1.employee.functionality.Employee;
import com.aca.narekhakobyan.homework1.employee.functionality.Management;
import com.aca.narekhakobyan.homework1.items.concepts.*;
import com.aca.narekhakobyan.homework1.items.models.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class GadgetManager implements Management, Employee {

    private ArrayList<Gadget> gadgets = new ArrayList<Gadget>();
    private int soldAMD = 0;
    private int stockAMD = 0;

    private void calculateStockAMD() {
        for (Gadget gadget : this.gadgets) {
            this.stockAMD += gadget.getPrice() * gadget.getCount();
        }
    }

    public GadgetManager(ArrayList<Gadget> gadgets) {
       for (Gadget gadget : gadgets) {
           this.addItem((Gadget)gadget);
       }
       calculateStockAMD();
    }

    @Override
    public void listOfItems() {
        for (Gadget gadget : this.gadgets) {
            gadget.print();
        }
    }

    public void listOfItemsVideoGadgets() {
        for (Gadget gadget : gadgets) {
            if (gadget instanceof GadgetVideoWithMemory) {
                gadget.print();
            }
            if (gadget instanceof GadgetVideoWithoutMemory) {
                gadget.print();
            }
            if (gadget instanceof GadgetRecordVideoWithMemory) {
                gadget.print();
            }
        }
    }

    public void listOfItemsRecordGadgets() {
        for (Gadget gadget : gadgets) {
            if (gadget instanceof GadgetRecordWithMemory) {
                gadget.print();
            }
            if (gadget instanceof GadgetRecordWithoutMemory) {
                gadget.print();
            }
            if (gadget instanceof GadgetRecordVideoWithMemory) {
                gadget.print();
            }
        }
    }

    private boolean isCorrectAnswer(String answer) {
        return (isPositiveAnswer(answer) || isNegativeAnswer(answer)) ? true : false;
    }

    private boolean isPositiveAnswer(String answer) {
        return (answer.equals("y") || answer.equals("yes")) ? true : false;
    }

    private boolean isNegativeAnswer(String answer) {
        return (answer.equals("n") || answer.equals("no")) ? true : false;
    }

    @Override
    public void sellItem(Object gadgetObject, Integer count) {
        for (Gadget gadget : gadgets) {
            if (gadget.equals(gadgetObject)) {
                if (gadget.getCount() >= count) {
                    soldAMD += count * gadget.getPrice();
                    gadget.setCount(gadget.getCount() - count);
                    stockAMD -= gadget.getPrice() * count;
                    return;
                } else {
                    System.out.printf("Sorry. There are only %d %s's.\n", gadget.getCount(), gadget.getName());
                    System.out.println("Do you want that quantity?(y/n)/(yes/no)");
                    Scanner in = new Scanner(System.in);
                    String answer = in.nextLine();
                    answer = answer.toLowerCase();
                    answer = answer.replaceAll(" ","");

                    while (!isCorrectAnswer(answer)) {
                        System.out.println("Please enter correct answer.");
                        answer = in.nextLine();
                        answer = answer.toLowerCase();
                        answer = answer.replaceAll(" ","");
                    }

                    if (isPositiveAnswer(answer)) {
                        System.out.println("Thank you.");
                        soldAMD += gadget.getCount() * gadget.getPrice();
                        stockAMD -= gadget.getPrice() * gadget.getCount();
                        gadget.setCount(0);
                        return;
                    } else {
                        System.out.println("Sorry.");
                        return;
                    }
                }
            }
        }
        System.out.println("Sorry. There is not such kind of gadget.");
    }

    @Override
    public void sellItem(Object gadgetObject) {
        sellItem(gadgetObject, 1);
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

    private boolean isCorrectPrice(Integer price) {
        return price >= 0;
    }

    @Override
    public void changePrice(Object gadgetObject, Integer price) {
        for (Gadget gadget : gadgets) {
            if (gadget.getClass().equals(gadgetObject.getClass())) {
                while (price < 0) {
                    System.out.println("Wrong price. Please reenter.");
                    Scanner in = new Scanner(System.in);
                    price = in.nextInt();
                }
                stockAMD += gadget.getCount() * (price - gadget.getPrice());
                gadget.setPrice(price);
            }
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
