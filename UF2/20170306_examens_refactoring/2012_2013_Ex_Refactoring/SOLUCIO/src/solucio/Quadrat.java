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
public class Quadrat  extends Forma{

    public Quadrat(double _mida) {
        super(Forma.QUADRAT, _mida);
    }

    @Override
    public String getNom() {
        return "Quadrat";
    }

    @Override
    public double getArea() {
        return getMida() * getMida() ;
    }
    
}