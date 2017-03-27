
package uml2code_daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BERNAT
 */
public class CicleFormatiu {
    private List<Grup> mGrups;
    
    private String mCodi;
    private String mNom;

    public CicleFormatiu(String mCodi, String mNom) {
        this.mCodi = mCodi;
        this.mNom = mNom;
        mGrups = new ArrayList<Grup>();
    }

    public String getmCodi() {
        return mCodi;
    }

    public String getmNom() {
        return mNom;
    }
    
    
    
    
    // encapsulació de la llista de grups
    public Grup getGrup(int index) {
        return mGrups.get(index);
    }
    
    public int getNumGrups() {
        return mGrups.size();
    }
    int i=0;
    public void addGrup(Grup pNou) {
        if(pNou==null) throw new RuntimeException("Grup null!!!");
        if(mGrups.contains(pNou)) return ;

        mGrups.add(pNou);
        pNou.setCicle(this);

    }
    
    public boolean removeGrup(Grup pAEsborrar) {
        if(pAEsborrar!=null) {
            
            boolean ok = mGrups.remove(pAEsborrar);
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
}
