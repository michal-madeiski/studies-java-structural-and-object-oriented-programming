package z1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class
Main_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nazwaPliku = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader((nazwaPliku)));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Kopia.txt"));

        int ileWierszow = 0;
        int ileWyrazow = 0;
        int ileZnakowCzarnych = 0;
        int ileZnakowWszystkich = 0;
        List<String> wyrazyWszystkie = new ArrayList<>();

        String s = br.readLine();
        while (s != null) {
            String wiersz = s;
            bw.write(s);
            bw.newLine();

            ileWierszow ++;

            String[] wyrazy = wiersz.split("[,.\\s]+");
            ileWyrazow += wyrazy.length;
            for (int i = 0; i < wyrazy.length; i++) {
                wyrazyWszystkie.add(wyrazy[i]);
            }

            String[] tokeny = wiersz.split("[\s]+");
            for (int i = 0; i < tokeny.length; i++) {
                ileZnakowCzarnych += tokeny[i].length();
            }

            String[] znaki = wiersz.split("");
            ileZnakowWszystkich += znaki.length;

            s = br.readLine();
        }
        br.close();
        bw.close();


        System.out.println("wiersze: " + ileWierszow);
        System.out.println("wyrazy: " + ileWyrazow);
        System.out.println("czarne znaki: " + ileZnakowCzarnych);
        System.out.println("wszystkie znaki: " + ileZnakowWszystkich);
        System.out.println("najdłuższy wyraz: " + najdluzszyWyraz(wyrazyWszystkie));
        System.out.print("Podaj wyraz: ");
        String x = sc.nextLine();
        System.out.println("ilość wystąpień wyrazu '" + x + "': " + iloscWystapienWyrazu(x, wyrazyWszystkie));

    }

    //metody pomocnicze:
    public static String najdluzszyWyraz(List<String> lista) {
        int dl = 0;
        String wyraz = " ";
        for (String s : lista) {
            if (s.length()>dl) {
                dl = s.length();
                wyraz = s;
            }
        }
        return wyraz;
    }

    public static int iloscWystapienWyrazu(String wyraz, List<String> lista) {
        int licznik = 0;
        for (String s : lista) {
            if (s.equals(wyraz)) licznik ++;
        }
        return licznik;
    }

}