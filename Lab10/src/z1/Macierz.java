package z1;

import java.io.*;
import java.util.Random;

public class Macierz {
    private int tab[][];

    public Macierz(int x, int y) {
        tab = new int[x][y];
    }

    public void wypelnij(int z) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                Random r = new Random();
                tab[i][j] = r.nextInt(z);
            }
        }
    }

    public void wyswietl() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.printf("%-4d", tab[i][j]);
            }
            System.out.println();
        }
    }

    public void zapiszDoPliku(String nazwa) throws IOException {
        File plik = new File(nazwa);
        FileWriter fw = new FileWriter(plik);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Macierz");
        bw.newLine();
        bw.write(Integer.toString(tab.length));
        bw.newLine();
        bw.write(Integer.toString(tab[0].length));
        bw.newLine();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                bw.write(String.format("%-4d", tab[i][j]));
            }
            bw.newLine();
        }

        bw.close();
    }

    public int[][] odczytaj(String nazwa) throws IOException {
        File plik = new File(nazwa);
        FileReader fr = new FileReader(plik);
        BufferedReader br = new BufferedReader(fr);

        br.readLine();

        String a = br.readLine();
        int x = Integer.parseInt(a);
        String b = br.readLine();
        int y = Integer.parseInt(b);
        int[][] t = new int[x][y];

        for (int i = 0; i < x; i++) {
            String[] line = br.readLine().split("[\s]+");
            for (int j = 0; j < line.length; j++) {
                t[i][j] = Integer.parseInt(line[j]);
            }
        }

        br.close();
        return t;
    }

}
