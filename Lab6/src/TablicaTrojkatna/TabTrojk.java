package TablicaTrojkatna;
import java.util.Random;

public class TabTrojk {
    private double[][] tab;

    public TabTrojk(int a) {
        this.tab = new double[a][];
        for (int i = 0; i < a; i++) {
            this.tab[i] = new double[i + 1];
        }
    }

    public void wypelnij1(double z) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                Random r = new Random();
                double x = r.nextDouble(z);
                tab[i][j] = x;
            }
        }
    }

    public void wyswietl() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.printf("%9.3f", tab[i][j]);
            }
            System.out.println();
        }
    }

    public void sredniaWiersza() {
        System.out.println("wiersz" + " " + "srednia");
        for (int i = 0; i < tab.length; i++) {
            double suma = 0;
            for (int j = 0; j < tab[i].length; j++) {
                suma += tab[i][j];
            }
            double srednia = suma/(i + 1);
            System.out.printf("%2d %9.3f", i, srednia);
            System.out.println();
        }
    }

}
