 
package demoinjecciodam;

import demoinjecciodam.IMissatger;

/**
 *
 * @author BERNAT
 */
class MissatgerFals implements IMissatger {

    public MissatgerFals() {
    }

    @Override
    public void enviarMissatge(String email, String subject, String body) {
        System.out.println("Missatge FALS");
    }
    
}
