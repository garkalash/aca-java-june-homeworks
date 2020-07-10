import employee.SellManager;
import items.concepts.Gadget;
import items.functionality.format.FormatSound;
import items.functionality.quality.VideoQuality;
import items.models.*;

import java.util.ArrayList;


public class shop {
    public static void main(String[] args) {
        ArrayList<Gadget> gadgets = new ArrayList<Gadget>();
        gadgets.add(new PenVideo(VideoQuality.VGA, 2, 6500, 0));
        gadgets.add(new PenRecord(FormatSound.MP3, 8, 9, 14000, 0, PenRecord.PenColor.Blue));
        gadgets.add(new USBFlashRecord(FormatSound.MP3, 8, 9, 11000, 0));
        gadgets.add(new USBFlashVideo(VideoQuality.VGA, 2, 5000, 0));
        gadgets.add(new Watch(FormatSound.MP3, VideoQuality.HD, 8, 5, 13000, 0));

        SellManager manager = new SellManager(gadgets);
    }
}
