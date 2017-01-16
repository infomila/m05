package projecte.bd;

import java.util.HashMap;
import projecte.model.Producte;

/**
 *
 * @author BERNAT
 */
class ProducteBDFaker implements IProducteBD {

    private HashMap<Integer, Producte> mProductes;
    
    public ProducteBDFaker() {
        
        mProductes = new HashMap<Integer, Producte> ();
        Producte p1 = new Producte(1, "Col", 5, 23.12);
        mProductes.put(1, p1);
        
        Producte p3 = new Producte(3, "Tomàquets", 19, 54.3);
        mProductes.put(3, p3);        
    }
    
   
    @Override
    public void getProducteFromBD(int id, Producte p) throws Exception {
        
        Producte pBd = mProductes.get(id);
        if(pBd!=null) {
            p.setId(pBd.getId());
            p.setNom(pBd.getNom());
            p.setStock(pBd.getStock());
            p.setPreu(pBd.getPreu());
        }
        
        /*
        switch(id){
            case 1: {
                p.setId(1);
                p.setNom("Col");
                p.setStock(5);
                p.setPreu(23.12);
            }break;
            case 3: {
                p.setId(3);
                p.setNom("Tomàquet");
                p.setStock(19);
                p.setPreu(54.30);
            }break;    
        }*/                
    }

    @Override
    public void updateStock(Producte p) throws Exception {

        Producte pBd = mProductes.get(p.getId());
        if(pBd!=null) {                
            pBd.setStock(p.getStock());
        }            
    }

}
