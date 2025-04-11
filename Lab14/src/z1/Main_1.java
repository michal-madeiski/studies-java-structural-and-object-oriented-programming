package z1;

import java.io.*;
import java.util.*;

public class Main_1 {
    public static void main(String[] args) {

        try {
            ArrayList<int[]> punkty = odczyt("punkty.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter("wyniki.txt"));
            bw.write("PUNKT NAJBARDZIEJ ODLEGlY OD SRODKA: (" + pktOdSrodkaUkladu(punkty)[0] + "," + pktOdSrodkaUkladu(punkty)[1] + ")" + "\n");
            bw.write("WSPOLRZEDNE PROSTOKATA: " + prostokatString(prostokat(punkty)) + "\n");
            bw.write(String.format("%s %-4.2f %s \n", "NAJWIEKSZA ODLEGLOSC:", najwiekszaOdleglosc(punkty), prostokatString(najwiekszaOdlegloscPunkty(punkty))));
            bw.write("PUNKTY W KOLEJNOSCI ODLEGLOSCI OD SRODKA UKLADU: \n");
            for (Map.Entry<int[], Double> x : zbiorPunktow(punkty)) {
                bw.write(String.format("%s %-4.2f \n", pktToString(x.getKey()), x.getValue()));
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<int[]> odczyt(String nazwaPliku) throws IOException {
        ArrayList<int[]> punkty = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(nazwaPliku));
        br.readLine();

        String wiersz = br.readLine();
        while (wiersz != null) {
            String[] s = wiersz.split("[\s]+");
            int[] para = new int[2];
            para[0] = Integer.parseInt(s[0]);
            para[1] = Integer.parseInt(s[1]);
            punkty.add(para);
            wiersz = br.readLine();
        }
        br.close();
        return punkty;
    }

    public static int[] pktOdSrodkaUkladu(List<int[]> lista) {
        double odleglosc = 0;
        int[] pktReturn = new int[2];

        for (int[] pkt : lista) {
            double pom = Math.sqrt(pkt[0]*pkt[0] + pkt[1]*pkt[1]);
            if (pom > odleglosc) {
                odleglosc = pom;
                pktReturn = pkt;
            }
        }
        return pktReturn;
    }

    public static double odlegloscOdSrodkaUkladu(int[] pkt) {
        return Math.sqrt(pkt[0]*pkt[0] + pkt[1]*pkt[1]);
    }

    public static ArrayList<int[]> prostokat(List<int[]> lista) {
        ArrayList<int[]> wspolrzedneProstokata = new ArrayList<>();
        int dol = 0;
        int gora = 0;
        int lewo = 0;
        int prawo = 0;

        for (int[] pkt : lista) {
            if (pkt[0] > prawo) prawo = pkt[0];
            if (pkt[0] < lewo) lewo = pkt[0];
            if (pkt[1] > gora) gora = pkt[1];
            if (pkt[0] < dol) dol = pkt[1];
        }

        //dol -=1; gora +=1; lewo -=1; prawo +=1;

        int[] lewyGorny = {lewo, gora};
        int[] prawyGorny = {prawo, gora};
        int[] lewyDolny = {lewo, dol};
        int[] prawyDolny = {prawo, dol};

        wspolrzedneProstokata.add(lewyDolny); wspolrzedneProstokata.add(prawyDolny);
        wspolrzedneProstokata.add(lewyGorny); wspolrzedneProstokata.add(prawyGorny);

        return wspolrzedneProstokata;
    }

    public static String prostokatString(ArrayList<int[]> lista) {
        String p = "";
        for (int[] pkt : lista) {
            p += "(" + pkt[0] + "," + pkt[1] + ")" + " ";
        }
        return p;
    }

    public static double odlegloscDwochPkt(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    public static double najwiekszaOdleglosc(List<int[]> lista) {
        double maxOdleglosc = 0;
        int[] pkt1 = {0, 0};
        int[] pkt2 = {0, 0};
        for (int[] p1 : lista) {
            for (int[] p2 : lista) {
                double odleglosc = odlegloscDwochPkt(p1, p2);
                if (odleglosc > maxOdleglosc) {
                    maxOdleglosc = odleglosc;
                    pkt1[0] = p1[0]; pkt1[1] = p1[1];
                    pkt2[0] = p2[0]; pkt2[1] = p2[1];
                }
            }
        }
        return maxOdleglosc;
    }

    public static ArrayList<int[]> najwiekszaOdlegloscPunkty(List<int[]> lista) {
        ArrayList<int[]> punkty = new ArrayList<>();
        double maxOdleglosc = 0;
        int[] pkt1 = {0, 0};
        int[] pkt2 = {0, 0};
        for (int[] p1 : lista) {
            for (int[] p2 : lista) {
                double odleglosc = odlegloscDwochPkt(p1, p2);
                if (odleglosc > maxOdleglosc) {
                    maxOdleglosc = odleglosc;
                    pkt1[0] = p1[0]; pkt1[1] = p1[1];
                    pkt2[0] = p2[0]; pkt2[1] = p2[1];
                }
            }
        }
        punkty.add(pkt1);
        punkty.add(pkt2);
        return punkty;
    }

    public static ArrayList<Map.Entry<int[], Double>> zbiorPunktow(List<int[]> lista) {
        HashMap<int[], Double> mapa = new HashMap<>();
        for (int[] p : lista) {
            mapa.put(p, odlegloscOdSrodkaUkladu(p));
        }
        ArrayList<Map.Entry<int[], Double>> entryList = new ArrayList<>(mapa.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        return entryList;
    }

    public static String pktToString(int[] p) {
        return "(" + p[0] + "," + p[1] + ")";
    }

}