package com.aca.naresilanyan.oopHomework;

import com.aca.naresilanyan.oopHomework.models.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) {

        File videoAndAudio = Paths.get("/Users/ns/Downloads/aca_lessons/src/com/aca/naresilanyan/homework/models/dataSources/VideoAndAudio.csv").toFile();
        File audioRecording = Paths.get("/Users/ns/Downloads/aca_lessons/src/com/aca/naresilanyan/homework/models/dataSources/OnlyAudioRecording.csv").toFile();
        File videoRecording = Paths.get("/Users/ns/Downloads/aca_lessons/src/com/aca/naresilanyan/homework/models/dataSources/OnlyVideoRecording.csv").toFile();
        List<File> files = new ArrayList<File>(Arrays.asList(videoAndAudio,audioRecording, videoRecording));
        List<Gadget> allGadgetsCSV = new ArrayList<>();
        BufferedReader csvReader = null;
        Logger logger = Logger.getGlobal();
        List<String> k = new ArrayList<>();



        for(File file: files){
            if(file.isFile()){
                System.out.println("correct file path");

            }else {
                System.out.println("there is no such file");

            }
        }

        logger.info("TRy to Read csv file");

        for(File file: files){
            if(file.length() != 0) {
                try {
                    logger.info("Collect data in array");
                    csvReader = new BufferedReader(new FileReader(file));
                    String row;



                    while ((row = csvReader.readLine()) != null) {
                        String[] data = row.split(",");

                        System.out.println(Arrays.toString(data));



                        if(data[0].equals("Watch")){
                            allGadgetsCSV.add(new Watch(data[0], Integer.parseInt(data[1]),new String[]{data[2],data[3]},new ArrayList<String>(Arrays.asList(data[4],data[5],data[6])),Integer.parseInt(data[7]),Integer.parseInt(data[8]),data[9]));
                        }
                        else if(data[0].equals("Pen")  & data[2].equals("Record") ){
                            allGadgetsCSV.add(new PenAudioRecorder(data[0],Integer.parseInt(data[1]),new String[]{data[2]}, new ArrayList<String>(Arrays.asList(data[3])),Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6], new ArrayList<String>(Arrays.asList(data[7],data[8]))));

                        }
                        else if(data[0].equals("USB Flash")  & data[2].equals("Record") ){
                            allGadgetsCSV.add(new USBAudioRecorder(data[0],Integer.parseInt(data[1]),new String[]{data[2]}, new ArrayList<String>(Arrays.asList(data[3])),Integer.parseInt(data[4]), Integer.parseInt(data[5]),data[6]));

                        }
                        else if(data[0].equals("Pen")  & data[2].equals("Video") ){
                            allGadgetsCSV.add(new PenVideoRecorder(data[0],Integer.parseInt(data[1]), new String[]{data[2]}, new ArrayList<String>(Arrays.asList(data[3],data[4])), Integer.parseInt(data[5]),Integer.parseInt(data[6])));

                        }
                        else if (data[0].equals("USB Flash")  & data[2].equals("Video")){
                            allGadgetsCSV.add(new USBVideoRecorder(data[0], Integer.parseInt(data[1]), new String[]{data[2]}, new ArrayList<String>(Arrays.asList(data[3],data[4])), Integer.parseInt(data[5]),Integer.parseInt(data[6])));

                        }




                    }

                } catch (FileNotFoundException ex) {
                    logger.severe("We have File Not Found exception");

                    ex.printStackTrace();
                } catch (IOException ex) {
                    logger.severe("We have IOException exception when read lines");
                    ex.printStackTrace();

                } finally {
                    if (csvReader != null) {
                        try {
                            csvReader.close();

                        } catch (IOException ex) {
                            logger.severe("We have IOException exception When close the csv");

                            ex.printStackTrace();
                        }
                    }
                }

            }else {
                System.out.println("the file is empty");}

        }

//        System.out.println(allGadgetsCSV);


//
//
//        Gadget penVideo = new PenVideoRecorder("Pen",4,new String[]{"Video"}, new ArrayList<String>(Arrays.asList(VideoDevice.mp4,VideoDevice.vga)), 2,6500);
//        Gadget penRecord = new PenAudioRecorder("Pen",5, new String[]{"Record"}, new ArrayList<String>(Arrays.asList(AudioDevice.mp3)),9, 14000,"8GB", new ArrayList<String>(Arrays.asList(AudioDevice.red,AudioDevice.blue)));
//        Gadget USBVideo = new USBVideoRecorder("USB Flash", 3,new String[]{"Video"},new ArrayList<String>(Arrays.asList(VideoDevice.mp4,VideoDevice.vga)), 2,5000);
//        Gadget USBRecord = new USBAudioRecorder("USB Flash",4,new String[]{"Record"}, new ArrayList<String>(Arrays.asList(AudioDevice.mp3)),9, 11000,"8GB" );
//        Gadget Watch = new Watch("Watch",2, new String[]{"Record","Video"}, new ArrayList<String>(Arrays.asList(AudioDevice.mp3,VideoDevice.mp4,VideoDevice.hd)),5, 13000,"8GB" );
//

        System.out.println("Manager Passes a list of items with quantities in the beginning");

        Manager manager = new Manager(allGadgetsCSV);

        System.out.println();
        System.out.println("Manager Sells An Item");
        manager.sellItem("Pen",AudioDevice.mp3,4);

        System.out.println();
        System.out.println("Manager Checks How Much Is Sold in AMD");
        System.out.println(manager.getEarned());

        System.out.println();
        System.out.println("Manager Checks How Much He Has in Stock in AMD");
        System.out.println(manager.getRemained());


        System.out.println();
        System.out.println("Existing Audio Items List");
        System.out.println(manager.getAudioRecorders());

        System.out.println();
        System.out.println("Existing Video Items List");
        System.out.println(manager.getVideoRecorders());


        System.out.println();
        System.out.println("Existing Video Items by Types");
        System.out.println(manager.getVideoRecordersByType(VideoDevice.vga));


        System.out.println();
        System.out.println("Manager Changes Product Price");
        manager.changeGadgetPrice("Pen",AudioDevice.mp3,10000);









    }
}
