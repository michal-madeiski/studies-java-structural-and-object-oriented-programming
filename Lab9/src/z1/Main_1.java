package z1;

public class Main_1 {
    public static void main(String[] args) {
        Garaz g = new Garaz();

        Ciezarowka c1 = new Ciezarowka("Ciezarowka1", 2432, 1987);
        Ciezarowka c2 = new Ciezarowka("Ciezarowka2", 2672, 2238);

        Samochod s1 = new Samochod("Samochod1", 1234, 6252.48);
        Samochod s2 = new Samochod("Samochod2", 1863, 4165.79);

        Traktor t1 = new Traktor("Traktor1", 627, 596);
        Traktor t2 = new Traktor("Traktor2", 729, 668);

        g.wstawPojazd(c1);
        g.wstawPojazd(c2);
        g.wstawPojazd(s1);
        g.wstawPojazd(s2);
        g.wstawPojazd(t1);
        g.wstawPojazd(t2);

        System.out.println("LISTA POJAZDOW:");
        g.listaPojazdow();
        System.out.println();

        System.out.println("LISTA SAMOCHODOW:");
        g.listaSamochodow();
        System.out.println();

        System.out.println("KOSZTY UTRZYMANIA:");
        System.out.printf("%-10.2f \n", g.wszystkieKoszty());
        System.out.println();

        System.out.println("KOSZTY UTRZYMANIA CIEZAROWEK:");
        System.out.printf("%-10.2f \n", g.kosztyCiezarowek());
    }
}