/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml2code_dam;

import java.util.Objects;

/**
 *
 * @author BERNAT
 */
public class Grup {
    
    private int mCurs;
    private String mSubgrup;

    // atribut derivat de la relació
    private CicleFormatiu mCicle;
    
    
    public Grup(CicleFormatiu cicle, int curs, String subgrup) {
        setCicle(cicle);
        this.mCurs = curs;
        this.mSubgrup = subgrup;
    }

    public CicleFormatiu getCicle() {
        return mCicle;
    }

    public void setCicle(CicleFormatiu pCicle) {
        
        if(pCicle== this.mCicle) return; // evitem recusivitat
        
        CicleFormatiu cicleAnterior = this.mCicle;
        this.mCicle = pCicle;
        if( cicleAnterior!=null) {
            // abans estava connectat a un altre cicle
            cicleAnterior.removeGrup(this);
        }
        if(mCicle!=null) {
            mCicle.addGrup(this);
        }
    }

    
    
    public int getCurs() {
        return mCurs;
    }

    public void setCurs(int curs) {
        this.mCurs = curs;
    }

    public String getSubgrup() {
        return mSubgrup;
    }

    public void setSubgrup(String subgrup) {
        this.mSubgrup = subgrup;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.mCurs;
        hash = 11 * hash + Objects.hashCode(this.mSubgrup);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grup other = (Grup) obj;
        if (this.mCurs != other.mCurs) {
            return false;
        }
        if (!Objects.equals(this.mSubgrup, other.mSubgrup)) {
            return false;
        }
        return true;
    }
    
    
}
