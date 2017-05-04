/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml2code_dam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author BERNAT
 */
public class Alumne extends Persona {

    private int mNumMatricula;

    private List<Resultat> mResultats = new ArrayList<Resultat>();

    public Alumne(int mNumMatricula, String mDNI, String mNom, String mCognom1, String mCognom2, Date mDataNaix, Sexe mSexe) {
        super(mDNI, mNom, mCognom1, mCognom2, mDataNaix, mSexe);
        this.mNumMatricula = mNumMatricula;
    }

    //---------------------------------------------------------------
    // Mètodes per encapsular la lista de resultats
    //---------------------------------------------------------------
    public int getNumResultats() {
        return mResultats.size();
    }

    public Resultat getResultat(int index) {
        return mResultats.get(index);
    }

    public void addResultat(Resultat nou) {
        // ??
        if (!nou.getAlumne().equals(this)) {
            throw new RuntimeException("Me la estas liando");
        }

        if (!mResultats.contains(nou)) { // equals ? està programat ?
            mResultats.add(nou);
        }
    }
    //---------------------------------------------------------------

    public int getmNumMatricula() {
        return mNumMatricula;
    }

    public void setmNumMatricula(int mNumMatricula) {
        this.mNumMatricula = mNumMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.mNumMatricula;
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
        final Alumne other = (Alumne) obj;
        if (this.mNumMatricula != other.mNumMatricula) {
            return false;
        }
        return true;
    }

    Resultat getResultat(String codiCicle, int codiModul, int codiUF,
            int curs) {

        for (Resultat  r : mResultats) {
            if (       r.getUF().getCodi() == codiUF
                    && r.getUF().getModul().getCodi() == codiModul
                    && r.getUF().getModul().getCicle().getCodi() == codiCicle
                    && r.getCurs() == curs) {
                return r;
            }
        }
        return null;
    }

}
