package z2;

import java.util.Scanner;

public class Main_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String zdanie = input.nextLine();
        String[] zdanieTab = zdanie.split("[\s]+");

        for (int i = zdanieTab.length - 1; i >= 0; i--) {
            System.out.print(zdanieTab[i] + " ");
        }

    }
}
