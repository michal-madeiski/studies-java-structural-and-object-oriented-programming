package z1;

public class Ciezarowka extends Pojazd {
    private double kilometryZNaczepa;

    public Ciezarowka(String nazwa, double zrobioneKilometry, double kilometryZNaczepa) {
        super(nazwa, zrobioneKilometry);
        this.kilometryZNaczepa = kilometryZNaczepa;
    }

    public double getKilometryZNaczepa() {
        return kilometryZNaczepa;
    }

    public void setKilometryZNaczepa(double kilometryZNaczepa) {
        this.kilometryZNaczepa = kilometryZNaczepa;
    }

    @Override
    public double kosztyUtrzymania() {
        return kilometryZNaczepa*cenaPaliwa*2 + (zrobioneKilometry-kilometryZNaczepa)*cenaPaliwa;
    }

    @Override
    public String toString() {
        return String.format("%s %-10s", super.toString(), "Ciezarowka");
    }
}
