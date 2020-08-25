package abgarabrahamyan.oop;

abstract public class Gadget {
    private String name;
    private String type;
    private byte memoryGb;
    private byte chargeTimeInHours;
    private double priceInAmd;

    public Gadget(String name, String type, byte memoryGb,
                  byte chargeTimeInHours, double priceInAmd) {
        this.name = name;
        this.type = type;
        if (memoryGb > 0)
            this.memoryGb = memoryGb;
        if (chargeTimeInHours > 0)
            this.chargeTimeInHours = chargeTimeInHours;
        if (priceInAmd > 0)
            this.priceInAmd = priceInAmd;
    }

    public void setPriceInAmd(double newPrice) {
        priceInAmd = newPrice;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte getMemoryGb() {
        return memoryGb;
    }

    public byte getChargeTimeInHours() {
        return chargeTimeInHours;
    }

    public double getPriceInAmd() {
        return priceInAmd;
    }
}
