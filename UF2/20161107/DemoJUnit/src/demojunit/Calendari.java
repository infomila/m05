package demojunit;

/**
 *
 * @author BERNAT
 */
public class Calendari {
    
    public boolean esDiaFestiu( int dia, int mes, int anyo) {
        
        if( dia<=0||mes<=0||anyo<=0) throw new RuntimeException("PUFFFFF");
        
        // IMPLEMENTACIÓ  FAKE
        if(dia==25 && mes == 12) return true;
        
        return false;
    }
    
}
