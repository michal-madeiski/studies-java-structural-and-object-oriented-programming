package z1;

import java.util.ArrayList;
import java.util.List;

public class Garaz {

    private List<Pojazd> garaz;
    public Garaz() {
        this.garaz = new ArrayList<Pojazd>();
    }

    public void wstawPojazd(Pojazd p) {
        if (p != null && !garaz.contains(p)) garaz.add(p);
    }

    public void usunPojazd(Pojazd p) {
        if (p != null) garaz.remove(p);
    }

    public void listaPojazdow() {
        int lp = 1;
        for (int i = 0; i < garaz.size(); i++) {
            System.out.printf("%s %s %-10.2f \n", lp, garaz.get(i), ( garaz.get(i) ).kosztyUtrzymania());
            lp++;
        }
    }

    public void listaSamochodow() {
        int lp = 1;
        for (int i = 0; i < garaz.size(); i++) {
            if (garaz.get(i) instanceof Samochod) {
                System.out.printf("%s %s %-10.2f \n", lp, garaz.get(i), ( garaz.get(i) ).kosztyUtrzymania());
                lp++;
            }
        }
    }

    public double wszystkieKoszty() {
        double suma = 0;
        for (int i = 0; i < garaz.size(); i++) {
            suma += ( garaz.get(i) ).kosztyUtrzymania();
        }
        return suma;
    }

    public double kosztyCiezarowek() {
        double suma = 0;
        for (int i = 0; i < garaz.size(); i++) {
            if (garaz.get(i) instanceof Samochod) {
                suma += ( garaz.get(i) ).kosztyUtrzymania();
            }
        }
        return suma;
    }

}
