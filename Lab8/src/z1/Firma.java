package z1;

public class Firma {
    private Pracownik[] firma;

    public Firma(int n) {
        this.firma = new Pracownik[n];
    }

    public int iloscPracownikow() {
        int ile = 0;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null) ile ++;
        }
        return ile;
    }

    public boolean czyJestNazwisko(String n) {
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null && firma[i].getNazwisko().equals(n)) return true;
        }
        return false;
    }

    public void zatrudnij(Pracownik p) {
        if (iloscPracownikow() <= firma.length && !czyJestNazwisko(p.getNazwisko())) {
            for (int i = 0; i < firma.length; i++) {
                if (firma[i] == null) {
                    firma[i] = p;
                    break;
                }
            }
        }
        else System.out.println("Nie można zatrudnić pracownika");
    }

    public void zwolnij(Pracownik p) {
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null && firma[i].equals(p)) firma[i] = null;
        }
    }

    public void ileZatrudnionychV() {
        int u = 0;
        int r = 0;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null && firma[i] instanceof Robotnik) r += 1;
            if (firma[i] != null && firma[i] instanceof Urzednik) u += 1;
        }
        System.out.println("Liczba robotników: " + r + ", liczba urzedników: " + u);
    }

    public void listaUrzednikow() {
        System.out.println("Lista urzędników:");
        int lp = 1;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null && firma[i] instanceof Urzednik) {
                System.out.printf("%s %s \n", lp, firma[i]);
                lp ++;
            }
        }
    }

    public void listaRobotnikow() {
        System.out.println("Lista robotników:");
        int lp = 1;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null && firma[i] instanceof Robotnik) {
                System.out.printf("%s %s \n", lp, firma[i]);
                lp ++;
            }
        }
    }

    public void listaPracownikow() {
        System.out.println("Lista pracowników:");
        int lp = 1;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null) {
                System.out.printf("%s %s \n", lp, firma[i]);
                lp ++;
            }
        }
    }

    public void listaPlac() {
        System.out.println("Lista płac:");
        int lp = 1;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null) {
                System.out.printf("%s %s  %.2f \n", lp, firma[i], firma[i].wynagrodzenie());
                lp ++;
            }
        }
    }

    public double sumaWyplatRobotnikow() {
        double suma = 0;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null && firma[i] instanceof Robotnik) suma += firma[i].wynagrodzenie();
        }
        return suma;
    }

    public double sumaWyplatUrzednikow() {
        double suma = 0;
        for (int i = 0; i < firma.length; i++) {
            if (firma[i] != null && firma[i] instanceof Urzednik) suma += firma[i].wynagrodzenie();
        }
        return suma;
    }

    public double sumaWyplat() {
        return sumaWyplatRobotnikow() + sumaWyplatUrzednikow();
    }

}
