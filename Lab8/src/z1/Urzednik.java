package z1;

public class Urzednik extends Pracownik{
    private double placa;
    private double premia;
    public Urzednik(String nazwisko, double staz, double placa, double premia) {
        super(nazwisko, staz);
        this.placa = placa;
        this.premia = premia/100;
    }

    public double wynagrodzenie() {
        return placa*staz + premia*placa*staz;
    }

    @Override
    public String toString() {
        return super.toString() + " urzędnik";
    }
}
