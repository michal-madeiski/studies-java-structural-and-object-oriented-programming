package Zadanie2;

public class Zad2 {

    public static void ileJakichCyfr(int n) {
        int[] tab = new int[10];
        while (n > 0) {
            int liczba = n % 10;
            tab[liczba] += 1;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("cyfra: " + i + "\t" + "ilosc wystapien: " + tab[i]);
        }
    }

    public static void main(String[] args) {
    ileJakichCyfr(12234325);
    }


}





