package z1;

public abstract class Pracownik {
    protected String nazwisko;
    protected double staz;

    public Pracownik(String nazwisko, double staz) {
        this.nazwisko = nazwisko;
        this.staz = staz;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getStaz() {
        return staz;
    }

    public void setStaz(double staz) {
        this.staz = staz;
    }

    public String toString() {
        return nazwisko + " " + staz;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Pracownik)) return false;
        Pracownik p = (Pracownik) other;
        return (p.getNazwisko()).equals(nazwisko) && (p.getStaz() == staz);
    }

    public abstract double wynagrodzenie();
}
