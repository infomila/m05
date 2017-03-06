/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacio;

import java.math.BigDecimal;


/**
 * Representació d'un producte.
 * @author bernat
 */
public class Producte {
    private int codi;
    private String nom;
    private BigDecimal preu;
    private double tipusIva;
    private int tipus;
    
    /**
     *  tipus de productes vàlids
     */
    public static final int EN_PROMOCIO_2X1   = 0;
    public static final int EN_LIQUIDACIO     = 1;
    public static final int NOVETAT           = 2;
    public static final int NORMAL            = 3;
    

    public Producte(int codi, String nom, BigDecimal preu, int tipus, double tipusIva) {
        this.codi = codi;
        this.nom = nom;
        this.preu = preu;
        this.tipus = tipus;
        this.tipusIva = tipusIva;        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public double getPreu() {
        return preu.doubleValue();
    }

    public void setPreu(BigDecimal preu) {
        this.preu = preu;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }
    
     public double getTipusIva() {
        return tipusIva;
    }

    public void setTipusIva(double tipusIva) {
        this.tipusIva = tipusIva;
    }
    
}
