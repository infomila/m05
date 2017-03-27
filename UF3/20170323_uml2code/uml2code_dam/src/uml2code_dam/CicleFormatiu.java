/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml2code_dam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author BERNAT
 */
public class CicleFormatiu {
    private String codi;
    private String nom;

    // atribut derivat de la relació 1..* amb Grup
    private List<Grup> mGrups;

    public CicleFormatiu(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
        mGrups = new ArrayList<Grup>();
    }

    //--------------------------------------------
    // Mètodes per encapsular la llista de grups
    /**
     * Accés per índex
     * @return 
     */
    public Grup getGrup(int pIndex){
        return mGrups.get(pIndex);
    }
    /**
     * retorna el nombre de grups
     * @return 
     */
    public int getNumGrups(){
        return mGrups.size();
    }
    
    public Iterator<Grup> getIteratorGrup() {
        return mGrups.iterator();
    }
    //-----------------------------------------------
    public void afegirGrup(Grup pNouGrup){
        
        if(mGrups.contains(pNouGrup)) return;
        
        mGrups.add(pNouGrup);
        pNouGrup.setCicle(this);
    }
    public Grup esborrarGrup(int pIndex) {
        return mGrups.remove(pIndex);
    }
    
    public boolean esborrarGrup(Grup pGrupAEsborrar) {
        
        boolean esborrat = mGrups.remove(pGrupAEsborrar);
        
        //Només esborrar la referència del grup si nosaltres
        // som el seu cicle formatiu
        if(pGrupAEsborrar.getCicle()==this) {
            pGrupAEsborrar.setCicle(null);
        }
        return esborrat;
        
    }
    //--------------------------------------------

    
    
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    Object teGrup(Grup segon) {
        return mGrups.contains(segon);
    }

}
