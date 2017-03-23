
package uml2code_daw;

import java.util.Objects;

/**
 *
 * @author BERNAT
 */
public class Grup {
    private CicleFormatiu mCicle;
    private int curs;
    private String subgrup;

    public Grup(int curs, String subgrup) {
        this.curs = curs;
        this.subgrup = subgrup;
    }
    
    
    
    public CicleFormatiu getCicle() {
        return mCicle;
    }

    public void setCicle(CicleFormatiu mCicle) {
        this.mCicle = mCicle;
        mCicle.addGrup(this);
    }

    public int getCurs() {
        return curs;
    }

    public String getSubgrup() {
        return subgrup;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.curs;
        hash = 19 * hash + Objects.hashCode(this.subgrup);
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
        if (this.curs != other.curs) {
            return false;
        }
        if (!Objects.equals(this.subgrup, other.subgrup)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
