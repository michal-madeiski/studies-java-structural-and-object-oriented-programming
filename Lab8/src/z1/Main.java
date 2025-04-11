package z1;

public class Main {
    public static void main(String[] args) {
        Firma f = new Firma(100);

        Robotnik r1 = new Robotnik("Kowalski", 1.25, 35.7, 154);
        Robotnik r2 = new Robotnik("Nowak", 1.0, 38.2, 208);
        Robotnik r3 = new Robotnik("Wójcik", 0.5, 32.4, 172);

        Urzednik u1 = new Urzednik("Szymański", 1.25,6248, 20);
        Urzednik u2 = new Urzednik("Woźniak", 1.0,7826, 40);
        Urzednik u3 = new Urzednik("Zieliński", 0.5,5988, 60);

        f.zatrudnij(r1);
        f.zatrudnij(r2);
        f.zatrudnij(u1);
        f.zatrudnij(r3);
        f.zatrudnij(u2);
        f.zatrudnij(u3);

        f.listaUrzednikow();
        System.out.println();
        f.listaRobotnikow();
        System.out.println();
        f.ileZatrudnionychV();
        System.out.println();
        f.listaPracownikow();
        System.out.println();
        f.listaPlac();
        System.out.println();
        System.out.printf("%s %.2f \n", "Suma wypłat urzędników:", f.sumaWyplatUrzednikow());
        System.out.printf("%s %.2f \n", "Suma wypłat robotników:", f.sumaWyplatRobotnikow());
        System.out.printf("%s %.2f \n", "Suma wypłat:", f.sumaWyplat());
        System.out.println();

        f.zwolnij(r3);
        f.zwolnij(u3);

        System.out.println("PO ZWOLNIENIACH:");
        f.listaPracownikow();

    }
}