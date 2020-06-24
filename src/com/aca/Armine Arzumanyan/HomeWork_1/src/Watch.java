public class Watch extends GadgetWithMemory {

    public Watch(int code) {
        super(code);
        price = 13000;
        name = "Watch";
        recDuration = 13;
        memory = 8;
        mp4 = true;
        mp3 = true;
        hd = true;
        vga = true;
    }
    @Override
    public void function() {
        System.out.println("My function is:  Record MP3,  Video MP4, HD");
    }
}
