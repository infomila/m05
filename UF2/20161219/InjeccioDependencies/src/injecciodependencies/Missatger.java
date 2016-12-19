
package injecciodependencies;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BERNAT
 */
public class Missatger implements IMissatger{
    
    
    private Missatger() {
       System.out.println("Estic creant un Missatger"); 
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Missatger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMissatge(String email, String body, String content){
        // enviament real del missatge
        System.out.println("Enviament REAL a "+ email);
    }
    
    //---------- FABRICA + SINGLETON --------------------------------------------
    private static boolean mModeTest = false;
    
    private static Missatger _singleton;
    
    public static IMissatger getInstance(){
        if(mModeTest) {
            return new MissatgerFals();
        } else {
            if(_singleton==null) {
                _singleton = new Missatger();
            }
            return _singleton;
        }
    }
    public static void setModeTest( boolean pIsTestMode) {
        mModeTest = pIsTestMode;
    }
    
}
