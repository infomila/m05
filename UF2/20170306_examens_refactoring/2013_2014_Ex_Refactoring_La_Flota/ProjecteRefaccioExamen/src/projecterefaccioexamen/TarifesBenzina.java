package projecterefaccioexamen;

/**
 *
 * @author BERNAT
 */
public class TarifesBenzina {
 
    
    public static double getPreuLitre( TipusBenzina tipusBenzina ){
        switch(tipusBenzina) {
            case GASOIL: return 1.34;
            case GASOLINA_95: return 1.47;
            default:throw new RuntimeException("Tipus benzina invàlid.");
        }
    }
}
