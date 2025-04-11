public class Zadanie2 {
    public static double oblicz(double t, double v){
        int c = 299792458;
        double tp = t/(Math.sqrt(1 - ((v*v)/(c*c))));
        return tp;
    }

    public static void main(String[] args) {
        double v = 10, t = 5.55;
        System.out.println(oblicz(t, v));
        System.out.printf("%f", oblicz(t, v));
    }
}
