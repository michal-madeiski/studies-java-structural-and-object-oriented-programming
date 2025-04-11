package Hotel2D;

public class Main {
    public static void main(String[] args) {
        int[] t = {3, 2, 1, 4, 2};
        Hotel hotel = new Hotel(t);
        System.out.println("Lista pokoi:" + hotel.listaPokoi());

        Osoba osoba1 = new Osoba("Osoba", "Pierwsza");
        Osoba osoba2 = new Osoba("Osoba", "Druga");
        Osoba osoba3 = new Osoba("Osoba", "Trzecia");

        System.out.println();
        System.out.println("Testowanie wynajmowania: ");
        hotel.wynajmijPokoj(osoba1);
        hotel.wynajmijPokoj(osoba2);
        hotel.wynajmijPokoj(osoba3);
        hotel.wynajmijPokoj(osoba2);

        System.out.println();
        System.out.println("Znajdowanie wolnego pokoju: " + hotel.znajdzWolnyPokoj());
        System.out.println("Ile wolnych pokoi? " + hotel.ileWolnychPokoi());
        System.out.println("Czy osoba " + osoba1 + " wynajmuje? " + hotel.czyOsobaWynajmuje(osoba1));

        System.out.println();
        System.out.println("Lista wolnych pokoi:" + hotel.listaWolnychPokoi());

        System.out.println();
        System.out.println("Lista gości: ");
        hotel.listaGosci();

        System.out.println();
        System.out.println("Testowanie zwalniania: ");
        hotel.zwolnijZajetePrzez(osoba2);
        hotel.zwolnijPokojNr(103);

        System.out.println();
        System.out.println("Testowanie wynajmowania konkretnego pokoju: ");
        hotel.wynajmijPokojKonkretny(osoba1, 402);
        hotel.wynajmijPokojKonkretny(osoba2, 601);
        hotel.wynajmijPokojKonkretny(osoba3, 402);

    }
}