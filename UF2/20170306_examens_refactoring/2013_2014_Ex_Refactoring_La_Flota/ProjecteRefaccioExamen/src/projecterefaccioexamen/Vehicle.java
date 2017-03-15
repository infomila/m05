package projecterefaccioexamen;

/**
 *
 */
public abstract class Vehicle {




    private int pes;
    private TipusVehicle tipus;
    private String matricula;
    private TipusBenzina tipusBenzina;
    private int capacitatDiposit;

    public Vehicle(int pes, TipusVehicle tipus, String matricula, TipusBenzina tipusBenzina, int capacitatDiposit) {
        this.pes = pes;
        this.tipus = tipus;
        this.matricula = matricula;
        this.tipusBenzina = tipusBenzina;
        this.capacitatDiposit = capacitatDiposit;
    }

    public int getPes() {
        return pes;
    }

    public TipusVehicle getTipus() {
        return tipus;
    }

    public String getMatricula() {
        return matricula;
    }

    public TipusBenzina getTipusBenzina() {
        return tipusBenzina;
    }

    public int getCapacitatDiposit() {
        return capacitatDiposit;
    }

    public abstract String getDescripcioTipus();

    public abstract int getConsum();

}
