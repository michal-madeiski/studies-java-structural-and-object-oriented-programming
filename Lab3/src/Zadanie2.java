public class Zadanie2 {

    public static void tablicaMatematyczna(double a, double b, double x){
        System.out.printf("x        x^(1/2)  x^2      x^3      e(x)     log10(x) ln(x)");
        System.out.println();
        for (double i = a; i <= b+x; i += x){
            System.out.printf("%8f", i);
            System.out.print(" ");
            System.out.printf("%8f", Math.sqrt(i));
            System.out.print(" ");
            System.out.printf("%8f", i*i);
            System.out.print(" ");
            System.out.printf("%8f", i*i*i);
            System.out.print(" ");
            System.out.printf("%8f", Math.exp(i));
            System.out.print(" ");
            System.out.printf("%8f", Math.log10(i));
            System.out.print(" ");
            System.out.printf("%8f", Math.log(i));
            System.out.println();
        }
    }

    //Sprawdzenie:
    public static void main(String[] args) {
        double a = 1, b = 2, c = 0.1;
        tablicaMatematyczna(a, b, c);
    }
}
