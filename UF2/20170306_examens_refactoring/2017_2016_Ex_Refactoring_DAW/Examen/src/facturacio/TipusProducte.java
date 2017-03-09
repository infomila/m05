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
public abstract class TipusProducte {
    
    public abstract double getPreuFinal(double preuBase, int numeroUnitats);
    public abstract String getDesc();
    
}
