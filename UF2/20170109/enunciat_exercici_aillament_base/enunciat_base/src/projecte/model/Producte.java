package projecte.model;

import projecte.bd.IProducteBD;
import projecte.bd.ProducteBD;
import projecte.missatgeria.Missatgeria;
import projecte.missatgeria.iMissatgeria;

/**
 * Classe del Model de Domini
 * @author Bernat
 *
 */
public class Producte {

    private int id;
    private String nom;
    private int stock;
    private double preu;
    private static int MINIM_STOCK = 5;

    public Producte(int id, String nom, int stock, double preu) {
        this.id = id;
        this.nom = nom;
        this.stock = stock;
        this.preu = preu;
    }
    
    
    
    public Producte( int codi ) throws Exception{
        this.id = codi;
        ProducteBD pBD  = new ProducteBD();
        pBD.getProducteFromBD(codi, this);
    }

    public static int getStockMinim() {
        return MINIM_STOCK;
    }
    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getNom() {
            return nom;
    }
    public void setNom(String nom) {
            this.nom = nom;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int nouStock)
    {
     this.stock = nouStock;
    }

    public void desarCanvisStock(iMissatgeria m) throws Exception
    {
        //Missatgeria m = new Missatgeria();        
        if(stock < MINIM_STOCK ) m.enviar(
                    Missatgeria.MAGATZEM,
                    "Atenció, producte "+id+" amb només "+stock+" unitats.");
        
        
        IProducteBD pBD = ProducteBD.getInstance();
        pBD.updateStock(this);
        
    }
    
    public void variacioStock(int increment) throws Exception{
        
        if(stock+increment<0) throw new Exception("Variació d'estock no possible, unitats insufucients");
        this.stock += increment;    
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
        
        
}
