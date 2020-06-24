import java.util.ArrayList;
import java.util.List;

public class Manager {

    protected static GadgetsRepository gadgetsRepository = new GadgetsRepository();
    List<Gadget> allGadgets = gadgetsRepository.getAll();
    List<Gadget> soledGadgets = new ArrayList<>();

    public void sailGadget(Gadget item) {
        soledGadgets.add(item);
        allGadgets.remove(item);
    }

    public Gadget getGadgetByCod(int code) {
        for (Gadget gadget : allGadgets) {
            if (gadget.code == code) {
                return gadget;
            }
        }
        return null;
    }

}
