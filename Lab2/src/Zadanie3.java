public class Zadanie3 {
    public static double oblicz (double n){
        double ns = ((n/Math.E)*(n/Math.E))*Math.sqrt(2*Math.PI*n);
        return ns;
    }

    public static void main(String[] args) {
        double n1 = 10;
        double n2 = 100;
        System.out.println("dla n=10:" + oblicz(n1) + "," + "dla n=100:" + oblicz(n2));
    }
}
