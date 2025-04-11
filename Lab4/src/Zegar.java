public class Zegar {

    //------------------------------------------------------------------------------------//
    //Atrybuty:

    private int godz;
    private int min;
    private int sek;
    private static int ile = 0;

    //------------------------------------------------------------------------------------//
    //Konstruktory:

    public Zegar(int godz, int min, int sek) {
        if (czyPoprawne(godz, min, sek)) {
            this.godz = godz;
            this.min = min;
            this.sek = sek;
            ile += 1;
        } else {
            System.out.println("Czas nie jest poprawny!");
            throw new IllegalArgumentException();
        }
    }

    public Zegar() {
        godz = 13;
        min = 30;
        sek = 30;
    }

    //------------------------------------------------------------------------------------//
    //Gettery i settery:

    public int getGodz() {
        return godz;
    }

    public void setGodz(int godz) {
        this.godz = godz;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSek() {
        return sek;
    }

    public void setSek(int sek) {
        this.sek = sek;
    }

    //------------------------------------------------------------------------------------//
    //Metody:

    public boolean czyPoprawne(int g, int m, int s) {
        if ((g >= 0 && g <= 23) && (m >= 0 && m <= 59) && (s >= 0 && s <= 59)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String g;
        String m;
        String s;
        if (godz >= 0 && godz <= 9) {
            g = "0" + godz;
        } else {
            g = String.valueOf(godz);
        }
        if (min >= 0 && min <= 9) {
            m = "0" + min;
        } else {
            m = String.valueOf(min);
        }
        if (sek >= 0 && sek <= 9) {
            s = "0" + sek;
        } else {
            s = String.valueOf(sek);
        }
        return g + ":" + m + ":" + s;
    }

    public void wyswietl() {
        System.out.println(toString());
    }

    public boolean equals(int g, int m, int s) {
        if (czyPoprawne(g, m, s)) {
            if (godz == g && min == m && sek == s) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("Czas nie jest poprawny!");
            throw new IllegalArgumentException();
        }
    }

    public void plusGodz() {
        if (godz < 23) {
            godz += 1;
            setGodz(godz);
        } else {
            setGodz(0);
        }
    }

    public void minusGodz() {
        if (godz <= 23 && godz >= 1) {
            godz -= 1;
            setGodz(godz);
        } else if (godz == 0) {
            setGodz(23);
        }
    }

    public void plusSek() {
        if (sek + 1 <= 59) {
            sek += 1;
            setSek(sek);
        } else if (sek + 1 == 60) {
            setSek(0);
            min += 1;
            if (min == 60) {
                setMin(0);
                plusGodz();
            } else {
                setMin(min);
            }
        }
    }

    public void plusSek(int n) {
        if (n < 60) {
            if (sek + n <= 59) {
                sek += n;
                setSek(sek);
            } else if (sek + n >= 60) {
                sek += (n - 60);
                setSek(sek);
                min += 1;
                if (min == 60) {
                    setMin(0);
                    plusGodz();
                } else {
                    setMin(min);
                }
            }
        }
    }

    public int compare(int g, int m, int s) {
        if (czyPoprawne(g, m, s)) {
            if (godz == g) {
                if (min == m) {
                    if (sek == s) {
                        return 0;
                    } else if (sek < s) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else if (min < m) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (godz < g) {
                return -1;
            } else {
                return 1;
            }
        } else {
            System.out.println("Czas nie jest poprawny!");
            throw new IllegalArgumentException();
        }
    }

    //------------------------------------------------------------------------------------//
    //Main:

    public static void main(String[] args) {

        //Pomocnicze do testowania:
        Zegar test = new Zegar();
        int t1 = test.getGodz();
        int t2 = test.getMin();
        int t3 = test.getSek();

        //Test1:
        System.out.println("Test1: ");
        Zegar zegar1 = new Zegar(23, 30, 30);
        System.out.print("wyswietlenie czasu: "); zegar1.wyswietl();
        System.out.println("czy rowny z " + test + ": " + zegar1.equals(t1, t2, t3));
        zegar1.plusGodz();
        System.out.print("po przestawieniu o 1godz. do przodu: ");zegar1.wyswietl();
        System.out.println();

        //Test2:
        System.out.println("Test2: ");
        Zegar zegar2 = new Zegar(0,30,20);
        System.out.print("czas " + zegar2 + " cofniety o 1godz.: "); zegar2.minusGodz(); zegar2.wyswietl();
        System.out.println();

        //Test3:
        System.out.println("Test3:");
        Zegar zegar3 = new Zegar(15, 59, 59);
        System.out.print("czas " + zegar3 + " przestawiony o 1sek. do przodu: "); zegar3.plusSek(); zegar3.wyswietl();
        System.out.println();

        //Test4:
        System.out.println("Test4:");
        Zegar zegar4 = new Zegar(13, 59, 59);
        int n = 7;
        System.out.print("czas " + zegar4 + " przestawiony o " + n + "sek. do przodu: "); zegar4.plusSek(n); zegar4.wyswietl();
        System.out.println();

        //Test5:
        System.out.println("Test5:");
        Zegar zegar5 = new Zegar(9, 24, 38);
        System.out.println("relacja " + zegar5 + " z " + test + ": " + zegar5.compare(t1, t2, t3));
        System.out.println();

        System.out.println("Ilość zegarów: " + ile);
    }
}
