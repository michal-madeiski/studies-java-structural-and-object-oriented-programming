package z2;

import java.util.Random;

public class Tablica {
    protected SortowanieTablicy SortTab;

    private int[] tab;

    public Tablica(int n) {
        this.tab = new int[n];
        for (int i = 0; i < tab.length; i++) {
            Random r = new Random();
            tab[i] = r.nextInt(100);
        }
    }

    public void wyswietl() {
        for (int i = 0; i < tab.length; i++) {
            System.out.printf("%-4d", tab[i]);
        }
        System.out.println();
    }

    public int maksWartosc() {
        int maks = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > maks) maks = tab[i];
        }
        return maks;
    }

    public int minWartosc() {
        int min = maksWartosc();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] < min) min = tab[i];
        }
        return min;
    }

    public void ustawAlgorytmSortowania(int nr) {
        switch (nr) {
            case 1 -> this.SortTab = new AlgorytmSortowaniaTablicy_1();
            case 2 -> this.SortTab = new AlgorytmSortowaniaTablicy_2();
            case 3 -> this.SortTab = new AlgorytmSortowaniaTablicy_3();
        }
    }

    public void wykonajAlgorytmSortowania() {
        SortTab.AlgorytmSortowaniaTablicy(tab);
    }

    public void info() {
        SortTab.wyswietlInfo();
    }

}
