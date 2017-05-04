
package uml2code_daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author BERNAT
 */
public class CicleFormatiu {
    private List<Grup> mGrups;
    private List<Modul> mModuls;
    
    private String mCodi;
    private String mNom;

    public CicleFormatiu(String mCodi, String mNom) {
        this.mCodi = mCodi;
        this.mNom = mNom;
        mGrups = new ArrayList<Grup>();
        mModuls  = new ArrayList<Modul>();
    }

    public String getCodi() {
        return mCodi;
    }

    public String getNom() {
        return mNom;
    }
    
    
    //--------------------------------------------------------------
    // encapsulació de la llista de grups
    //--------------------------------------------------------------
    public Grup getGrup(int index) {
        return mGrups.get(index);
    }
    
    public int getNumGrups() {
        return mGrups.size();
    }
    int i=0;
    public void addGrup(Grup pNou) {
        if(pNou==null) throw new RuntimeException("Grup null!!!");
        
        // IMPORTANT: trenquem la recursivitat quan detectem que es vol 
        //            afegir un grup que ja tenim.
        if(mGrups.contains(pNou)) return ;

        mGrups.add(pNou);
        pNou.setCicle(this);

    }
    
    public boolean removeGrup(Grup pAEsborrar) {
        if(pAEsborrar!=null) {
            
            boolean ok = mGrups.remove(pAEsborrar);
            // Un cop eliminat el grup del cicle, 
            // verifiquem si el grup encara apunta al cicle
            // on ja NO pertany. En aquest cas, li posem un null
            // per mantenir la coherència.
            // El problema és que el grup queda "orfe", sense
            // cicle formatiu.
            if(pAEsborrar.getCicle()==this) {
                pAEsborrar.setCicle(null);
            }
            return ok;
        }
        return false;
    }
    
    public Grup removeGrupAt(int index) {
           return mGrups.remove(index);
    }
    
    
    public boolean teGrup(Grup pG) {
        return mGrups.contains(pG);
    }
    
    //--------------------------------------------------------------
    // encapsulació de la llista de mòduls
    //--------------------------------------------------------------
    public Modul getModul(int index) {
        return mModuls.get(index);
    }
    
    public int getNumModuls() {
        return mModuls.size();
    }
    
    public void addModul(Modul pModul) {
        if(pModul==null) throw new RuntimeException("Modul null!!!");
        
        // IMPORTANT: trenquem la recursivitat quan detectem que es vol 
        //            afegir un grup que ja tenim.
        if(mModuls.contains(pModul)) return ;

        mModuls.add(pModul);
        pModul.setCicle(this);

    }
    
    public boolean removeModul(Modul pModAEsborrar) {
        if(pModAEsborrar!=null) {
            
            boolean ok = mModuls.remove(pModAEsborrar);
            // Un cop eliminat el grup del cicle, 
            // verifiquem si el grup encara apunta al cicle
            // on ja NO pertany. En aquest cas, li posem un null
            // per mantenir la coherència.
            // El problema és que el grup queda "orfe", sense
            // cicle formatiu.
            if(pModAEsborrar.getCicle()==this) {
                pModAEsborrar.setCicle(null);
            }
            return ok;
        }
        return false;
    }
    
    public Modul removeModulAt(int index) {
           return mModuls.remove(index);
    }
    
    
    public boolean teModul(Modul pM) {
        return mModuls.contains(pM);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.mCodi);
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
        final CicleFormatiu other = (CicleFormatiu) obj;
        if (!Objects.equals(this.mCodi, other.mCodi)) {
            return false;
        }
        return true;
    }
    
    
}
