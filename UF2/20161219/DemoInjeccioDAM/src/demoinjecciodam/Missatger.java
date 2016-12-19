
package demoinjecciodam;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BERNAT
 */
public class Missatger implements IMissatger{
    
    private Missatger(){
        System.out.println("Constructor de Missatger");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Missatger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMissatge( String email, String subject, String body) {
        
        // FEINA FEINA FEINA
        
        System.out.println("Correu REAL enviat!");
        
    }
    //------------------------------------------
    private static Missatger _singleton;
    private static boolean mModeTest = false;
    public static IMissatger getInstance() {
        if(mModeTest) {
            return new MissatgerFals();
        } else {
            if(_singleton==null) {
                _singleton = new Missatger();
            }
            return _singleton;
        }
    }
    public static void setModeTest(boolean pModeTest) {
        mModeTest = pModeTest;
    }
}
