/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojunit;

/**
 *
 * @author BERNAT
 */
public class Prova {
 
    
    
    /**
     * 
     * @param preu  -->23.45
     * @param descompte 10%  --> 0.10 
     * @return 
     */
    public double aplicaDescompte( double preu, double descompte ) {
        return preu * ( 1-descompte);
    }
    
    
}
