/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
