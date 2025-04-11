public class Zadanie4 {
    public static boolean czyMoznaZbudowacTrojkat(double a, double b, double c){
        if (a+b>c && a+c>b && b+c>a){
            return true;
        }
        else{
            return false;
        }
    }
    public static double obwodTrojkata (double a, double b, double c){
        double obw = a + b + c;
        return obw;
    }
    public static double poleTrojkata(double a, double b, double c) {
        double s = (obwodTrojkata(a, b, c)) / 2;
        double pole = Math.sqrt(s * (s-a) * (s-b) * (s-c));
        return pole;
    }
    public static String rodzajTrojkataBoki(double a, double b, double c){
        String rodzaj;
        if (a==b){
            if (b==c){
                rodzaj = "Równoboczny";
            }
            else{
                rodzaj = "Równoramienny";
            }
        }
        else{
            if (b==c){
                rodzaj = "Równoramienny";
            }
            else{
                rodzaj = "Dowolny - różnoboczny";
            }
        }
        return rodzaj;
    }
    public static String rodzajTrojkataKaty(double a, double b, double c){
        String rodzaj;
        if ((a*a) + (b*b) > (c*c) && (a*a) + (c*c) > (b*b) && (c*c) + (b*b) > (a*a)){
            rodzaj = "Ostrokątny";
        }
        else if ((a*a) + (b*b) < (c*c) || (a*a) + (c*c) < (b*b) || (c*c) + (b*b) < (a*a)){
            rodzaj = "Rozwartokątny";
        }
        else {
            rodzaj = "Prostokątny";
        }
        return rodzaj;
    }
    public static void daneTrojkata(double a, double b, double c){
        if (czyMoznaZbudowacTrojkat(a, b, c) == false){
            System.out.println("To nie jest trójkąt!");
        }
        else{
            System.out.println("Dla trójkąta o bokach: " + a + ", " + b + ", " + c);
            System.out.println("Obwód: " + obwodTrojkata(a, b, c));
            System.out.println("Pole: " + poleTrojkata(a, b, c));
            System.out.println("Rodzaj (boki): " + rodzajTrojkataBoki(a, b, c));
            System.out.println("Rodzaj (kąty): " + rodzajTrojkataKaty(a, b, c));
        }
    }

    public static void main(String[] args) {
        double a = 3, b = 4, c = 5;
        daneTrojkata(a, b, c);
    }
}
