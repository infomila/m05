
package uml2code_daw;

import java.util.Objects;

/**
 *
 * @author BERNAT
 */
public class Grup {
    private CicleFormatiu mCicle;
    private int mCurs;
    private String mSubgrup;

    public Grup(CicleFormatiu cicle, int curs, String subgrup) {
        setCicle(cicle);
        this.mCurs = curs;
        this.mSubgrup = subgrup;
    }
    
    
    
    public CicleFormatiu getCicle() {
        return mCicle;
    }

    public void setCicle(CicleFormatiu pCicle) {
        System.out.println("setCicle"+pCicle);
        
        // IMPORTANT: trenquem la recursivitat quan detectem que es vol 
        //            assignar un cicle que ja és el nostre        
        if(this.mCicle==pCicle) return; //res a fer !
        
        CicleFormatiu oldMCicle = this.mCicle;
        // Important, canviar el cicle abans de donar-se de baixa del vell.
        // Ens evita caure en recursivitat de nou.
        this.mCicle = pCicle;
        if(oldMCicle!=null) {
            System.out.println("esborrat...");
            oldMCicle.removeGrup(this);      
        }
        
        // afegir el grup només si el cicle no és null
        if(this.mCicle!=null) this.mCicle.addGrup(this);
    }

    public int getCurs() {
        return mCurs;
    }

    public String getSubgrup() {
        return mSubgrup;
    }

    /*
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.mCurs;
        hash = 19 * hash + Objects.hashCode(this.mSubgrup);
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
    */
    
    
    
    
}
