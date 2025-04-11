package z2;

import java.util.ArrayList;
import java.util.List;

public class Player implements Observer {
    String name;
    List<String> favouriteSports;
    double maximumOdds;
    double minimumOdds;
    List<SportEvent> sportEvents;

    public Player(String name, List<String> favouriteSports, double maximumOdds, double minimumOdds) {
        this.name = name;
        this.favouriteSports = favouriteSports;
        this.maximumOdds = maximumOdds;
        this.minimumOdds = minimumOdds;
        sportEvents = new ArrayList<>();
    }

    @Override
    public void update(SportEvent sportEvent) {
        if (favouriteSports.contains(sportEvent.getSportType()) && sportEvent.getOdds() >= minimumOdds && sportEvent.getOdds() <= maximumOdds && !sportEvent.isLotsOfInjuries()) {
            System.out.println("Wydarzenie - " + sportEvent.getName() + " - spełnia warunki: " + name);
        } else System.out.println("Wydarzenie - " + sportEvent.getName() + " - nie spełnia warunków: " + name);
    }

    public void watchEvent(SportEvent s) {
        s.addObserver(this);
        sportEvents.add(s);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getFavouriteSports() {
        return favouriteSports;
    }
    public void setFavouriteSports(List<String> favouriteSports) {
        this.favouriteSports = favouriteSports;
    }
    public double getMaximumOdds() {
        return maximumOdds;
    }
    public void setMaximumOdds(double maximumOdds) {
        this.maximumOdds = maximumOdds;
    }
    public double getMinimumOdds() {
        return minimumOdds;
    }
    public void setMinimumOdds(double minimumOdds) {
        this.minimumOdds = minimumOdds;
    }
    public List<SportEvent> getSportEvents() {
        return sportEvents;
    }
    public void setSportEvents(List<SportEvent> sportEvents) {
        this.sportEvents = sportEvents;
    }
}
