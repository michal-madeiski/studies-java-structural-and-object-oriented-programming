package z2;

public class Main_2 {
    public static void main(String[] args) {
        System.out.println("TEST - STRATEGIA1:");
        Tablica t1 = new Tablica(20);
        t1.ustawAlgorytmSortowania(1);
        t1.info();
        t1.wyswietl();
        t1.wykonajAlgorytmSortowania();
        t1.wyswietl();

        System.out.println();

        System.out.println("TEST - STRATEGIA2:");
        Tablica t2 = new Tablica(20);
        t2.ustawAlgorytmSortowania(2);
        t2.info();
        t2.wyswietl();
        t2.wykonajAlgorytmSortowania();
        t2.wyswietl();

        System.out.println();

        System.out.println("TEST - STRATEGIA3:");
        Tablica t3 = new Tablica(20);
        t3.ustawAlgorytmSortowania(3);
        t3.info();
        t3.wyswietl();
        t3.wykonajAlgorytmSortowania();
        t3.wyswietl();

    }
}
