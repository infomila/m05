package projecterefaccioexamen;

/**
 *
 * @author BERNAT
 */
public class Moto extends Vehicle {

    public Moto(int pes,String matricula, TipusBenzina tipusBenzina, int capacitatDiposit) {
        super(pes, TipusVehicle.MOTO, matricula, tipusBenzina, capacitatDiposit);
    }

    @Override
    public String getDescripcioTipus() {
        return "Moto";
    }

    @Override
    public int getConsum() {
        int consumL100Km = getPes() / 50;
        if (consumL100Km == 0) {
            consumL100Km = 1;
        }
        return consumL100Km;
    }

}
