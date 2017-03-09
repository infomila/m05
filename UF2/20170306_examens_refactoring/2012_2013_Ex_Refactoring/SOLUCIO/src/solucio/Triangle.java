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
public class Triangle extends Forma{

    public Triangle(double _mida) {
        super(Forma.TRIANGLE_RECTANGLE_ISOSCELES, _mida);
    }

    @Override
    public String getNom() {
        return "Triangle";
    }

    @Override
    public double getArea() {
        return getMida() * getMida() / 2.0;
    }
    
}
