package abgarabrahamyan.oop;

import java.util.ArrayList;
import java.util.List;

public class Store {
    //static List<Gadget> items = new ArrayList<>();
    static List<Gadget> recordItems = new ArrayList<>();
    static List<Gadget> videoItems = new ArrayList<>();

    public static void main(String[] args) {

        Controller pad = new Controller();
        pad.start();
    }
}
