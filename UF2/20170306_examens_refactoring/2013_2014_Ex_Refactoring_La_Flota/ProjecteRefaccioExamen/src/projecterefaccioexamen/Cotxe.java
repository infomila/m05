/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecterefaccioexamen;

/**
 *
 * @author BERNAT
 */
public class Cotxe extends Vehicle {

    public Cotxe(int pes, String matricula, TipusBenzina tipusBenzina, int capacitatDiposit) {
        super(pes, TipusVehicle.COTXE, matricula, tipusBenzina, capacitatDiposit);
    }

    @Override
    public String getDescripcioTipus() {
        return "Cotxe";
    }

    @Override
    public int getConsum() {
        int consumL100Km = 6;
        if (getPes() < 1000) {
            consumL100Km = 4;
        } else if (getPes() > 2500) {
            consumL100Km = 10;
        } else if (getPes() > 3500) {
            consumL100Km = 14;
        }
        return consumL100Km;
    }

}
