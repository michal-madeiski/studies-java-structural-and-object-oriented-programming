package Hotel2D;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private Pokoj[][] hotel;

    private int[] pokNaPietrze;

    public Hotel(int[] _pokNaPietrze) {
        pokNaPietrze = new int[_pokNaPietrze.length];
        int ilePieter = pokNaPietrze.length;
        this.hotel = new Pokoj[ilePieter][];
        for (int i = 0; i < ilePieter; i++) {
            hotel[i] = new Pokoj[_pokNaPietrze[i]];
            for (int j = 0; j < hotel[i].length; j++) {
                int nr = (i + 1) * 100 + (j + 1);
                hotel[i][j] = new Pokoj(nr);
            }
        }
    }

    public int ileWolnychPokoi() {
        int licznik = 0;
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (!hotel[i][j].czyZajety()) {
                    licznik += 1;
                }
            }
        }
        return licznik;
    }

    public int znajdzWolnyPokoj() {
        int szukany = -1;
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (!hotel[i][j].czyZajety()) {
                    szukany = hotel[i][j].getNumer();
                    break;
                }
            }
            if (szukany != -1) break;
        }
        return szukany;
    }

    public boolean czyWolnyPokoj(int nr) {
        int temp2 = (nr % 100) - 1;
        int temp1 = ((nr - (temp2 + 1)) / 100) - 1;
        return !hotel[temp1][temp2].czyZajety();
    }

    public void tempWynajmij(Osoba os, int nr) {
        int temp2 = (nr % 100) - 1;
        int temp1 = ((nr - (temp2 + 1)) / 100) - 1;
        hotel[temp1][temp2].setOsoba(os);
        System.out.println("Pokoj nr." + nr + " został wynajety przez: " + os);
    }

    public void wynajmijPokoj(Osoba os) {
        int nr = -1;
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (!hotel[i][j].czyZajety()) {
                    hotel[i][j].setOsoba(os);
                    nr = hotel[i][j].getNumer();
                    break;
                }
            }
            if (nr != -1) break;
        }
        if (nr == -1) System.out.println("Nie ma wolnego pokoju!");
        else System.out.println("Pokoj nr." + nr + " został wynajety przez: " + os);
    }

    public void wynajmijPokojKonkretny(Osoba os, int nr) {
        if (listaPokoi().contains(nr)) {
            if (czyWolnyPokoj(nr)) tempWynajmij(os, nr);
            else {
                System.out.print("Wybrany numer jest zajęty! Zostanie wynajęty pierwszy wolny pokój. ");
                wynajmijPokoj(os);
            }
        } else {
            System.out.println("Nie ma pokoju o takim numerze!");
        }
    }

    public void zwolnijZajetePrzez(Osoba os) {
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j].getOsoba() != null) if ((hotel[i][j].getOsoba()).equals(os)) hotel[i][j].zwolnijPokoj();
            }
        }
    }

    public void zwolnijPokojNr(int nr) {
        int temp2 = (nr % 100) - 1;
        int temp1 = ((nr - (temp2 + 1)) / 100) - 1;
        hotel[temp1][temp2].zwolnijPokoj();
    }

    public boolean czyOsobaWynajmuje(Osoba os) {
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if ((hotel[i][j].getOsoba()).equals(os)) return true;
            }
        }
        return false;
    }

    public List<Integer> listaWolnychPokoi() {
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (!hotel[i][j].czyZajety()) {
                    lista.add(hotel[i][j].getNumer());
                }
            }
        }
        return lista;
    }

    public List<Integer> listaPokoi() {
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                lista.add(hotel[i][j].getNumer());
            }
        }
        return lista;
    }

    public void listaGosci() {
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j].czyZajety()) {
                    System.out.println((hotel[i][j].getOsoba()).toString() + " " + hotel[i][j].getNumer());
                }
            }
        }
    }

}