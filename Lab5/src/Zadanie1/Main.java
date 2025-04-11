package Zadanie1;

public class Main {

    public static void main(String[] args) {
        Tablica tab1 = new Tablica(20);
        tab1.random(300, 315);

        System.out.print("wyswietlenie tablicy: ");tab1.wyswietl();
        System.out.println();
        System.out.print("odwrocona tablica: ");tab1.odwroc();
        System.out.println();
        System.out.println("indeks zadanego elementu: " + tab1.wyszukajIndeksElementu(299));
        System.out.println("najwieksza wartosc: " + tab1.maks() + " jej indeks: " + tab1.wyszukajIndeksElementu(tab1.maks()));
        System.out.println("najmniejsza wartosc: " + tab1.min() + " jej indeks: " + tab1.wyszukajIndeksElementu(tab1.min()));
        System.out.println("czy roznowartosciowa: " + tab1.czyRoznowartosciowa());
        System.out.print("po usunieciu: ");tab1.zrobRoznowartosciowa();
    }


}