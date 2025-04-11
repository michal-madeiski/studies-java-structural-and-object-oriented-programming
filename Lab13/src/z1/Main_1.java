package z1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main_1 {
    public static void main(String[] args) {
        List<String[]> Lista;

        try {
            Lista = wczytajDoListy("ATP_ranking.txt");
            wyswietlListe(Lista);
            System.out.println();

            String kraj = "SRB";
            tenisiciZKrajuWyswietl(Lista, kraj);
            System.out.println();

            String imie = "Alexander";
            String nazwisko = "Zverev";
            System.out.println("Numer " + imie + " " + nazwisko + ": " + numerTenisisty(Lista, imie, nazwisko));

            System.out.println();
            System.out.println("Średni wiek zawodników z Top10: " + sredniWiekTop10(Lista));

            zapisz(Lista);

        } catch (FileNotFoundException e) {
            System.out.println("Plik nie istnieje!");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static List<String[]> wczytajDoListy(String nazwaPliku) throws IOException {
        List<String[]> Lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(nazwaPliku));
        String pom = br.readLine();
        String wiersz = br.readLine();
        while (wiersz != null) {
            String[] t = wiersz.split("[!,.\\s]+");
            if (t.length > 7) {
                if (t.length == 8) {
                    String[] t_pom = new String[7];
                    for (int i = 0; i < t.length - 1; i++) {
                        if (i < 3) t_pom[i] = t[i];
                        if (i == 3) t_pom[i] = t[i] + " " + t[i + 1];
                        if (i > 3) t_pom[i] = t[i + 1];
                    }
                    Lista.add(t_pom);
                }
                if (t.length == 9) {
                    String[] t_pom = new String[7];
                    for (int i = 0; i < t.length - 2; i++) {
                        if (i < 3) t_pom[i] = t[i];
                        if (i == 3) t_pom[i] = t[i] + " " + t[i + 1] + " " + t[i + 2];
                        if (i > 3) t_pom[i] = t[i + 2];
                    }
                    Lista.add(t_pom);
                }
            } else Lista.add(t);
            wiersz = br.readLine();
        }
        br.close();
        return Lista;
    }

    public static void wyswietlListe(List<String[]> Lista) {
        System.out.printf("%-5s %-8s %-17s %-17s %-10s %-10s %-10s", "Rank", "Country", "Name", "Surname", "Age", "Points", "Tourn.Played");
        System.out.println();
        for (String[] t : Lista) {
            System.out.printf("%-5s %-8s %-17s %-17s %-10s %-10s %-10s \n", t[0], t[1], t[2], t[3], t[4], t[5], t[6]);
        }
    }

    public static void tenisiciZKrajuWyswietl(List<String[]> Lista, String kraj) {
        System.out.println("Gracze z " + kraj + ": ");
        for (String[] t : Lista) {
            if (t[1].equals(kraj)) System.out.print(t[2] + " " + t[3] + "\n");
        }
    }

    public static int tenisiciZKrajuLiczba(List<String[]> Lista, String kraj) {
        int licznik = 0;
        for (String[] t : Lista) {
            if (t[1].equals(kraj)) licznik ++;
        }
        return licznik;
    }

    public static int numerTenisisty(List<String[]> Lista, String imie, String nazwisko) {
        for (String[] t : Lista) {
            if (t[2].equals(imie) && t[3].equals(nazwisko)) return Integer.parseInt(t[0]);
        }
        return -1;
    }

    public static double sredniWiekTop10(List<String[]> Lista) {
        double sumaWiekow = 0;
        for (int i = 0; i < 10; i++) {
            sumaWiekow += Integer.parseInt(Lista.get(i)[4]);
        }
        return sumaWiekow/10;
    }

    public static void zapisz(List<String[]> Lista) throws IOException {
        HashSet<String> kraje = new HashSet<>();
        for (String[] t : Lista) {
            kraje.add(t[1]);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("plik.txt"));
        bw.write(String.format("%-3s %-7s %-10s \n", "Lp", "Kraj", "Liczba"));
        int lp = 1;
        for (String s : kraje) {
            bw.write(String.format("%-3s %-7s %-10s \n", lp, s, tenisiciZKrajuLiczba(Lista, s)));
            lp ++;
        }
        bw.close();
    }
}