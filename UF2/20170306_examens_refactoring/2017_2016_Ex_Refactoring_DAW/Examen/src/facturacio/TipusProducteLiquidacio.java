/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacio;

/**
 *
 * @author BERNAT
 */
public class TipusProducteLiquidacio extends TipusProducte{

    @Override
    public double getPreuFinal(double preuBase, int numeroUnitats) {
        return preuBase* 0.30;
    }

    @Override
    public String getDesc() {
        return "LIQUIDACIO";
    }
    
}
