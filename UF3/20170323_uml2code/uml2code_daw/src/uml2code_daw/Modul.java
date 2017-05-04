package uml2code_daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author BERNAT
 */
public class Modul {

    private CicleFormatiu mCicle;
    private List<UF> mUFs;
    private int mCodi;
    private String mNom;

    public static class UF {

        private int mCodi;
        private String mNom;
        private int mHores;
        private Modul mModul;
        private List<Resultat> mResultats;

        public UF(Modul pModul, int mCodi, String mNom, int mHores) {
            this.mModul = pModul;
            this.mCodi = mCodi;
            this.mNom = mNom;
            this.mHores = mHores;

            this.mResultats = new ArrayList<Resultat>();
            
            if(!mModul.addUF(this)) throw new RuntimeException("REPE");
        }
        
        //-------------------------------------------------------
        // encapsular llista de resultats
        //-------------------------------------------------------
        public int getNumResultats(){
            return mResultats.size();
        }
        public Resultat getResultat(int index ) {
            return mResultats.get(index);
        }        
        public void addResultat(Resultat r) {
            if(r.getUF().equals(this)) {
                mResultats.add(r);
            } else {
                throw new RuntimeException("Resultat i UF incoherents");
            }
        }
        //-------------------------------------------------------


        public Modul getModul() {
            return mModul;
        }

        public int getCodi() {
            return mCodi;
        }

        public String getNom() {
            return mNom;
        }

        public int getHores() {
            return mHores;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + this.mCodi;
            hash = 83 * hash + Objects.hashCode(this.mModul);
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
            final UF other = (UF) obj;
            if (this.mCodi != other.mCodi) {
                return false;
            }
            if (!Objects.equals(this.mModul, other.mModul)) {
                return false;
            }
            return true;
        }

       

    }

    public Modul(CicleFormatiu pCicle, int pCodi, String pNom) {
        setCicle(pCicle);
        this.mCodi = pCodi;
        this.mNom = pNom;
        this.mUFs = new ArrayList<UF>();
    }

    public int getNumUFs() {
        return mUFs.size();
    }

    public UF getUF(int index) {
        return mUFs.get(index);
    }

    private boolean addUF(UF nova) {
        if (!mUFs.contains(nova)) {
            mUFs.add(nova);
            return true;
        }
        return false;
    }

    public UF removeUF(int index) {
        return mUFs.remove(index);
    }

    public CicleFormatiu getCicle() {
        return mCicle;
    }

    public void setCicle(CicleFormatiu pCicle) {
        System.out.println("setCicle" + pCicle);

        // IMPORTANT: trenquem la recursivitat quan detectem que es vol 
        //            assignar un cicle que ja és el nostre        
        if (this.mCicle == pCicle) {
            return; //res a fer !
        }
        CicleFormatiu oldMCicle = this.mCicle;
        // Important, canviar el cicle abans de donar-se de baixa del vell.
        // Ens evita caure en recursivitat de nou.
        this.mCicle = pCicle;
        if (oldMCicle != null) {
 
            boolean esborrat = oldMCicle.removeModul(this);
            System.out.println("esborrat..." + esborrat);
        }

        // afegir el grup només si el cicle no és null
        if (this.mCicle != null) {
            this.mCicle.addModul(this);
        }
    }

    public int getCodi() {
        return mCodi;
    }

    public String getNom() {
        return mNom;
    }
/*
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.mCicle);
        hash = 67 * hash + this.mCodi;
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
        final Modul other = (Modul) obj;
        if (!Objects.equals(this.mCicle, other.mCicle)) {
            return false;
        }
        if (this.mCodi != other.mCodi) {
            return false;
        }
        return true;
    }
*/
    
}
