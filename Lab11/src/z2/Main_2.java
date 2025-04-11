package z2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj liczbę wierszy: " + "\n");
        int x = Integer.parseInt(sc.nextLine());
        System.out.print("Podaj liczbę kolumn: " + "\n");
        int y = Integer.parseInt(sc.nextLine());

        System.out.println("Podaj kolejne wiersze macierzy: ");
        List<String[]> wiersze = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            String[] temp = (sc.nextLine()).split(" ");
            wiersze.add(temp);
        }

        System.out.println();
        int[][] macierz = stworzMacierz(wiersze);
        zapiszDoPliku("Macierz.txt", macierz);

        int[][] macierz2 = odczytaj("Macierz.txt");
        System.out.println("Macierz: ");
        wyswietl(macierz2);

        double n = srednia(macierz2);
        System.out.println("średnia: " + n);

    }

    //metody pomocnicze:
    public static int[][] stworzMacierz(List<String[]> lista) {
        int x = lista.size();
        int y = (lista.get(0)).length;

        int[][] macierz = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                macierz[i][j] = Integer.parseInt(lista.get(i)[j]);
            }
        }

        return macierz;
    }

    public static void zapiszDoPliku(String nazwa, int[][] tab) throws IOException {
        PrintWriter pw = new PrintWriter(nazwa);

        pw.println("Macierz");
        pw.println(tab.length);
        pw.println(tab[0].length);

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                pw.print(String.format("%-4d", tab[i][j]));
            }
            pw.println();
        }

        pw.close();
    }

    public static int[][] odczytaj(String nazwa) throws IOException {
        Scanner sc = new Scanner(new File(nazwa));

        sc.nextLine();

        String a = sc.nextLine();
        int x = Integer.parseInt(a);
        String b = sc.nextLine();
        int y = Integer.parseInt(b);
        int[][] t = new int[x][y];

        for (int i = 0; i < x; i++) {
            String[] line = sc.nextLine().split("[\s]+");
            for (int j = 0; j < line.length; j++) {
                t[i][j] = Integer.parseInt(line[j]);
            }
        }

        sc.close();
        return t;
    }

    public static void wyswietl(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.printf("%-4d", tab[i][j]);
            }
            System.out.println();
        }
    }

    public static double srednia(int[][] t) {
        double suma = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                suma += t[i][j];
            }
        }
        return suma/(t.length*t[0].length);
    }

}



