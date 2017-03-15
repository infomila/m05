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
public class Camio extends Vehicle{

    public Camio(int pes, String matricula, TipusBenzina tipusBenzina, int capacitatDiposit) {
        super(pes, TipusVehicle.CAMIO, matricula, tipusBenzina, capacitatDiposit);
    }

    @Override
    public String getDescripcioTipus() {
        return "Camió";
    }

    @Override
    public int getConsum() {
        return (int) (Math.log(getPes()) * 3.7);
    }
    
}
