package z1;

public abstract class Pojazd {
    protected String nazwa;

    protected double zrobioneKilometry;

    protected final double cenaPaliwa = 7.24;

    public Pojazd(String nazwa, double zrobioneKilometry) {
        this.nazwa = nazwa;
        this.zrobioneKilometry = zrobioneKilometry;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getZrobioneKilometry() {
        return zrobioneKilometry;
    }

    public abstract double kosztyUtrzymania();

    public String toString() {
        return String.format("%-11s %-7.2f", nazwa, zrobioneKilometry);
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Pojazd)) return false;
        Pojazd p = (Pojazd) other;
        return (p.getNazwa()).equals(nazwa) && (p.getZrobioneKilometry() == zrobioneKilometry);
    }

}
