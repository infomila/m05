package projecte.missatgeria;


import java.util.HashMap;


/**
 *
 * @author bernat
 */
public class Missatgeria implements iMissatgeria {

    private HashMap<String,String> emails;
    
    public static String MAGATZEM = "MAG";
    public static String COMPRES = "COM";
    public static String VENDES = "VEN";
    
    public Missatgeria() {
        emails = new HashMap<String,String>();
        emails.put(COMPRES, "compres@empresa.com");
        emails.put(VENDES, "vendes@empresa.uk");
        emails.put(MAGATZEM, "warehouse@empresa.es");
    }
    
    public String getAdrecaEmail(String departament)
    {
            return emails.get(departament);
    }
    
    @Override
    public void enviar(String departament, String missatge ) throws Exception
    {
        String email = getAdrecaEmail(departament);
        if(email==null) throw new Exception("Departament no existent");
        Email e = new Email();
        e.enviarEmail(email, "Missatge Intern" ,missatge);
    }
    
}
