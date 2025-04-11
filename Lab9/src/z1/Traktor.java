package z1;

public class Traktor extends Pojazd {
    private double kilometryPodczasPrac;

    public Traktor(String nazwa, double zrobioneKilometry, double kilometryPodczasPrac) {
        super(nazwa, zrobioneKilometry);
        this.kilometryPodczasPrac = kilometryPodczasPrac;
    }

    public double getKilometryPodczasPrac() {
        return kilometryPodczasPrac;
    }

    public void setKilometryPodczasPrac(double kilometryPodczasPrac) {
        this.kilometryPodczasPrac = kilometryPodczasPrac;
    }

    @Override
    public double kosztyUtrzymania() {
        return kilometryPodczasPrac*cenaPaliwa*3 + (zrobioneKilometry-kilometryPodczasPrac)*cenaPaliwa;
    }

    public String toString() {
        return String.format("%s %-10s", super.toString(), "Traktor");
    }
}
