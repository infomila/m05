
package uml2code_dam;

import java.util.Objects;

/**
 *
 * @author BERNAT
 */
public class Resultat {
    
    private Alumne mAlumne;
    private Modul.UF mUF;
    private int mCurs;
    
    private int mNotaOrdinaria;
    private int mNotaExtraordinaria;

    public Resultat(Alumne mAlumne, Modul.UF mUF, int mCurs) {
        this.mAlumne = mAlumne;
        this.mUF = mUF;
        this.mCurs = mCurs;
        
        mAlumne.addResultat(this);
        mUF.addResultat(this);
    }

    public Alumne getAlumne() {
        return mAlumne;
    }

    public Modul.UF getUF() {
        return mUF;
    }

    public int getCurs() {
        return mCurs;
    }

    public int getmNotaOrdinaria() {
        return mNotaOrdinaria;
    }

    public void setmNotaOrdinaria(int mNotaOrdinaria) {
        this.mNotaOrdinaria = mNotaOrdinaria;
    }

    public int getmNotaExtraordinaria() {
        return mNotaExtraordinaria;
    }

    public void setmNotaExtraordinaria(int mNotaExtraordinaria) {
        this.mNotaExtraordinaria = mNotaExtraordinaria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.mAlumne);
        hash = 61 * hash + Objects.hashCode(this.mUF);
        hash = 61 * hash + this.mCurs;
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
        final Resultat other = (Resultat) obj;
        if (!Objects.equals(this.mAlumne, other.mAlumne)) {
            return false;
        }
        if (!Objects.equals(this.mUF, other.mUF)) {
            return false;
        }
        if (this.mCurs != other.mCurs) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
