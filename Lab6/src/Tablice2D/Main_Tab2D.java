package Tablice2D;

public class Main_Tab2D {
    public static void main(String[] args) {
        Tab2D tab1 = new Tab2D(4,5);
        tab1.wypelnij(20);

        System.out.println("wyświetlenie wierszami:");
        tab1.wyswietlWierszami();
        System.out.println();

        System.out.println("wyświetlenie kolumnami");
        tab1.wyswietlKolumnami();
        System.out.println();

        System.out.println("suma elementów: " + tab1.sumaElementow());

        System.out.print("maks wartość: " + tab1.maks() + ", indeksy: "); tab1.indeksyWartosci(tab1.maks());

        int n = 21;
        System.out.print("indeksy wartości = " + n + ": "); tab1.indeksyWartosci(21);

        System.out.print("Sumy w kolumnach: ");
        for (int s : tab1.sumyWKolumnach()) {
            System.out.printf("%s", s + " ");
        }
        System.out.println();

        tab1.maksSumaKolumny();
        System.out.println();

        System.out.println("Po usunięciu wiersza i kolumny wartości maks:");
        tab1.usunWedlugMaksElementu();
    }

}