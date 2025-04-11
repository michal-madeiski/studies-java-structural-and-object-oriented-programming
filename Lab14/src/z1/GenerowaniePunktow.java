package z1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerowaniePunktow {
    public static void main(String[] args) {
        int n;

        int zakres1, zakres2;

        n = 20; zakres1 = -20; zakres2 = 20;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("punkty.txt"));
            bw.write(String.format("%-5s %-5s \n", "x", "y"));
            for (int i = 0; i < n; i++) {
                Random r = new Random();
                int x = r.nextInt(zakres1,zakres2);
                int y = r.nextInt(zakres1,zakres2);
                bw.write(String.format("%-5d %-5d \n", x, y));
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
