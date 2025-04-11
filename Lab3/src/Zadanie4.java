public class Zadanie4 {

    //NWD - metoda z odejmowaniem:
    public static int NWDodejmowanie(int a, int b) {
        if (a == 0) {
            return b;
        } else {
            if (b == 0) {
                return a;
            } else {
                while (a != b) {
                    if (a > b) {
                        a -= b;
                    } else {
                        b -= a;
                    }
                }
                return a;
            }
        }
    }

    //NWD - metoda z dzieleniem z resztą:
    public static int NWDreszta(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            while (b != 0) {
                int reszta = a % b;
                a = b;
                b = reszta;
            }
            return a;
        }
    }

    //Sprawdzenie:
    public static void main(String[] args) {
        int a = 36, b = 48;
        System.out.println("NWD " + a + ", " + b + " - metoda z odejmowaniem: " + NWDodejmowanie(a, b));
        System.out.println("NWD " + a + ", " + b + " - metoda z dzieleniem z resztą: " + NWDreszta(a, b));
    }
}
