package com.aca.raf.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Manager {
    private final List<Gadget> gadgets;
    private List<Gadget> notWorkingItems;
    private int soldAmount = 0;

    public Manager(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public List<Gadget> getNotWorkingItems() {
        return notWorkingItems;
    }

    public void SellItem(Class classOfGadget){
        for (Gadget gadget: gadgets){
            if (gadget.getClass() == classOfGadget){
                gadget.setCount(gadget.getCount() - 1);
                soldAmount += gadget.getPrice();
            }
        }
    }

    public List<VideoRecorder> getAllVideoRecorders(){
        List<VideoRecorder> recorders = new ArrayList<>();
        for (Gadget gadget: gadgets){
            if (gadget instanceof VideoRecorder){
                recorders.add((VideoRecorder) gadget);
            }
        }
        return recorders;
    }

    public List<VideoRecorder> getAllVideoRecordersByType(VideoRecorder.VideoQuality videoQuality) {
        List<VideoRecorder> recorders = new ArrayList<>();
        for (Gadget gadget: gadgets){
            if (gadget instanceof VideoRecorder){
                VideoRecorder videoRecorder = (VideoRecorder) gadget;
                if (videoRecorder.getVideoQuality() == videoQuality){
                    recorders.add(videoRecorder);
                }
            }
        }
        return recorders;
    }

    public int getSoldAmount() {
        return soldAmount;
    }

    public int getInStockAmount(){
        int amount = 0;
        for (Gadget gadget: gadgets){
            amount += gadget.getCount() * gadget.getPrice();
        }
        return amount;
    }

    public void checkGadgets(){
        notWorkingItems = new ArrayList<>();
        Random rand = new Random();
        for (Gadget gadget: gadgets) {
            int randInt = rand.nextInt(100);
            if (gadget instanceof VideoRecorder) {
                if (randInt % 2 == 0){
                    printItemsOfVideoRecordingGadget(gadget);
                }else {
                    notWorkingItems.add(gadget);
                }
            }else if (gadget instanceof AudioRecorder){
                if (randInt % 2 == 0){
                    printItemsOfAudioRecordingGadget(gadget);
                }else {
                    notWorkingItems.add(gadget);
                }
            }

            if (gadget instanceof VideoRecorder && gadget instanceof AudioRecorder){
                int newRandInt = rand.nextInt(100);
                if (randInt % 2 == 0){
                    printItemsOfVideoRecordingGadget(gadget);
                }
                if (newRandInt %2 == 0){
                    printItemsOfAudioRecordingGadget(gadget);
                }
            }
        }
        for (Gadget notWorkingItem: notWorkingItems){
            if (notWorkingItem instanceof PenAudioRecorder){
                System.out.println("Pen audio recorder not working. We have " + notWorkingItem.getCount() + " items");
            } else if (notWorkingItem instanceof PenVideoRecorder){
                System.out.println("Pen video recorder not working. We have " + notWorkingItem.getCount() + " items");
            } else if (notWorkingItem instanceof USBAudio){
                System.out.println("USB audio recorder not working. We have " + notWorkingItem.getCount() + " items");
            } else if (notWorkingItem instanceof USBVideo){
                System.out.println("USB audio recorder not working. We have " + notWorkingItem.getCount() + " items");
            } else if (notWorkingItem instanceof Watch){
                System.out.println("Watch not working. We have " + notWorkingItem.getCount() + " items");
            }
        }
    }

    private void printItemsOfVideoRecordingGadget(Gadget videoRecordingGadget){

        if (videoRecordingGadget instanceof PenVideoRecorder){
            System.out.println("Pen video recorder");
            System.out.println("Video Quality " + ((PenVideoRecorder) videoRecordingGadget).getVideoQuality());
            System.out.println("Writing color " + ((PenVideoRecorder) videoRecordingGadget).getWritingColor());
        }else if (videoRecordingGadget instanceof USBVideo){
            System.out.println("USB Video");
            System.out.println("Video Quality " + ((USBVideo) videoRecordingGadget).getVideoQuality());
        }else if (videoRecordingGadget instanceof Watch){
            System.out.println("Watch");
            System.out.println("Video Quality " + ((Watch) videoRecordingGadget).getVideoQuality());
            System.out.println("Memory " + ((Watch) videoRecordingGadget).getMemoryInGB());
        }
        System.out.println("Duretion " + videoRecordingGadget.getDuretion());
        System.out.println("Price" + videoRecordingGadget.getPrice());
        System.out.println("Count" + videoRecordingGadget.getCount());

    }

    private void printItemsOfAudioRecordingGadget(Gadget audioRecordingGadget){

        if (audioRecordingGadget instanceof PenAudioRecorder){
            System.out.println("Pen audio recorder");
            System.out.println("Memory " + ((PenAudioRecorder) audioRecordingGadget).getMemoryInGB());
            System.out.println("Writing color " + ((PenAudioRecorder) audioRecordingGadget).getWritingColor());
            System.out.println("Audio type " + ((PenAudioRecorder) audioRecordingGadget).getAudioType());
        }else if (audioRecordingGadget instanceof USBAudio){
            System.out.println("USB audio");
            System.out.println("Audio type " + ((USBAudio) audioRecordingGadget).getAudioType());
            System.out.println("Memory " + ((USBAudio) audioRecordingGadget).getMemoryInGB());
        }else if (audioRecordingGadget instanceof Watch){
            System.out.println("Watch");
            System.out.println("Audio type " + ((Watch) audioRecordingGadget).getAudioType());
            System.out.println("Memory " + ((Watch) audioRecordingGadget).getMemoryInGB());
        }
        System.out.println("Duretion " + audioRecordingGadget.getDuretion());
        System.out.println("Price" + audioRecordingGadget.getPrice());
        System.out.println("Count" + audioRecordingGadget.getCount());

    }

}
