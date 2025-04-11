package z2;

import java.util.*;

public class Main_2 {
    static List<Character> p1 = Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'N', 'n', 'O', 'o', 'R', 'r', 'S', 's', 'W', 'w', 'Z', 'z');
    static List<Character> p2 = Arrays.asList('C', 'c', 'D', 'd', 'K', 'k', 'L', 'l', 'M', 'm', 'P', 'p', 'T', 't', 'Y', 'y');
    static List<Character> p3 = Arrays.asList('B', 'b', 'G', 'g', 'H', 'h', 'J', 'j', 'Ł', 'ł', 'U', 'u');
    static List<Character> p5 = Arrays.asList('Ą', 'ą', 'Ę', 'ę', 'F', 'f', 'Ó', 'ó', 'Ś', 'ś', 'Ż', 'ż');
    static List<Character> p6 = Arrays.asList('Ć', 'ć');
    static List<Character> p7 = Arrays.asList('Ń', 'ń');
    static List<Character> p9 = Arrays.asList('Ź', 'ź');

    public static void main(String[] args) {
        System.out.println("START GRY SCRABBLE:");
        Scanner sc = new Scanner(System.in);
        String wiersz = sc.nextLine();

        HashMap<String, Integer> mapa = new HashMap<>();

        while (!wiersz.equals("end")) {
            System.out.println(obliczPunkty(wiersz));
            if (mapa.containsKey(wiersz)) mapa.put(wiersz, mapa.get(wiersz) + obliczPunkty(wiersz));
            else mapa.put(wiersz, obliczPunkty(wiersz));
            wiersz = sc.nextLine();
        }
        System.out.println("KONIEC GRY SCRABBLE!");
        System.out.println();
        System.out.printf("%-10s %-10s \n", "SŁOWO", "PUNKTY");
        wyswietlMapeMalejacoWedlugWartosci(mapa);
    }

    public static int obliczPunkty(String wyraz) {
        int pkt = 0;
        for (int i = 0; i < wyraz.length(); i++) {
            char litera = wyraz.charAt(i);
            if (p1.contains(litera)) pkt += 1;
            if (p2.contains(litera)) pkt += 2;
            if (p3.contains(litera)) pkt += 3;
            if (p5.contains(litera)) pkt += 5;
            if (p6.contains(litera)) pkt += 6;
            if (p7.contains(litera)) pkt += 7;
            if (p9.contains(litera)) pkt += 9;

        }
        return pkt;
    }
    public static void wyswietlMapeMalejacoWedlugWartosci(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<String, Integer> p : entryList) {
            System.out.printf("%-10s %-10d \n", p.getKey(), p.getValue());
        }
    }
}
