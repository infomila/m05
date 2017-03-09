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
public class TipusProducteNormal extends TipusProducte{

    @Override
    public double getPreuFinal(double preuBase, int numeroUnitats) {
        double descompteRappel = 0;
        int unitats = numeroUnitats;
        if (unitats >= 50 && unitats < 100) {
            descompteRappel = 10;
        } else if (unitats >= 100 && unitats < 200) {
            descompteRappel = 20;
        } else if (unitats >= 200) {
            descompteRappel = 30;
        }
        return preuBase * (1 - descompteRappel / 100);
    }

    @Override
    public String getDesc() {
        return "NORMAL";
    }
    
}
