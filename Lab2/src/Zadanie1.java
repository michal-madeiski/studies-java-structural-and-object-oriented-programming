public class Zadanie1 {
    public static double oblicz (double x, double s, double m) {
        double fx = 1/(s*Math.sqrt(2*Math.PI)) * Math.exp((-((x-m)*(x-m)))/(2*s*s));
        return fx;
    }

    public static void main(String[] args) {
        System.out.println("fx = " + oblicz(1, 2.5, 1.5));
    }
}
