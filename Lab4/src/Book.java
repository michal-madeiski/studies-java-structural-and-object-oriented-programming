public class Book {

    //------------------------------------------------------------------------------------//
    //Atrybuty:

    private String autor;
    private String tytul;
    private int strony;
    private boolean wypozyczona;

    //------------------------------------------------------------------------------------//
    //Konstruktory:

    public Book(String autor, String tytul, int strony) {
        this.autor = autor;
        this.tytul = tytul;
        this.strony = strony;
        this.wypozyczona = false;
    }

    public Book() {
        autor = "Adam Mickiewicz";
        tytul = "Pan Tadeusz";
        strony = 500;
        wypozyczona = false;
    }

    //------------------------------------------------------------------------------------//
    //Gettery i settery:

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getStrony() {
        return strony;
    }

    public void setStrony(int strony) {
        this.strony = strony;
    }

    public boolean isWypozyczona() {
        return wypozyczona;
    }

    public void setWypozyczona(boolean wypozyczona) {
        this.wypozyczona = wypozyczona;
    }

    //------------------------------------------------------------------------------------//
    //Metody:

    public boolean czyDostepna() {
        if (wypozyczona) {
            return false;
        } else {
            return true;
        }
    }

    public void wypozycz() {
        if (czyDostepna()) {
            System.out.println("OK");
            setWypozyczona(true);
        } else {
            System.out.println("Ksiazka juz jest wypozyczona");
        }
    }

    public void zwrot() {
        System.out.println("Ksiazka zwrocona");
        setWypozyczona(false);
    }

    public String toString() {
        String dane = "";
        dane += "Autor: " + autor + "\n";
        dane += "Tytuł: " + tytul + "\n";
        dane += "Strony: " + strony + "\n";
        dane += "Wypozyczona: " + wypozyczona + "\n";
        return dane;
    }

    public void wyswietl() {
        String dane = toString();
        System.out.println(dane);
    }

    //------------------------------------------------------------------------------------//
    //Main:

    public static void main(String[] args) {

        Book book1 = new Book("Michał", "Programowanie", 100);
        book1.wyswietl();

        System.out.print("Wypozyczenie: "); book1.wypozycz();
        System.out.print("Ponowne wypozyczenie: "); book1.wypozycz();
        System.out.print("Zwrot: "); book1.zwrot();
    }
}
