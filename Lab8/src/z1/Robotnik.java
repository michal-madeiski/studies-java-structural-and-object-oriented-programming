package z1;

public class Robotnik extends Pracownik {
    private final int limitGodzin = 200;
    private double stawkaGodzinowa;
    private double ileGodzin;
    public Robotnik(String nazwisko, double staz, double stawkaGodzinowa, double ileGodzin) {
        super(nazwisko, staz);
        this.stawkaGodzinowa = stawkaGodzinowa;
        this.ileGodzin = ileGodzin;
    }

    public double wynagrodzenie() {
        double nadgodziny = 0;
        if (ileGodzin - limitGodzin*staz > 0) nadgodziny = 0.5*stawkaGodzinowa*(ileGodzin - limitGodzin*staz);
        return ileGodzin*stawkaGodzinowa + nadgodziny;
    }

    @Override
    public String toString() {
        return super.toString() + " robotnik";
    }
}
