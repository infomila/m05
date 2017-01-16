package projecte.missatgeria;

/**
 *
 * @author BERNAT
 */
public class MissatgeriaFaker implements iMissatgeria {

    @Override
    public void enviar(String departament, String missatge) throws Exception {
        System.out.println("Missatge enviat (FALLLLS)");
    }
    
}
