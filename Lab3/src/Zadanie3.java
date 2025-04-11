import java.util.Scanner;

public class Zadanie3 {

    //Czy liczba jest pierwsza?
    public static boolean czyPierwsza(int n){
        if (n == 0 || n == 1) {
            return false;
        }
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //Wypisywanie liczb pierwszych:
    public static void wypiszPierwsze(int a, int b){
        for (int i = a; i <= b; i++){
            if (czyPierwsza(i)){
                System.out.println(i);
            }
        }
    }

    //Sprawdzenie:
    public static void main(String[] args) {
        int a = 0, b = 100;
        System.out.println("Liczby pierwsze z zakresu " + a + "-" + b + ": ");
        wypiszPierwsze(a, b);
    }
}
