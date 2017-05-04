package uml2code_daw;

import java.util.Objects;

/**
 *
 * @author BERNAT
 */
public class Resultat {
    private Alumne mAlumne;
    private Modul.UF mUF;
    private int MCurs;
    
    private int mNotaOrdinaria;
    private int mNotaExtraordinaria;

    public Resultat(Alumne mAlumne, Modul.UF mUF, int MCurs) {
        
        
        this.mAlumne = mAlumne;
        this.mAlumne.addResultat(this);        
        
        this.mUF = mUF;        
        this.mUF.addResultat(this);
        
        this.MCurs = MCurs;
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
    
    

    public Alumne getAlumne() {
        return mAlumne;
    }

    public Modul.UF getUF() {
        return mUF;
    }

    public int getCurs() {
        return MCurs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.mAlumne);
        hash = 43 * hash + Objects.hashCode(this.mUF);
        hash = 43 * hash + this.MCurs;
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
        if (this.MCurs != other.MCurs) {
            return false;
        }
        return true;
    }
    
    
    
    
}
