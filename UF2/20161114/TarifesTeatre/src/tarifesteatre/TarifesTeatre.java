
package tarifesteatre;

/**
 *
 * @author BERNAT
 */
public class TarifesTeatre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
 
    public enum TipusSeient {
        PLATEA(60),
        LATERAL(50),
        PRIMER_PIS(40),
        SEGON_PIS(30);
        
        private double mPreu;
        TipusSeient (double preu) {
            mPreu = preu;
        }
        public double getPreu(){ return mPreu;}

    }
    
    public double getPreu(TipusSeient tipus, int edat) {
        //<4 anys: no paga
        if(edat<4) return 0;
        // [4-12) anys: 25% descompte sobre el seient.
        if(edat<12) return tipus.getPreu()*0.75;
        
        //[12-60): tarifa normal
        if(edat<60) return tipus.getPreu() ;

        //edat>=60: 50% descompte a platea, la resta al 80% de descompte.
        if(tipus==TipusSeient.PLATEA) 
            return tipus.getPreu()*0.5;
        else 
            return tipus.getPreu()*0.8;

    }
    
}
