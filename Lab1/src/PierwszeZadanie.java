public class PierwszeZadanie {
    public static double wyrazenie(int a, int b){
        double z = (2*a + 3*a*b) / Math.sqrt(a*a + b*b);
        return z;
    }

    public static void main(String[] args) {
        System.out.println(wyrazenie(4, 3));
    }
}

