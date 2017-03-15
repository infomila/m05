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
public enum TipusVehicle {
    COTXE("Cotxe", "Cotxes"),
    MOTO("Moto", "Motos"),
    CAMIO("Camió", "Camions");
    
    private String mDesc;
    private String mDescPlural;
    TipusVehicle(String pDesc, String pDescPlural){
        mDesc = pDesc;
        mDescPlural = pDescPlural;
    }
    public String getDesc(){
        return mDesc;
    }    
    public String getDescPlural(){
        return mDescPlural;
    }
}
