package projecte.missatgeria;

/**
 *
 * @author BERNAT
 */
public class MissatgeriaFalsa implements iMissatgeria {

    @Override
    public void enviar(String departament, String missatge) throws Exception {
        System.out.println("Enviament FALS a " + departament);
    }    
}
