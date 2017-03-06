
package facturacio;

/**
 * Linia d'una factura. Conté una referència al producte, el número d'unitats d'aquest i 
 * el percentatge de descompte i el tipus d'IVA aplicable ( ambdós en tant per 100 )
 * @author bernat
 */
public class LiniaFactura {
    private Producte prod;
    private int numeroUnitats;
    

    public LiniaFactura(Producte prod, int numeroUnitats ) {
        this.prod = prod;
        this.numeroUnitats = numeroUnitats;
    }

     
    public int getNumeroUnitats() {
        return numeroUnitats;
    }

    public void setNumeroUnitats(int numeroUnitats) {
        this.numeroUnitats = numeroUnitats;
    }

    public Producte getProd() {
        return prod;
    }

    public void setProd(Producte prod) {
        this.prod = prod;
    }


    
    
}
