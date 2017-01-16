package projecte.bd;

import projecte.model.Producte;

/**
 *
 * @author BERNAT
 */
public interface IProducteBD {

    void getProducteFromBD(int id, Producte p) throws Exception;

    void updateStock(Producte p) throws Exception;
    
}
