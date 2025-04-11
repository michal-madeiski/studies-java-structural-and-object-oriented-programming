package z1;

public class Samochod extends Pojazd {
    private double kosztyNapraw;

    public Samochod(String nazwa, double zrobioneKilometry, double kosztyNapraw) {
        super(nazwa, zrobioneKilometry);
        this.kosztyNapraw = kosztyNapraw;
    }

    public double getKosztyNapraw() {
        return kosztyNapraw;
    }

    public void setKosztyNapraw(double kosztyNapraw) {
        this.kosztyNapraw = kosztyNapraw;
    }

    @Override
    public double kosztyUtrzymania() {
        return kosztyNapraw + cenaPaliwa*zrobioneKilometry;
    }

    public String toString() {
        return String.format("%s %-10s", super.toString(), "Samochod");
    }
}
