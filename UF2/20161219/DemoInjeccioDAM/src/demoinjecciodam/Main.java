/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoinjecciodam;

/**
 *
 * @author BERNAT
 */
public class Main {
    public static void main(String[] args) {
                
        Main m = new Main();
        m.mailMassiu(/*new Missatger()*/);
        m.mailMassiu();
        m.mailMassiu();
        m.mailMassiu();
        m.mailMassiu();
    }
    
    public void mailMassiu(/*IMissatger m*/) {
        String [] mails = {"correu1@gmail.com",  "correu1@gmail.com","correu1@gmail.com" };
        for(String mail: mails) {
            ///Missatger m = new Missatger();
            IMissatger m = Missatger.getInstance();
            m.enviarMissatge(mail, "OFERTA", "XXXXXXXXXXXXx");
        }
    }
}
