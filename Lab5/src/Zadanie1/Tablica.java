package Zadanie1;

import java.util.Random;

public class Tablica {

    private int[] tab;

    public Tablica(int n) {

        this.tab = new int[n];
    }

    //------------------------------------------------------------------------------------------------------//

    public void wyswietl() {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i]);
            System.out.print(" ");
        }
    }

    public static void wyswietl(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]);
            System.out.print(" ");
        }
    }

    public void random(int z1, int z2) {
        for (int i = 0; i < tab.length; i++) {
            Random r = new Random();
            int x = r.nextInt(z1, z2);
            tab[i] = x;
        }
    }

    public void odwroc() {
        int[] odwrocona = new int[tab.length];
        for (int i = 0; i <= (tab.length - 1); i++) {
            odwrocona[i] = tab[tab.length - 1 -i];
        }
        wyswietl(odwrocona);
    }

    public int wyszukajIndeksElementu(int x) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int maks() {
        int n = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > n) {
                n = tab[i];
            }
        }
        return n;
    }

    public int min() {
        int n = maks();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < n) {
                n = tab[i];
            }
        }
        return n;
    }

    public boolean czyRoznowartosciowa() {
        for (int i = 0; i < maks(); i++) {
            int licznik = 0;
            for (int j = 0; j < tab.length; j++) {
                if (tab[j] == i) {
                    licznik += 1;
                }
            }
            if (licznik > 1) {
                return false;
            }
        } return true;
    }

    public static boolean czyWartoscWTablicy(int[] t, int n) {
        for (int i = 0; i < t.length ; i++) {
            if (t[i] == n) {
                return true;
            }
        } return false;
    }

    public void zrobRoznowartosciowa() {
        if (czyRoznowartosciowa()) {
            wyswietl();
        } else {
            int ileDoUsuniecia = 0;
            for (int i = min(); i <= maks(); i++) {
                int licznik = 0;
                for (int k : tab) {
                    if (k == i) {
                        licznik += 1;
                    }
                }
                if (licznik > 1) {
                    ileDoUsuniecia += (licznik - 1);
                }
            }
            int[] nowa = new int[tab.length - ileDoUsuniecia];
            for (int i = 0; i < nowa.length; i++) {
                nowa[i] = -1;
            }

            for (int i = 0; i < nowa.length; i++) {
                for (int k : tab) {
                    if (czyWartoscWTablicy(nowa, k) == false) {
                        nowa[i] = k;
                        break;
                    }
                }
            }
            wyswietl(nowa);
        }
    }


}
