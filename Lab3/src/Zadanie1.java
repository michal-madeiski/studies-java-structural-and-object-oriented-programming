public class Zadanie1 {

    //Tabliczka mnożenia:
    public static void tabliczkaMnozenia(int n){
        for (int i = 0; i <= n; i++){
            if (i == 0){
                System.out.print("\t");System.out.print(" ");
                for (int a = 1; a <= n; a++){
                    System.out.printf("%4d", a);
                }
                System.out.println();
                System.out.print("\t");System.out.print(" ");
                for (int a = 1; a <= n; a++) {
                    System.out.printf("%4s", "__");
                }
            }
            else {
                for (int j = 0; j <= n; j++) {
                    if (j == 0){
                        System.out.printf("%4d", i);
                        System.out.print("|");
                    }
                    else {
                        int x = (i * j);
                        System.out.printf("%4d", x);
                    }
                }
            }
            System.out.println();
        }
    }

    //Sprawdzenie:
    public static void main(String[] args) {
        int n = 10;
        tabliczkaMnozenia(n);
    }
}
