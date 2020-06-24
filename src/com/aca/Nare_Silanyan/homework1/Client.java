package com.aca.Nare_Silanyan.homework1;

import com.aca.Nare_Silanyan.homework1.models.Manager;
import com.aca.Nare_Silanyan.homework1.models.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        Parameters pen_Video = new Parameters("Pen",4,new String[]{"Video"}, new String[]{"MP4", "VGA"},null, 2,6500 );
        Parameters pen_Record = new Parameters("Pen",5, new String[]{"Record"}, new String[]{"MP3"},"8GB", 9,14000 );
        Parameters USB_Video = new Parameters("USB Flash", 3,new String[]{"Video"}, new String[]{"MP4", "VGA"},null, 2,5000 );
        Parameters USB_Record = new Parameters("USB Flash",4,new String[]{"Record"}, new String[]{"MP3"},"8GB", 9,11000 );
        Parameters Watch = new Parameters("Watch",2, new String[]{"Record","Video"}, new String[]{"MP3","MP4","HD"},"8GB", 5,13000 );

        Manager manager = new Manager();
        System.out.println();
        System.out.println("Manager Passes a list of items with quantities in the beginning");
        manager.itemsList(new Parameters[]{pen_Video,pen_Record, USB_Video, USB_Record,Watch});

        System.out.println();
        System.out.println("Manager Sells An Item");
        manager.sellItems(pen_Video, 2);

        System.out.println();
        System.out.println("Manager Checks How Much Is Sold in AMD");
        System.out.println(manager.getEarned());

        System.out.println();
        System.out.println("Manager Checks How Much He Has in Stock in AMD");
        System.out.println(manager.getRemained());

        System.out.println();
        System.out.println("List of Record Items");
        System.out.println(manager.getRecordItems());

        System.out.println();
        System.out.println("List of Video Items by Type");
        System.out.println(manager.getVideoItems());

        System.out.println();
        System.out.println("Manager Changes Product Price");
        manager.changePrice(Watch,10000);





    }
}
