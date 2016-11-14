/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojunit;

import java.math.BigDecimal;

/**
 *
 * @author BERNAT
 */
public class Segurata {
    
    
public boolean pucEntrar(int edat) {
        if(edat<0||edat>130) throw new RuntimeException();
                 
        return (edat>=16) ;
         
    }    
    
    /**
     *  SEMPRE entra si és coleguilla.
     *  Si no és coleguilla.
     * 
     * 
     * @param edat
     * @param coleguilla
     * @param suborn
     * @return 
     */
    
    
    public boolean pucEntrar( 
            int edat , 
            boolean coleguilla, 
            float suborn) {
        if(edat<0||edat>130||suborn<0) throw new RuntimeException();
        
        if(coleguilla) return true;
        
        if(edat>=16) return true;
        else if(edat>10) 
        {
            return (suborn>=10);
        }else {
            return (suborn>=20);
        }   
    }
}
