
package projecte.bd;

import java.util.HashMap;
import projecte.model.Producte;

/**
 *
 * @author BERNAT
 */
class ProducteBDFals implements IProducteBD {

    HashMap<Integer, Producte> mTaulaProductes;
    
    public ProducteBDFals() {
        mTaulaProductes = new HashMap<Integer, Producte>();
        mTaulaProductes.put( 
                1, //clau
                new Producte(1, "Col", 5, 23.13) //valor
        );
        mTaulaProductes.put(
                3, //clau
                new Producte(3, "Tomàquet", 19, 54.30) //valor
        );
    }

    @Override
    public void getProducteFromBD(int id, Producte p) throws Exception {

        Producte pBd = mTaulaProductes.get(id);
        if(pBd!=null) {
            p.setId(pBd.getId());
            p.setNom(pBd.getNom());
            p.setStock(pBd.getStock());
            p.setPreu(pBd.getPreu());
        }
        
        /*switch(id) {
            case 1:{
                p.setId(1);
                p.setNom("Col");
                p.setStock(5);
                p.setPreu(23.12);                
            }
            break;
            case 3: {
                p.setId(3);
                p.setNom("Tomàquet");
                p.setStock(19);
                p.setPreu(54.30);
            }
            break;
        }*/
    }

    @Override
    public void updateStock(Producte p) throws Exception {
        Producte pBd = mTaulaProductes.get(p.getId());
        if(pBd!=null) { 
            pBd.setStock(p.getStock());
        }
    }
    
}
