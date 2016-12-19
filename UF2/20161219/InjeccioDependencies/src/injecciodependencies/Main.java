/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package injecciodependencies;

/**
 *
 * @author BERNAT
 * 
 */
public class Main {
    public static void main(String [] args) {
        
        Main m = new Main();
        m.ferOfertesClients(/*new Missatger()*/);
        m.ferOfertesClients(/*new Missatger()*/);
        m.ferOfertesClients(/*new Missatger()*/);
        m.ferOfertesClients(/*new Missatger()*/);
        
    }
    
    public void ferOfertesClients(/*IMissatger m*/) {
     
        IMissatger m = Missatger.getInstance();
         
        String [] emails = { "paquito@gmail.com", "paquito1@gmail.com", "paquito2@gmail.com" };
        for(String email : emails) {             
            m.enviarMissatge(email, "OFERTA", "BLAH BLAH BLAH BLAH BLAH ");
        }
    }
}
