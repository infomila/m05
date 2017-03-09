/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucio;

/**
 *
 * @author BERNAT
 */
public class Cercle  extends Forma{

    public Cercle(double _mida) {
        super(Forma.CERCLE, _mida);
    }

    @Override
    public String getNom() {
        return "Cercle";
    }

    @Override
    public double getArea() {
        return Math.PI *getMida() * getMida() ;
    }
    
}