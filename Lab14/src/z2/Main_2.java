package z2;

import java.util.Arrays;

public class Main_2 {
    public static void main(String[] args) {
        SportEvent s1 = new SportEvent("Piłka nożna", "Manchester United VS Manchester City", 1.82, false);
        SportEvent s2 = new SportEvent("Siatkówka", "Polska VS USA", 2.23, false);

        Player p1 = new Player("Michał", Arrays.asList("Piłka nożna", "Koszykówka"), 2.00, 1.50);
        Player p2 = new Player("Tomek", Arrays.asList("Piłka nożna", "Siatkówka"), 3.00, 2.00);
        Player p3 = new Player("Janek", Arrays.asList("Piłka nożna"), 1.00, 1.50);

        p1.watchEvent(s1);
        p2.watchEvent(s1);
        p3.watchEvent(s1);
        p1.watchEvent(s2);
        p2.watchEvent(s2);

        System.out.println("SYMULACJA 1:");
        s1.notifyObservers();
        s2.notifyObservers();
        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("SYMULACJA 2:");
        s1.setOdds(1.22);
        s1.removeObserver(p2);

        s1.notifyObservers();
        s2.notifyObservers();
        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("SYMULACJA 3:");
        s2.setLotsOfInjuries(true);
        s1.removeObserver(p3);
        s2.removeObserver(p1);

        s1.notifyObservers();
        s2.notifyObservers();
        System.out.println("------------------------------------------------------------------------------------");

    }
}
