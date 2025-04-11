package z1;

import java.io.IOException;

public class Main_1 {

    public static double srednia(int[][] t) {
        double suma = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                suma += t[i][j];
            }
        }
        return suma/(t.length*t[0].length);
    }

    public static void main(String[] args) throws IOException {
        Macierz m = new Macierz(5, 6);
        m.wypelnij(20);
        m.wyswietl();

        m.zapiszDoPliku("Macierz.txt");
        System.out.println();

        int[][] t = m.odczytaj("Macierz.txt");
        System.out.println("Średnia: " + srednia(t));

    }
}