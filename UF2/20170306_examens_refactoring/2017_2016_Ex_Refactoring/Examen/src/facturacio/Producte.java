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
    private TipusProdEnum tipus;
    
    /**
     *  tipus de productes vàlids
     */


    public Producte(int codi, String nom, BigDecimal preu, TipusProdEnum tipus, double tipusIva) {
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

    public double getPreuBase() {
        return preu.doubleValue();
    }

    public void setPreu(BigDecimal preu) {
        this.preu = preu;
    }

    public TipusProdEnum getTipus() {
        return tipus;
    }

    public void setTipus(TipusProdEnum tipus) {
        this.tipus = tipus;
    }
    
     public double getTipusIva() {
        return tipusIva;
    }

    public void setTipusIva(double tipusIva) {
        this.tipusIva = tipusIva;
    }
    
    public double getPreu(int unitats) {
        
        double preuProducte = getPreuBase();
        
            switch (getTipus()) {
                case EN_LIQUIDACIO: {
                    return  preuProducte * 0.30;
    
                }
                case EN_PROMOCIO_2X1: {
                    int unitatsPagades = (int) (unitats / 2);
                    // Si el nombre  de productes es senar, cal incrementar en un les unitats pagades
                    unitatsPagades += unitats % 2;
                    return preuProducte * (unitatsPagades / (double) unitats);
                    
                }
                case NOVETAT: {
                    return preuProducte * 1.30;

                }
                case NORMAL: {
                    double descompteRappel = 0;
                    if (unitats >= 50 && unitats < 100) {
                        descompteRappel = 10;
                    } else if (unitats >= 100 && unitats < 200) {
                        descompteRappel = 20;
                    } else if (unitats >= 200) {
                        descompteRappel = 30;
                    }
                    return preuProducte * (1 - descompteRappel / 100);

                }
                default:
                    throw new RuntimeException();
            }
    }

    public String getDescripcioTipus() {
        switch (getTipus()) {
                case EN_LIQUIDACIO:    return  "LIQUIDACIO";
                case EN_PROMOCIO_2X1:  return  "2X1";
                case NOVETAT:          return "NOVETAT";
                case NORMAL:           return "NORMAL"; 
                default:
                    throw new RuntimeException();
        }
    }
    
}
