public class GadgetWithMemory extends Gadget {
   int memory;

    public GadgetWithMemory(int code) {
        super(code);
        this.code = code;

    }
    @Override

    public void function() {
        System.out.println("My function is:  Record MP3");

    }


}
