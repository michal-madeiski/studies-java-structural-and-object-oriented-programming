package Hotel2D;

public class Pokoj {
    private int numer;
    private Osoba osoba;

    public Pokoj(int numer) {
        this.numer = numer;
        osoba = null;
    }

    public Pokoj() {
        numer = 0;
        osoba = null;
    }

    public boolean czyZajety() {
        return osoba != null;
    }

    public void zwolnijPokoj() {
        if (czyZajety()) System.out.print("Pokoj nr." + numer + " został zwolniony przez: " + osoba + "\n");
        osoba = null;
    }

    public int getNumer() {
        return numer;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

}
