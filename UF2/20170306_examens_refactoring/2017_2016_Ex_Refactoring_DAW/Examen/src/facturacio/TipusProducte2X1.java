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
public class TipusProducte2X1 extends TipusProducte{

    @Override
    public double getPreuFinal(double preuBase, int numeroUnitats) {
        int unitatsPagades = (int) (numeroUnitats / 2);
        // Si el nombre  de productes es senar, cal incrementar en un les unitats pagades
        unitatsPagades += numeroUnitats % 2;
        return preuBase * (unitatsPagades / (double) numeroUnitats);        
    }

    @Override
    public String getDesc() {
        return "2X1";
    }
    
}
