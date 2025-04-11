package Tablice2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tab2D {
    private int[][] tab;

    public Tab2D(int x, int y) {
        this.tab = new int[x][y];
    }

    public void wypelnij(int z) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                Random r = new Random();
                int x = r.nextInt(1, z);
                tab[i][j] = x;
            }
        }
    }

    public void wyswietlWierszami() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.printf("%4d", tab[i][j]);
            }
            System.out.println();
        }
    }

    public static void wyswietl(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.printf("%4d", t[i][j]);
            }
            System.out.println();
        }
    }

    public void wyswietlKolumnami() {
        for (int i = 0; i < tab[0].length; i++) {
            for (int j = 0; j < tab.length; j++) {
                System.out.printf("%4d", tab[j][i]);
            }
            System.out.println();
        }
    }

    public int sumaElementow() {
        int suma = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                suma += tab[i][j];
            }
        }
        return suma;
    }

    public int maks() {
        int maks = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] > maks) {
                    maks = tab[i][j];
                }
            }
        }
        return maks;
    }

    public int[] maksIndeksy() {
        int maks = 0;
        int[] temp = new int[2];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] > maks) {
                    maks = tab[i][j];
                    temp[0] = i;
                    temp[1] = j;
                }
            }
        }
        return temp;
    }

    public void indeksyWartosci(int n) {
        List<List<Integer>> indeksy = new ArrayList<>();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] == n) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    indeksy.add(temp);
                }
            }
        }
        if (indeksy.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(-1);
            temp.add(-1);
            System.out.println(temp);
        }
        else {
            System.out.println(indeksy);
        }
    }

    public int[] sumyWKolumnach() {
        int[] sumy = new int[tab[0].length];
        for (int i = 0; i < tab[0].length; i++) {
            int suma = 0;
            for (int j = 0; j < tab.length; j++) {
                suma += tab[j][i];
            }
            sumy[i] = suma;
        }
        return sumy;
    }

    public void maksSumaKolumny() {
        int maks = 0;
        int numer = 0;
        for (int i = 0; i < sumyWKolumnach().length; i++) {
            if (sumyWKolumnach()[i] > maks) {
                maks = sumyWKolumnach()[i];
                numer = i;
            }
        }
        System.out.println("najwieksza suma w kolumnie: " + maks + ", numer kolumny: " + numer);
    }

    public void usunWedlugMaksElementu() {
        int[][] nowa = new int[tab.length - 1][tab[0].length - 1];
        int x = maksIndeksy()[0];
        int y = maksIndeksy()[1];
        for (int i = 0; i < tab.length; i++) {
            if (i != x) {
                for (int j = 0; j < tab[0].length; j++) {
                    if (j != y) {
                        int a = i;
                        int b = j;
                        if (i > x) a -= 1;
                        if (j > y) b -= 1;
                        nowa[a][b] = tab[i][j];
                    }
                }
            }
        }
        wyswietl(nowa);
    }

}
