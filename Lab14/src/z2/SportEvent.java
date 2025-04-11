package z2;

import java.util.HashSet;
import java.util.Set;

public class SportEvent implements Observable {
    String sportType;
    String name;
    double odds;
    boolean lotsOfInjuries;
    Set<Observer> observers;

    public SportEvent(String sportType, String name, double odds, boolean lotsOfInjuries) {
        this.sportType = sportType;
        this.name = name;
        this.odds = odds;
        this.lotsOfInjuries = lotsOfInjuries;
        observers = new HashSet<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getSportType() {
        return sportType;
    }
    public void setSportType(String sportType) {
        this.sportType = sportType;
    }
    public double getOdds() {
        return odds;
    }
    public void setOdds(double odds) {
        this.odds = odds;
    }
    public boolean isLotsOfInjuries() {
        return lotsOfInjuries;
    }
    public void setLotsOfInjuries(boolean lotsOfInjuries) {
        this.lotsOfInjuries = lotsOfInjuries;
    }
    public Set<Observer> getObservers() {
        return observers;
    }
    public void setObservers(Set<Observer> observers) {
        this.observers = observers;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
