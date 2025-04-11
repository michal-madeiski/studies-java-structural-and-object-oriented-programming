package Hotel2D;

public class Osoba {
    private String imie;
    private String nazwisko;

    public Osoba(String name, String nazwisko) {
        this.imie = name;
        this.nazwisko = nazwisko;
    }

    public Osoba() {
        imie = "Osoba";
        nazwisko = "Domyślna";
    }

    public String toString() {
        return imie + " " + nazwisko;}

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Osoba)) return false;
        Osoba osoba = (Osoba) other;
        return (osoba.getImie()).equals(imie) && (osoba.getNazwisko()).equals(nazwisko);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

}
