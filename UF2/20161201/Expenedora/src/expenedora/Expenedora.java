/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenedora;

/**
 *
 * @author BERNAT
 */
public class Expenedora {

    public enum TipusCanvi {   
        VENDA_OK_CANVI_EXACTE, // es fa la venda i retorna el canvi exacte  
        VENDA_OK_NO_TE_CANVI,   // es fa la venda, però retorna menys quantitat ja que no té prou canvi   
        VENDA_FAIL_IMPORT_INSUFICIENT, // no fa la venda, el client no ha posat prous monedes   VENDA_FAIL_ERROR_DADES   // no fa la venda, hi ha error a les dades proporcionades. 
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    

    public  TipusCanvi pagarMetalic( 
            int preuEnCentims, byte[] monedesClient, byte[] monedesCaixa) { 
        
        return TipusCanvi.VENDA_OK_CANVI_EXACTE;
        
    }    
    
    
    
    
}
