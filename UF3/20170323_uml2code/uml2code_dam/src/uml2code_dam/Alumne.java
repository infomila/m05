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
public class Alumne extends Persona{
    private int mNumMatricula;
    
    public Alumne(int mNumMatricula, String mDNI, String mNom, String mCognom1, String mCognom2, Date mDataNaix, Sexe mSexe) {
        super(mDNI, mNom, mCognom1, mCognom2, mDataNaix, mSexe);
        this.mNumMatricula = mNumMatricula;
    }
               
    
    public int getmNumMatricula() {
        return mNumMatricula;
    }

    public void setmNumMatricula(int mNumMatricula) {
        this.mNumMatricula = mNumMatricula;
    }
    
    
    
}
