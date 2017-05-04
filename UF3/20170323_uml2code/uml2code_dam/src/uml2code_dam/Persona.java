package uml2code_dam;

import java.util.Date;

/**
 *
 * @author BERNAT
 */
public class Persona {
    
    public enum Sexe {
        HOME,DONA,ND
    }
    
    private static int _totalEmpleats;
    
    private String  mNIF;
    private String  mNom;
    private String  mCognom1,mCognom2;
    private Date    mDataNaix;
    private Sexe    mSexe;

    public Persona(String mNIF, String mNom, String mCognom1, String mCognom2, Date mDataNaix, Sexe mSexe) {
        this.mNIF = mNIF;
        this.mNom = mNom;
        this.mCognom1 = mCognom1;
        this.mCognom2 = mCognom2;
        this.mDataNaix = mDataNaix;
        this.mSexe = mSexe;
    }

    public static int getTotalEmpleats() {
        return _totalEmpleats;
    }

    public static void setTotalEmpleats(int _totalEmpleats) {
        Persona._totalEmpleats = _totalEmpleats;
    }

    public String getNIF() {
        return mNIF;
    }

    public void setNIF(String NIF) {
        this.mNIF = NIF;
    }

    public String getmNom() {
        return mNom;
    }

    public void setmNom(String mNom) {
        this.mNom = mNom;
    }

    public String getmCognom1() {
        return mCognom1;
    }

    public void setmCognom1(String mCognom1) {
        this.mCognom1 = mCognom1;
    }

    public String getmCognom2() {
        return mCognom2;
    }

    public void setmCognom2(String mCognom2) {
        this.mCognom2 = mCognom2;
    }

    public Date getmDataNaix() {
        return mDataNaix;
    }

    public void setmDataNaix(Date mDataNaix) {
        this.mDataNaix = mDataNaix;
    }

    public Sexe getmSexe() {
        return mSexe;
    }

    public void setmSexe(Sexe mSexe) {
        this.mSexe = mSexe;
    }
    
    
    
}
