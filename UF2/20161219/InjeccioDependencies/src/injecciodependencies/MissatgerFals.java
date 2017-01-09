package injecciodependencies;

import injecciodependencies.IMissatger;

/**
 *
 * @author BERNAT
 */
public class MissatgerFals implements IMissatger {

    @Override
    public void enviarMissatge(String email, String body, String content) {
        // NO FER RES
        System.out.println("SOC FALLLLLS !!!!!");
    }
    
}
